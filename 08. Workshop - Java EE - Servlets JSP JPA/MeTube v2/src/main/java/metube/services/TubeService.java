package metube.services;

import metube.domain.entities.User;
import metube.domain.models.binding.UploadTubeBindingModel;
import metube.domain.models.view.TubeDetailsViewModel;
import metube.domain.models.view.TubeHomeViewModel;
import metube.domain.models.view.TubeProfileViewModel;

import java.util.List;

public interface TubeService {

    void upload(UploadTubeBindingModel tube, User user);

    List<TubeHomeViewModel> findAll();

    TubeDetailsViewModel findById(String id);

    void incrementViews(String id);

    List<TubeProfileViewModel> findByAuthorId(String id);
}
