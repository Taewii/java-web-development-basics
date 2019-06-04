package fdmc.web.managedbeans;

import fdmc.domain.models.CatViewModel;
import fdmc.services.CatService;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
@NoArgsConstructor
public class ListCatsBean {

    private List<CatViewModel> cats;

    @Inject
    public ListCatsBean(CatService catService) {
        this.cats = catService.findAll();
    }

    public List<CatViewModel> getCats() {
        return this.cats;
    }
}
