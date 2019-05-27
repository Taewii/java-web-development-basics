package metube.repositories;

import metube.domain.entities.Role;
import metube.domain.enums.UserRole;

public interface UserRoleRepository extends GenericRepository<Role, Integer> {

    Role findByType(UserRole name);
}
