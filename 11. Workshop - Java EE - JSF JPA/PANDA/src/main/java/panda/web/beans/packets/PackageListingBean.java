package panda.web.beans.packets;

import lombok.NoArgsConstructor;
import panda.domain.enums.Status;
import panda.domain.models.view.PackageIndexViewModel;
import panda.domain.models.view.PackagePendingAndDeliveredViewModel;
import panda.domain.models.view.PackageShippedViewModel;
import panda.services.PackageService;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@Model
@NoArgsConstructor
public class PackageListingBean extends BaseBean {

    private PackageService packageService;

    @Inject
    public PackageListingBean(PackageService packageService) {
        this.packageService = packageService;
    }

    public List<PackageIndexViewModel> getPendingIndex() {
        return Collections.unmodifiableList(packageService.findAllByStatus(Status.PENDING, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getShippedIndex() {
        return Collections.unmodifiableList(packageService.findAllByStatus(Status.SHIPPED, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getDeliveredIndex() {
        return Collections.unmodifiableList(packageService.findAllByStatus(Status.DELIVERED, PackageIndexViewModel.class));
    }

    public List<PackagePendingAndDeliveredViewModel> getPendingEager() {
        return Collections.unmodifiableList(packageService.findAllByStatusEager(Status.PENDING, PackagePendingAndDeliveredViewModel.class));
    }

    public List<PackageShippedViewModel> getShippedEager() {
        return Collections.unmodifiableList(packageService.findAllByStatusEager(Status.SHIPPED, PackageShippedViewModel.class));
    }

    public List<PackagePendingAndDeliveredViewModel> getDeliveredEager() {
        return Collections.unmodifiableList(packageService.findAllByStatusEager(Status.DELIVERED, PackagePendingAndDeliveredViewModel.class));
    }
}
