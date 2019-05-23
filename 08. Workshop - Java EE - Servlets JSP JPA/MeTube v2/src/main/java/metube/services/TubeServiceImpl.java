package metube.services;

import metube.domain.entities.Tube;
import metube.domain.models.binding.UploadTubeBindingModel;
import metube.repositories.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Validator;

@Stateless
public class TubeServiceImpl implements TubeService {

    private final TubeRepository tubeRepository;
    private final ModelMapper mapper;
    private final Validator validator;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository,
                           ModelMapper mapper,
                           Validator validator) {
        this.tubeRepository = tubeRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public void save(UploadTubeBindingModel tube) {
        // TODO: 23.5.2019 г. validate
        this.tubeRepository.save(this.mapper.map(tube, Tube.class));
    }
}
