package panda.web.beans.packets;

import lombok.NoArgsConstructor;
import panda.domain.enums.Status;
import panda.domain.models.view.PackageIndexViewModel;
import panda.services.PackageService;
import panda.web.beans.BaseBean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model
@NoArgsConstructor
public class PackageListingBean extends BaseBean {

    private List<PackageIndexViewModel> pending = new ArrayList<>();
    private List<PackageIndexViewModel> shipped = new ArrayList<>();
    private List<PackageIndexViewModel> delivered = new ArrayList<>();

    private PackageService packageService;

    @Inject
    public PackageListingBean(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostConstruct
    private void init() {
        this.pending = packageService.findAllByStatus(Status.PENDING);
        this.shipped = packageService.findAllByStatus(Status.SHIPPED);
        this.delivered = packageService.findAllByStatus(Status.DELIVERED);
    }

    public List<PackageIndexViewModel> getPending() {
        return Collections.unmodifiableList(this.pending);
    }

    public List<PackageIndexViewModel> getShipped() {
        return Collections.unmodifiableList(this.shipped);
    }

    public List<PackageIndexViewModel> getDelivered() {
        return Collections.unmodifiableList(this.delivered);
    }
}
