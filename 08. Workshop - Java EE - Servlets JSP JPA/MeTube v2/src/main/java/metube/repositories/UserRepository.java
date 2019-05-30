package metube.repositories;

import metube.domain.entities.User;

public interface UserRepository extends GenericRepository<User, String> {

    User findByUsername(String username);

    boolean isTableEmpty();

    User findByUsernameWithRoles(String username);
}