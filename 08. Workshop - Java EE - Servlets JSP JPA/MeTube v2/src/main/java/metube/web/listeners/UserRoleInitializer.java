package metube.web.listeners;

import metube.domain.entities.Role;
import metube.domain.enums.UserRole;
import metube.services.UserRoleService;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class UserRoleInitializer implements ServletContextListener {

    private final UserRoleService userRoleService;

    @Inject
    public UserRoleInitializer(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        for (UserRole roleEnum : UserRole.values()) {
            Role role = new Role();
            role.setRole(roleEnum);
            this.userRoleService.save(role);
        }
    }
}
