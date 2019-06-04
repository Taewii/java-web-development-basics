package fdmc.repositories;

import fdmc.domain.entities.Cat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CatRepositoryImpl implements CatRepository {

    @PersistenceContext(unitName = "fdmc")
    private EntityManager manager;

    @Override
    public void save(Cat entity) {
        this.manager.persist(entity);
    }

    @Override
    public List<Cat> findAll() {
        return this.manager
                .createQuery("SELECT c FROM Cat c", Cat.class)
                .getResultList();
    }
}
