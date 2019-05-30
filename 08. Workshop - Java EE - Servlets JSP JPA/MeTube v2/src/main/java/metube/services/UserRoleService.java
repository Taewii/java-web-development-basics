package metube.services;

import metube.domain.entities.Role;
import metube.domain.enums.UserRole;

public interface UserRoleService {

    void save(Role role);

    Role findByType(UserRole admin);

    boolean isTableEmpty();
}
