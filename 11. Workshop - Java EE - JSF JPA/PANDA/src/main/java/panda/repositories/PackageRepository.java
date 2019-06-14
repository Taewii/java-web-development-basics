package panda.repositories;

import panda.domain.entities.Package;
import panda.domain.enums.Status;
import panda.domain.models.view.packets.PackageDetailsViewModel;

import java.util.List;

public interface PackageRepository extends CrudRepository<Package, String> {

    PackageDetailsViewModel findByIdWithUser(String id);

    List<Package> findAllByStatusEager(Status status);

    List<Package> findAllByStatusAndUserId(Status status, String userId);

    Package findByIdEager(String id);
}
