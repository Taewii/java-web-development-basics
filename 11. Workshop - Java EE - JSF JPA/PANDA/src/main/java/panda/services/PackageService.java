package panda.services;

import panda.domain.enums.Status;
import panda.domain.models.binding.PackageCreateBindingModel;
import panda.domain.models.view.PackageDetailsViewModel;

import java.util.List;

public interface PackageService {

    void create(PackageCreateBindingModel model);

    <T> List<T> findAllByStatus(Status status, Class<T> targetEntity);

    <T> List<T> findAllByStatusEager(Status status, Class<T> targetEntity);

    PackageDetailsViewModel findById(String id);

}
