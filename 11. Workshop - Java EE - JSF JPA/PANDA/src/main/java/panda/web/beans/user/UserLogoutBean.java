package panda.web.beans.user;

import lombok.NoArgsConstructor;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;

@Model
@NoArgsConstructor
public class UserLogoutBean extends BaseBean {

    public void logout() {
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .invalidateSession();
        super.redirect("/");
    }
}
