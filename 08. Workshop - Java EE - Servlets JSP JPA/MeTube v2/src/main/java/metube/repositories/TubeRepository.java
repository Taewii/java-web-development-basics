package metube.repositories;

import metube.domain.entities.Tube;
import metube.domain.models.view.TubeDetailsViewModel;
import metube.domain.models.view.TubeHomeViewModel;
import metube.domain.models.view.TubeProfileViewModel;

import java.util.List;

public interface TubeRepository extends GenericRepository<Tube, String> {

    List<TubeHomeViewModel> findAll();

    TubeDetailsViewModel findViewModelById(String id);

    List<TubeProfileViewModel> findByAuthorId(String id);
}
