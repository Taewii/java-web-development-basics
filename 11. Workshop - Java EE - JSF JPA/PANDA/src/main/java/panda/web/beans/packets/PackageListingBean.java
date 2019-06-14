package panda.web.beans.packets;

import lombok.NoArgsConstructor;
import panda.domain.enums.Status;
import panda.domain.models.view.PackageIndexViewModel;
import panda.domain.models.view.PackagePendingAndDeliveredViewModel;
import panda.domain.models.view.PackageShippedViewModel;
import panda.services.PackageService;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
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
        this.userId = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false)).getAttribute("userId");
    }

    // TODO: 13.6.2019 г. these probably should not be done like this, figure it out
    public List<PackageIndexViewModel> getUserPendingIndex() {
        return Collections.unmodifiableList(packageService.findAllByStatusAndUserId(Status.PENDING, this.userId, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getUserShippedIndex() {
        return Collections.unmodifiableList(packageService.findAllByStatusAndUserId(Status.SHIPPED, this.userId, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getUserDeliveredIndex() {
        return Collections.unmodifiableList(packageService.findAllByStatusAndUserId(Status.DELIVERED, this.userId, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getPendingIndex() {
        return Collections.unmodifiableList(packageService.findAllByStatus(Status.PENDING, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getShippedIndex() {
        return Collections.unmodifiableList(packageService.findAllByStatus(Status.SHIPPED, PackageIndexViewModel.class));
    }

    public List<PackageIndexViewModel> getDeliveredAndAcquiredIndex() {
        List<PackageIndexViewModel> deliveredAndAcquired = packageService.findAllByStatus(Status.DELIVERED, PackageIndexViewModel.class);
        deliveredAndAcquired.addAll(packageService.findAllByStatus(Status.ACQUIRED, PackageIndexViewModel.class));
        return Collections.unmodifiableList(deliveredAndAcquired);
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
