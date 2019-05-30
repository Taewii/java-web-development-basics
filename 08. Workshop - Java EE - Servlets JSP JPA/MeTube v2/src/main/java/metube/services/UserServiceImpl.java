package metube.services;

import metube.domain.entities.User;
import metube.domain.enums.UserRole;
import metube.domain.models.binding.RegisterBindingModel;
import metube.repositories.UserRepository;
import metube.util.PasswordHash;
import org.modelmapper.ModelMapper;

import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Set;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final ModelMapper mapper;
    private final Validator validator;

    @Inject
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleService userRoleService,
                           ModelMapper mapper,
                           Validator validator) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public void save(RegisterBindingModel user) {
        Set<ConstraintViolation<RegisterBindingModel>> violations = this.validator.validate(user);
        String message;
        if (!violations.isEmpty() || !user.getPassword().equals(user.getConfirmPassword())) {
            message = violations.stream().map(v -> String.format("%s value '%s' %s", v.getPropertyPath(),
                    v.getInvalidValue(), v.getMessage()))
                    .collect(Collectors.joining(", "));
            if (!user.getPassword().equals(user.getConfirmPassword())) {
                message += "Passwords don't match";
            }
            throw new IllegalArgumentException(message);
        }

        try {
            user.setPassword(PasswordHash.createHash(user.getPassword()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        User entity = this.mapper.map(user, User.class);
        if (this.userRepository.isTableEmpty()) {
            entity.addRole(this.userRoleService.findByType(UserRole.ADMIN));
        }

        entity.addRole(this.userRoleService.findByType(UserRole.REGULAR));

        try {
            this.userRepository.update(entity);
        } catch (EJBTransactionRolledbackException e) { // TODO: 30.5.2019 г. figure out how handle this correctly
            throw new IllegalArgumentException("Username/e-mail is already in use.");
        }
    }

    @Override
    public User find(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        boolean validatePassword = false;

        if (user == null) {
            return null;
        }

        try {
            validatePassword = PasswordHash.validatePassword(password, user.getPassword());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return validatePassword ? user : null;
    }

    @Override
    public boolean isUserAdmin(String username) {
        User user = this.userRepository.findByUsernameWithRoles(username);
        if (user == null) {
            return false;
        }

        return user.getRoles().stream().anyMatch(ur -> ur.getRole() == UserRole.ADMIN);
    }
}
