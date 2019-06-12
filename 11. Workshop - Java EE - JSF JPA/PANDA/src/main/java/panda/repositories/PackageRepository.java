package panda.repositories;

import panda.domain.entities.Package;
import panda.domain.models.view.PackageDetailsViewModel;

public interface PackageRepository extends CrudRepository<Package, String> {

    PackageDetailsViewModel findByIdWithUser(String id);
}
