package metube.repositories;

import metube.domain.entities.User;
import metube.repositories.GenericRepository;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User, String> {

    User findByUsername(String username);
}
