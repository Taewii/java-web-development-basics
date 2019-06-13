package panda.web.beans.packets;

import lombok.NoArgsConstructor;
import panda.services.PackageService;
import panda.web.beans.BaseBean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
@NoArgsConstructor
public class PackageActionsBean extends BaseBean {

    private PackageService packageService;

    @Inject
    public PackageActionsBean(PackageService packageService) {
        this.packageService = packageService;
    }

    public void ship(String id) {
        this.packageService.ship(id);
        super.redirect("/");
    }

    public void deliver(String id) {
        this.packageService.deliver(id);
        super.redirect("/");
    }

    public void acquire(String id) {
        this.packageService.acquire(id);
        super.redirect("/");
    }
}
