package panda.services;

import org.modelmapper.ModelMapper;
import panda.domain.entities.User;
import panda.domain.enums.Role;
import panda.domain.models.binding.UserLoginBindingModel;
import panda.domain.models.binding.UserRegisterBindingModel;
import panda.domain.models.view.user.LoggedInUserViewModel;
import panda.domain.models.view.user.UserOptionViewModel;
import panda.repositories.UserRepository;
import panda.util.ModelValidator;
import panda.util.PasswordHash;

import javax.ejb.EJBTransactionRolledbackException;
import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean register(UserRegisterBindingModel user) {
        String violationsMessage = ModelValidator.validateModel(user);
        if (violationsMessage != null || !user.getPassword().equals(user.getConfirmPassword())) {
            return false;
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
        } catch (EJBTransactionRolledbackException e) {
            return false;
        }

        return true;
    }

    @Override
    public Optional<LoggedInUserViewModel> login(UserLoginBindingModel model) {
        String violationsMessage = ModelValidator.validateModel(model);
        if (violationsMessage != null) {
            throw new IllegalArgumentException(violationsMessage);
        }

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

    @Override
    public List<UserOptionViewModel> userOptionViewModels() {
        return this.userRepository
                .findAll()
                .stream()
                .map(user -> this.mapper.map(user, UserOptionViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public User findByIdWithPackages(String id) {
        return this.userRepository.findByIdWithPackages(id);
    }

    @Override
    public User findByIdWithReceipts(String id) {
        return this.userRepository.findByIdWithReceipts(id);
    }

    @Override
    public void update(User user) {
        this.userRepository.update(user);
    }
}
