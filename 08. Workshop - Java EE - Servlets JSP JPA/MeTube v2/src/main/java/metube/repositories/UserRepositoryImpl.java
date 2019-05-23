package metube.repositories;

import metube.domain.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
    public List<User> findAll() {
        throw new UnsupportedOperationException();
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
}
