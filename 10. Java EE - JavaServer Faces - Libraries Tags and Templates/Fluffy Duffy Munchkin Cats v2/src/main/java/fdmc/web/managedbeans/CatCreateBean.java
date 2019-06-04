package fdmc.web.managedbeans;

import fdmc.domain.models.CatCreateBindingModel;
import fdmc.services.CatService;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

@Model
@NoArgsConstructor
public class CatCreateBean {

    private CatCreateBindingModel model = new CatCreateBindingModel();

    private CatService catService;

    @Inject
    public CatCreateBean(CatService catService) {
        this.catService = catService;
    }

    public void create() throws IOException {
        this.catService.create(this.model);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/");
    }

    public CatCreateBindingModel getModel() {
        return this.model;
    }
}
