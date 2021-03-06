package panda.web.beans.user;

import lombok.NoArgsConstructor;
import panda.domain.models.binding.UserLoginBindingModel;
import panda.services.UserService;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Model
@NoArgsConstructor
public class UserLoginBean extends BaseBean {

    private UserLoginBindingModel model = new UserLoginBindingModel();

    private UserService userService;

    @Inject
    public UserLoginBean(UserService userService) {
        this.userService = userService;
    }

    public void login() {
        this.userService.login(this.model).ifPresentOrElse(user -> {
            HttpSession session = (HttpSession) super.externalContext.getSession(true);
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());
            super.redirect("/");
        }, super.addMessageRunnable("Login failed. Check username or password"));
    }

    public UserLoginBindingModel getModel() {
        return this.model;
    }
}
