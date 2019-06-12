package panda.services;

import panda.domain.models.binding.PackageCreateBindingModel;

public interface PackageService {

    void create(PackageCreateBindingModel model);
}
