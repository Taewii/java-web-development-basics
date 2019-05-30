package metube.services;

import metube.domain.entities.Tube;
import metube.domain.enums.TubeStatus;
import metube.domain.models.binding.UploadTubeBindingModel;
import metube.domain.models.view.TubeProfileViewModel;
import metube.repositories.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public void upload(UploadTubeBindingModel tube) {
        Set<ConstraintViolation<UploadTubeBindingModel>> violations = this.validator.validate(tube);
        String message;
        if (!violations.isEmpty()) {
            message = violations.stream().map(v -> String.format("%s value '%s' %s", v.getPropertyPath(),
                    v.getInvalidValue(), v.getMessage()))
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(message);
        }

        Tube entity = this.mapper.map(tube, Tube.class);
        this.tubeRepository.update(entity);
    }

    @Override
    public void update(Tube tube) {
        this.tubeRepository.update(tube);
    }

    @Override
    public Tube findById(String id) {
        return this.tubeRepository.findById(id);
    }

    @Override
    public <T> T findByIdViewModel(String id, Class<T> klass) {
        Tube tube = this.tubeRepository.findById(id);
        return tube == null ? null : this.mapper.map(tube, klass);
    }

    @Override
    public void incrementViews(String id) {
        Tube tube = this.tubeRepository.findById(id);
        if (tube != null) {
            tube.incrementViews();
            this.tubeRepository.update(tube);
        }
    }

    @Override
    public List<TubeProfileViewModel> findByAuthorId(String id) {
        return this.tubeRepository.findByAuthorId(id);
    }

    @Override
    public <T> List<T> findByTubeStatus(TubeStatus status, Class<T> klass) {
        return this.tubeRepository.findByTubeStatus(status)
                .stream()
                .map(tube -> this.mapper.map(tube, klass))
                .collect(Collectors.toList());
    }
}
