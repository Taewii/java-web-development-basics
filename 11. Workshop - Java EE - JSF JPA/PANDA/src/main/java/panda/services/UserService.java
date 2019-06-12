package panda.services;

import panda.domain.entities.User;
import panda.domain.models.binding.UserLoginBindingModel;
import panda.domain.models.binding.UserRegisterBindingModel;
import panda.domain.models.view.LoggedInUserViewModel;
import panda.domain.models.view.UserOptionViewModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void register(UserRegisterBindingModel user);

    Optional<LoggedInUserViewModel> login(UserLoginBindingModel model);

    List<UserOptionViewModel> userOptionViewModels();

    User findByIdWithPackages(String id);

    void update(User user);
}
