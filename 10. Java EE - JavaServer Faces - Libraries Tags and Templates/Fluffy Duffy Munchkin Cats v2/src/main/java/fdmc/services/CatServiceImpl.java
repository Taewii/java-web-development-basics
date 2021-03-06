package fdmc.services;

import fdmc.domain.entities.Cat;
import fdmc.domain.models.CatCreateBindingModel;
import fdmc.domain.models.CatViewModel;
import fdmc.repositories.CatRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;
    private final ModelMapper mapper;
    private final Validator validator;

    @Inject
    public CatServiceImpl(CatRepository catRepository, ModelMapper mapper, Validator validator) {
        this.catRepository = catRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public void create(CatCreateBindingModel model) {
        Set<ConstraintViolation<CatCreateBindingModel>> violations = this.validator.validate(model);

        if (!violations.isEmpty()) {
            String message = violations.stream().map(v -> String.format("%s value '%s' %s", v.getPropertyPath(),
                    v.getInvalidValue(), v.getMessage()))
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(message);
        }

        // + 1 day cus Temporal(DATE) sets it 1 day before probably cus time zone
        model.setAddedOn(new Date(model.getAddedOn().getTime() + 1 * 24 * 60 * 60 * 1000));
        this.catRepository.save(this.mapper.map(model, Cat.class));
    }

    @Override
    public List<CatViewModel> findAll() {
        return this.catRepository
                .findAll()
                .stream()
                .map(entity -> this.mapper.map(entity, CatViewModel.class))
                .collect(Collectors.toList());
    }
}
