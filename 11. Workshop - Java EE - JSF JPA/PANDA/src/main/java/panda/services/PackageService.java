package panda.services;

import panda.domain.enums.Status;
import panda.domain.models.binding.PackageCreateBindingModel;
import panda.domain.models.view.PackageDetailsViewModel;
import panda.domain.models.view.PackageIndexViewModel;

import java.util.List;

public interface PackageService {

    void create(PackageCreateBindingModel model);

    List<PackageIndexViewModel> findAllByStatus(Status status);

    PackageDetailsViewModel findById(String id);
}
