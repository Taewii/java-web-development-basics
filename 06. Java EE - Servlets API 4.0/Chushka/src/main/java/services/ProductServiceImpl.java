package services;

import domain.entities.Product;
import repositories.ProductRepository;

import javax.inject.Inject;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Inject
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Product product) {
        this.repository.create(product);
    }
}
