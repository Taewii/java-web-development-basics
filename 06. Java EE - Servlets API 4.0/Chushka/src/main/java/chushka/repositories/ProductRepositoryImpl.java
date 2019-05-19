package chushka.repositories;

import chushka.domain.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    // cant seem to get it working with @PersistenceContext
    // persistence.xml -> transaction-type="RESOURCE_LOCAL"
    // class needs to be @Stateless
    // @PersistenceContext(unitName = "chushka")
    private EntityManager manager;

    public ProductRepositoryImpl() {
        this.manager = Persistence
                .createEntityManagerFactory("chushka")
                .createEntityManager();
    }

    @Override
    public Product save(Product entity) {
        this.manager.getTransaction().begin();
        this.manager.persist(entity);
        this.manager.getTransaction().commit();

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
