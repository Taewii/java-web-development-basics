package metube.repositories;

import metube.domain.entities.Tube;
import metube.web.WebConstants;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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
                .createNamedQuery("Tube.findAll", Tube.class)
                .getResultList();

    }

    @Override
    public Optional<Tube> findByTitle(String title) {
        try {
            return Optional.of(this.manager
                    .createNamedQuery("Tube.findByTitle", Tube.class)
                    .setParameter(WebConstants.ATTRIBUTE_TITLE, title)
                    .getSingleResult());
        } catch (NoResultException nre) {
            return Optional.empty();
        }
    }
}
