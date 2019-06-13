package panda.repositories;

import panda.domain.entities.User;

public interface UserRepository extends CrudRepository<User, String> {

    boolean isTableEmpty();

    User findByIdWithPackages(String id);

    User findByIdWithReceipts(String id);
}
