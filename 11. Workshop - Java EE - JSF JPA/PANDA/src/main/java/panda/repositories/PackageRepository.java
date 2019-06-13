package panda.repositories;

import panda.domain.entities.Package;
import panda.domain.enums.Status;
import panda.domain.models.view.PackageDetailsViewModel;

import java.util.List;

public interface PackageRepository extends CrudRepository<Package, String> {

    PackageDetailsViewModel findByIdWithUser(String id);

    List<Package> findAllByStatusEager(Status status);
}
