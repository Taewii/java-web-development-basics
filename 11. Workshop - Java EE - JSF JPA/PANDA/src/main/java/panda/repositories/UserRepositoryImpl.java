package panda.repositories;

import panda.domain.entities.User;

import javax.ejb.Stateless;

@Stateless
public class UserRepositoryImpl extends BaseCrudRepository<User, String> implements UserRepository {

    @Override
    public boolean isTableEmpty() {
        return super.entityManager
                .createQuery("SELECT u FROM User u")
                .setMaxResults(1)
                .getResultList()
                .isEmpty();
    }

    @Override
    public User findByIdWithPackages(String id) {
        return super.entityManager
                .createQuery("" +
                        "SELECT u FROM User u " +
                        "LEFT JOIN FETCH u.packages " +
                        "WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User findByIdWithReceipts(String id) {
        return super.entityManager
                .createQuery("" +
                        "SELECT u FROM User u " +
                        "LEFT JOIN FETCH u.receipts " +
                        "WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
