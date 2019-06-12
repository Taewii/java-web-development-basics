package panda.services;

import org.modelmapper.ModelMapper;
import panda.domain.entities.Package;
import panda.domain.entities.User;
import panda.domain.enums.Status;
import panda.domain.models.binding.PackageCreateBindingModel;
import panda.repositories.PackageRepository;

import javax.inject.Inject;
import javax.validation.Validator;

public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final UserService userService;
    private final Validator validator;
    private final ModelMapper mapper;

    @Inject
    public PackageServiceImpl(PackageRepository packageRepository,
                              UserService userService,
                              Validator validator,
                              ModelMapper mapper) {
        this.packageRepository = packageRepository;
        this.userService = userService;
        this.validator = validator;
        this.mapper = mapper;
    }


    @Override
    public void create(PackageCreateBindingModel model) {
        // TODO: 12.6.2019 г. validate and make base service class
        User user = this.userService.findByIdWithPackages(model.getRecipient());
        Package packet = this.mapper.map(model, Package.class);
        packet.setStatus(Status.PENDING);
        user.addPackage(packet);
        this.userService.update(user);
    }
}
