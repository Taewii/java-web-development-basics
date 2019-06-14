package panda.services;

import panda.domain.entities.User;
import panda.domain.models.binding.UserLoginBindingModel;
import panda.domain.models.binding.UserRegisterBindingModel;
import panda.domain.models.view.user.LoggedInUserViewModel;
import panda.domain.models.view.user.UserOptionViewModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean register(UserRegisterBindingModel user);

    Optional<LoggedInUserViewModel> login(UserLoginBindingModel model);

    List<UserOptionViewModel> userOptionViewModels();

    User findByIdWithPackages(String id);

    User findByIdWithReceipts(String id);

    void update(User user);
}
