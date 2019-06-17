package exodia.services;

import exodia.domain.entities.User;
import exodia.domain.models.binding.UserLoginBindingModel;
import exodia.domain.models.binding.UserRegisterBindingModel;
import exodia.domain.models.view.LoggedInUserViewModel;

import java.util.Optional;

public interface UserService {

    boolean register(UserRegisterBindingModel user);

    Optional<LoggedInUserViewModel> login(UserLoginBindingModel model);

    void update(User user);
}
