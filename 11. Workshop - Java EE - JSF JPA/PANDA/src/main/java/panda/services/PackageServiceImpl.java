package panda.services;

import org.modelmapper.ModelMapper;
import panda.domain.entities.Package;
import panda.domain.entities.Receipt;
import panda.domain.entities.User;
import panda.domain.enums.Status;
import panda.domain.models.binding.PackageCreateBindingModel;
import panda.domain.models.view.packets.PackageDetailsViewModel;
import panda.repositories.PackageRepository;
import panda.util.ModelValidator;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final UserService userService;
    private final ModelMapper mapper;

    @Inject
    public PackageServiceImpl(PackageRepository packageRepository,
                              UserService userService,
                              ModelMapper mapper) {
        this.packageRepository = packageRepository;
        this.userService = userService;
        this.mapper = mapper;
    }


    @Override
    public boolean create(PackageCreateBindingModel model) {
        if (ModelValidator.validateModel(model) != null) {
            return false;
        }

        User user = this.userService.findByIdWithPackages(model.getRecipient());
        Package packet = this.mapper.map(model, Package.class);
        packet.setStatus(Status.PENDING);
        user.addPackage(packet);
        this.userService.update(user);
        return true;
    }

    @Override
    public <T> List<T> findAllByStatusAndUserId(Status status, String userId, Class<T> targetEntity) {
        return this.packageRepository.findAllByStatusAndUserId(status, userId)
                .stream()
                .map(packet -> this.mapper.map(packet, targetEntity))
                .collect(Collectors.toList());
    }

    @Override
    public <T> List<T> findAllByStatus(Status status, Class<T> targetEntity) {
        return this.packageRepository.findByAttributeAndValue("status", status)
                .stream()
                .map(packet -> this.mapper.map(packet, targetEntity))
                .collect(Collectors.toList());
    }

    @Override
    public <T> List<T> findAllByStatusEager(Status status, Class<T> targetEntity) {
        return this.packageRepository.findAllByStatusEager(status)
                .stream()
                .map(packet -> this.mapper.map(packet, targetEntity))
                .collect(Collectors.toList());
    }

    @Override
    public PackageDetailsViewModel findById(String id) {
        return this.packageRepository.findByIdWithUser(id);
    }

    @Override
    public void ship(String id) {
        Package packet = this.packageRepository.findOne(id);

        Random random = new Random();
        LocalDateTime deliveryDate = LocalDateTime.now().plusDays(random.ints(1, 20, 40).findFirst().orElse(20));

        packet.setEstimatedDeliveryDate(deliveryDate);
        packet.setStatus(Status.SHIPPED);

        this.packageRepository.update(packet);
    }

    @Override
    public void deliver(String id) {
        Package packet = this.packageRepository.findOne(id);
        packet.setStatus(Status.DELIVERED);

        this.packageRepository.update(packet);
    }

    @Override
    public void acquire(String id) {
        Package packet = this.packageRepository.findByIdEager(id);
        packet.setStatus(Status.ACQUIRED);

        this.packageRepository.update(packet);

        User user = this.userService.findByIdWithReceipts(packet.getRecipient().getId());

        Receipt receipt = new Receipt();
        receipt.setFee(BigDecimal.valueOf(packet.getWeight()).multiply(BigDecimal.valueOf(2.67)));
        receipt.setIssuedOn(LocalDateTime.now());
        packet.addReceipt(receipt);
        user.addReceipt(receipt);

        this.userService.update(user);
    }
}
