package metube.services;

import metube.domain.models.binding.UploadTubeBindingModel;

public interface TubeService {

    void save(UploadTubeBindingModel tube);
}
