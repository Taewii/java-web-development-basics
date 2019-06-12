package panda.web.beans.packets;

import lombok.NoArgsConstructor;
import panda.domain.models.view.PackageDetailsViewModel;
import panda.services.PackageService;
import panda.web.beans.BaseBean;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Model
@NoArgsConstructor
public class PackageDetailsBean extends BaseBean {

    private PackageDetailsViewModel model;

    private PackageService packageService;

    @Inject
    public PackageDetailsBean(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostConstruct
    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.model = this.packageService.findById(id);
    }

    public PackageDetailsViewModel getModel() {
        return this.model;
    }
}
