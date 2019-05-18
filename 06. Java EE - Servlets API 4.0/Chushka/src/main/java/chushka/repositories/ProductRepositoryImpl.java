package chushka.repositories;

import chushka.domain.entities.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    // persistence.xml -> transaction-type="RESOURCE_LOCAL"
    // class needs to be @Stateless
    // @PersistenceContext(unitName = "chushka")
    private EntityManager manager;

    @Inject
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
        return this.manager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public Product findByName(String name) {
        return this.manager
                .createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
