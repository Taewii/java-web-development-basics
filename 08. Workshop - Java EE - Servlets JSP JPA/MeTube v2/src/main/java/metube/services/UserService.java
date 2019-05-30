package metube.services;

import metube.domain.entities.User;
import metube.domain.models.binding.RegisterBindingModel;

public interface UserService {

    void save(RegisterBindingModel user);

    User find(String username, String password);

    boolean isUserAdmin(String username);
}
