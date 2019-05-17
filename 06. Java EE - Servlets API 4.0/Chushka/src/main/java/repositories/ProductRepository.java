package repositories;

import domain.entities.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    void create(Product product);
}
