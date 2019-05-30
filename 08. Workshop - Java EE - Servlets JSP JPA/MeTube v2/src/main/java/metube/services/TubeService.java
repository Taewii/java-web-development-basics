package metube.services;

import metube.domain.entities.Tube;
import metube.domain.enums.TubeStatus;
import metube.domain.models.binding.UploadTubeBindingModel;
import metube.domain.models.view.TubeProfileViewModel;

import java.util.List;

public interface TubeService {

    <T> T findByIdViewModel(String id, Class<T> klass);

    <T> List<T> findByTubeStatus(TubeStatus status, Class<T> klass);

    List<TubeProfileViewModel> findByAuthorId(String id);

    Tube findById(String id);

    void upload(UploadTubeBindingModel tube);

    void update(Tube tube);

    void incrementViews(String id);
}
