package metube.services;

import metube.domain.entities.Tube;
import metube.domain.models.binding.TubeBindingModel;
import metube.domain.models.view.TubeAllViewModel;
import metube.domain.models.view.TubeDetailsViewModel;
import metube.repositories.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class TubeServiceImpl implements TubeService {

    private TubeRepository tubeRepository;
    private ModelMapper mapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, ModelMapper mapper) {
        this.tubeRepository = tubeRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(TubeBindingModel tube) {
        this.tubeRepository.save(this.mapper.map(tube, Tube.class));
    }

    @Override
    public List<TubeAllViewModel> findAll() {
        return this.tubeRepository.findAll().stream()
                .map(tube -> this.mapper.map(tube, TubeAllViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public TubeDetailsViewModel findByTitle(String title) {
        return this.mapper.map(this.tubeRepository.findByTitle(title), TubeDetailsViewModel.class);
    }
}
