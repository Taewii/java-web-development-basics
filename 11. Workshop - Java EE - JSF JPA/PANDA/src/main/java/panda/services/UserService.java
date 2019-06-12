package panda.services;

import panda.domain.models.binding.UserLoginBindingModel;
import panda.domain.models.binding.UserRegisterBindingModel;
import panda.domain.models.view.LoggedInUserViewModel;

import java.util.Optional;

public interface UserService {

    void register(UserRegisterBindingModel user);

    Optional<LoggedInUserViewModel> login(UserLoginBindingModel model);
}
