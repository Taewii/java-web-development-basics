package panda.repositories;

import panda.domain.entities.User;

import javax.ejb.Stateless;

@Stateless
public class UserRepositoryImpl extends BaseCrudRepository<User, String> implements UserRepository {

    @Override
    public boolean isTableEmpty() {
        return super.entityManager.createQuery("SELECT u FROM User u")
                .setMaxResults(1)
                .getResultList()
                .isEmpty();
    }
}
