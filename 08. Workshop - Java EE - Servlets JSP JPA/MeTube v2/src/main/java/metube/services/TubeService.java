package metube.services;

import metube.domain.entities.Tube;
import metube.domain.enums.TubeStatus;
import metube.domain.models.binding.UploadTubeBindingModel;
import metube.domain.models.view.TubeHomeViewModel;
import metube.domain.models.view.TubeProfileViewModel;

import java.util.List;

public interface TubeService {

    void upload(UploadTubeBindingModel tube);

    void update(Tube tube);

    List<TubeHomeViewModel> findAll();

    <T> T findByIdViewModel(String id, Class<T> klass);

    Tube findById(String id);

    void incrementViews(String id);

    List<TubeProfileViewModel> findByAuthorId(String id);

    <T> List<T> findByTubeStatus(TubeStatus status, Class<T> klass);
}
