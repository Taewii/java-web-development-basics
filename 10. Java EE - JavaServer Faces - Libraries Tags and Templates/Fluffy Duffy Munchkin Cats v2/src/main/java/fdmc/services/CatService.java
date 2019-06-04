package fdmc.services;

import fdmc.domain.models.CatCreateBindingModel;
import fdmc.domain.models.CatViewModel;

import java.util.List;

public interface CatService {

    void create(CatCreateBindingModel model);

    List<CatViewModel> findAll();
}
