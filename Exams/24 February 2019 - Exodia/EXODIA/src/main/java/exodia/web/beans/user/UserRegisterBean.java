package exodia.web.beans.user;

import exodia.domain.models.binding.UserRegisterBindingModel;
import exodia.services.UserService;
import exodia.web.beans.BaseBean;
import lombok.NoArgsConstructor;

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
        if (this.userService.register(this.model)) {
            super.redirect("/login");
        } else {
            super.addMessage("Registration failed. Please try again.");
        }
    }

    public UserRegisterBindingModel getModel() {
        return this.model;
    }
}
