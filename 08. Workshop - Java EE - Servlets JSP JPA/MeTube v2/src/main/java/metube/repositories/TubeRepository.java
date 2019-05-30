package metube.repositories;

import metube.domain.entities.Tube;
import metube.domain.enums.TubeStatus;
import metube.domain.models.view.TubeHomeViewModel;
import metube.domain.models.view.TubeProfileViewModel;

import java.util.List;

public interface TubeRepository extends GenericRepository<Tube, String> {

    List<TubeHomeViewModel> findAll();

    List<TubeProfileViewModel> findByAuthorId(String id);

    List<Tube> findByTubeStatus(TubeStatus status);
}
