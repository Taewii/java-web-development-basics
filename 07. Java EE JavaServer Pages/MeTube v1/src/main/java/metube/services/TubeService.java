package metube.services;

import metube.domain.models.binding.TubeBindingModel;
import metube.domain.models.view.TubeAllViewModel;
import metube.domain.models.view.TubeDetailsViewModel;

import java.util.List;

public interface TubeService {

    void save(TubeBindingModel tube);

    List<TubeAllViewModel> findAll();

    TubeDetailsViewModel findByTitle(String title);
}
