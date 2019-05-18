package chushka.services;

import chushka.domain.models.ProductServiceModel;
import chushka.domain.models.ProductViewModel;

import java.util.List;

public interface ProductService {

    void save(ProductServiceModel product);

    List<ProductViewModel> findAll();

    ProductViewModel findByName(String name);
}
