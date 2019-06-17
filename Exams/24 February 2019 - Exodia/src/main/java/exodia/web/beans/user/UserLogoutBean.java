package exodia.web.beans.user;

import exodia.web.beans.BaseBean;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Model;

@Model
@NoArgsConstructor
public class UserLogoutBean extends BaseBean {

    public void logout() {
        super.externalContext.invalidateSession();
        super.redirect("/");
    }
}
