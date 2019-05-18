package chushka.services;

import chushka.domain.entities.Product;
import chushka.domain.models.ProductServiceModel;
import chushka.domain.models.ProductViewModel;
import chushka.repositories.ProductRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;

    @Inject
    public ProductServiceImpl(ProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(ProductServiceModel product) {
        this.repository.save(this.modelMapper.map(product, Product.class));
    }

    @Override
    public List<ProductViewModel> findAll() {
        return this.repository
                .findAll()
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductViewModel findByName(String name) {
        return this.modelMapper.map(this.repository.findByName(name), ProductViewModel.class);
    }
}
