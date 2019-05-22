package metube.services;

import metube.domain.entities.Tube;
import metube.domain.models.binding.TubeBindingModel;
import metube.domain.models.view.TubeAllViewModel;
import metube.domain.models.view.TubeDetailsViewModel;
import metube.repositories.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public void save(TubeBindingModel tube) {
        Set<ConstraintViolation<TubeBindingModel>> violations = this.validator.validate(tube);
        if (!violations.isEmpty()) {
            String messages = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(System.lineSeparator()));

            throw new IllegalArgumentException(messages);
        }
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
        return this.tubeRepository.findByTitle(title)
                .map(tube -> this.mapper.map(tube, TubeDetailsViewModel.class))
                .orElse(null);
    }
}
