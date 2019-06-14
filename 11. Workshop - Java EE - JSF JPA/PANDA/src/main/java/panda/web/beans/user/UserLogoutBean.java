package panda.web.beans.user;

import lombok.NoArgsConstructor;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;

@Model
@NoArgsConstructor
public class UserLogoutBean extends BaseBean {

    public void logout() {
        super.externalContext.invalidateSession();
        super.redirect("/");
    }
}
