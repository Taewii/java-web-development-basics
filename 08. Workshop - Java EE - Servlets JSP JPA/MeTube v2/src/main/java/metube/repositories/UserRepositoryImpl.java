package metube.repositories;

import metube.domain.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(unitName = "metube")
    private EntityManager manager;

    @Override
    public User save(User entity) {
        this.manager.persist(entity);
        return entity;
    }

    @Override
    public User update(User entity) {
        return this.manager.merge(entity);
    }

    @Override
    public User findById(String id) {
        return this.manager
                .createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User findByUsername(String username) {
        try {
            return this.manager
                    .createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public boolean isTableEmpty() {
        return this.manager
                .createQuery("SELECT u FROM User u", User.class)
                .setMaxResults(1)
                .getResultList()
                .isEmpty();
    }

    @Override
    public User findByUsernameWithRoles(String username) {
        try {
            return this.manager
                    .createQuery("" +
                            "SELECT u FROM User u " +
                            "JOIN FETCH u.roles " +
                            "WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
