package metube.repositories;

import metube.domain.entities.Tube;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TubeRepositoryImpl implements TubeRepository {

    @PersistenceContext(unitName = "metube")
    private EntityManager manager;

    @Override
    public Tube save(Tube entity) {
        this.manager.persist(entity);
        return entity;
    }

    @Override
    public List<Tube> findAll() {
        return this.manager
                .createQuery("SELECT t FROM tubes t", Tube.class)
                .getResultList();
    }

    @Override
    public Tube findByTitle(String title) {
        return this.manager
                .createQuery("SELECT t FROM tubes t WHERE t.title = :title", Tube.class)
                .setParameter("title", title)
                .getSingleResult();
    }
}
