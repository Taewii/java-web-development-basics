package chushka.repositories;

import chushka.domain.entities.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext(unitName = "chushka")
    private EntityManager manager;

    @Override
    public Product save(Product entity) {
        this.manager.persist(entity);
        return entity;
    }

    @Override
    public List<Product> findAll() {
        return this.manager.createQuery("SELECT p FROM products p", Product.class).getResultList();
    }

    @Override
    public Product findByName(String name) {
        return this.manager
                .createQuery("SELECT p FROM products p WHERE p.name = :name", Product.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
