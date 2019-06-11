package panda.services;

import panda.domain.models.UserRegisterBindingModel;

public interface UserService {

    void register(UserRegisterBindingModel user);
}
