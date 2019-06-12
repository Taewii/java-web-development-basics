package panda.web.beans.user;

import lombok.NoArgsConstructor;
import panda.domain.models.binding.UserRegisterBindingModel;
import panda.services.UserService;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
@NoArgsConstructor
public class UserRegisterBean extends BaseBean {

    private UserRegisterBindingModel model = new UserRegisterBindingModel();

    private UserService userService;

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
