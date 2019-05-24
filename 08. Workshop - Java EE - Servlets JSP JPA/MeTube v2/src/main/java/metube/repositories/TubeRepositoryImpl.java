package metube.repositories;

import metube.domain.entities.Tube;
import metube.domain.models.view.TubeDetailsViewModel;
import metube.domain.models.view.TubeHomeViewModel;
import metube.domain.models.view.TubeProfileViewModel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public Tube update(Tube entity) {
        return this.manager.merge(entity);
    }

    @Override
    public Tube findById(String id) {
        try {
            return this.manager
                    .createQuery("SELECT t FROM Tube t WHERE t.id = :id", Tube.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<TubeHomeViewModel> findAll() {
        return this.manager
                .createQuery("" +
                        "SELECT " +
                        "new metube.domain.models.view.TubeHomeViewModel(t.id, t.title, t.uploader.username, t.youtubeId) " +
                        "FROM Tube t", TubeHomeViewModel.class)
                .getResultList();
    }

    @Override
    public TubeDetailsViewModel findViewModelById(String id) {
        try {
            return this.manager
                    .createQuery("" +
                            "SELECT " +
                            "new metube.domain.models.view.TubeDetailsViewModel(t.title, t.author, t.youtubeId, t.description, t.views) " +
                            "FROM Tube t " +
                            "WHERE t.id = :id", TubeDetailsViewModel.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List<TubeProfileViewModel> findByAuthorId(String id) {
        return this.manager
                .createQuery("" +
                        "SELECT " +
                        "new metube.domain.models.view.TubeProfileViewModel(t.id, t.title, t.author) " +
                        "FROM Tube t " +
                        "WHERE t.uploader.id = :id " +
                        "ORDER BY t.views DESC ", TubeProfileViewModel.class)
                .setParameter("id", id)
                .getResultList();
    }
}
