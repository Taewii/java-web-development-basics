package panda.web.beans;

import lombok.NoArgsConstructor;
import panda.domain.models.UserRegisterBindingModel;
import panda.services.UserService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
@NoArgsConstructor
public class UserRegisterBean extends BaseBean {

    private UserService userService;

    private UserRegisterBindingModel model = new UserRegisterBindingModel();

    @Inject
    public UserRegisterBean(UserService userService) {
        this.userService = userService;
    }

    public void register() {
        this.userService.register(this.model);
        super.redirect("/");
    }

    public UserRegisterBindingModel getModel() {
        return this.model;
    }
}
