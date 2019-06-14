package panda.web.beans.packets;

import lombok.NoArgsConstructor;
import panda.domain.enums.Status;
import panda.domain.models.view.packets.PackageIndexViewModel;
import panda.domain.models.view.packets.PackagePendingAndDeliveredViewModel;
import panda.domain.models.view.packets.PackageShippedViewModel;
import panda.services.PackageService;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Model
@NoArgsConstructor
public class PackageListingBean extends BaseBean {

    private String userId;

    private PackageService packageService;

    @Inject
    public PackageListingBean(PackageService packageService) {
        this.packageService = packageService;
        this.userId = (String) ((HttpSession) super.externalContext
                .getSession(false)).getAttribute("userId");
    }

    // TODO: 13.6.2019 г. these probably should not be done like this, figure it out
    public List<PackageIndexViewModel> getUserPendingIndex() {
        return Collections.unmodifiableList(this.packageService.findAllByStatusAndUserId(Status.PENDING, this.userId, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getUserShippedIndex() {
        return Collections.unmodifiableList(this.packageService.findAllByStatusAndUserId(Status.SHIPPED, this.userId, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getUserDeliveredIndex() {
        return Collections.unmodifiableList(this.packageService.findAllByStatusAndUserId(Status.DELIVERED, this.userId, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getPendingIndex() {
        return Collections.unmodifiableList(this.packageService.findAllByStatus(Status.PENDING, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getShippedIndex() {
        return Collections.unmodifiableList(this.packageService.findAllByStatus(Status.SHIPPED, PackageIndexViewModel.class));
    }

    public List<PackagePendingAndDeliveredViewModel> getDeliveredAndAcquiredEager() {
        List<PackagePendingAndDeliveredViewModel> deliveredAndAcquired = this.packageService.findAllByStatusEager(Status.DELIVERED, PackagePendingAndDeliveredViewModel.class);
        deliveredAndAcquired.addAll(this.packageService.findAllByStatusEager(Status.ACQUIRED, PackagePendingAndDeliveredViewModel.class));
        return Collections.unmodifiableList(deliveredAndAcquired);
    }

    public List<PackagePendingAndDeliveredViewModel> getPendingEager() {
        return Collections.unmodifiableList(this.packageService.findAllByStatusEager(Status.PENDING, PackagePendingAndDeliveredViewModel.class));
    }

    public List<PackageShippedViewModel> getShippedEager() {
        return Collections.unmodifiableList(this.packageService.findAllByStatusEager(Status.SHIPPED, PackageShippedViewModel.class));
    }
}
