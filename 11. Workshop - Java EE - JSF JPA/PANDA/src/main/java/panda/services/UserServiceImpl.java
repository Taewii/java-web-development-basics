package panda.services;

import org.modelmapper.ModelMapper;
import panda.domain.entities.User;
import panda.domain.enums.Role;
import panda.domain.models.binding.UserLoginBindingModel;
import panda.domain.models.binding.UserRegisterBindingModel;
import panda.domain.models.view.LoggedInUserViewModel;
import panda.repositories.UserRepository;
import panda.util.PasswordHash;

import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Validator validator;
    private final ModelMapper mapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, Validator validator, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public void register(UserRegisterBindingModel user) {
        Set<ConstraintViolation<UserRegisterBindingModel>> violations = this.validator.validate(user);
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
        entity.setRole(this.userRepository.isTableEmpty() ? Role.ADMIN : Role.USER);

        try {
            this.userRepository.save(entity);
        } catch (EJBTransactionRolledbackException e) { // TODO: 30.5.2019 г. figure out how handle this correctly
            throw new IllegalArgumentException("Username/e-mail is already in use.");
        }
    }

    @Override
    public Optional<LoggedInUserViewModel> login(UserLoginBindingModel model) {
        return this.userRepository.findByAttributeAndValue("username", model.getUsername())
                .stream()
                .filter(user -> {
                    boolean valid = false;
                    try {
                        valid = PasswordHash.validatePassword(model.getPassword(), user.getPassword());
                    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                        e.printStackTrace();
                    }

                    return valid;
                })
                .map(user -> this.mapper.map(user, LoggedInUserViewModel.class))
                .findFirst();
    }
}
