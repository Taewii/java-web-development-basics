package repositories;

import domain.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    //    @PersistenceContext(unitName = "chushka_db")
//    @PersistenceUnit  //RESOURCE_LOCAL in persistence.xml
    private EntityManager manager;

    public ProductRepositoryImpl() {
        this.manager = Persistence
                .createEntityManagerFactory("chushka_db")
                .createEntityManager();
    }

    @Override
    public List<Product> findAll() {
//        this.manager.createQuery("SELECT * FROM ...")
        return null;
    }

    @Override
    public void create(Product product) {
        this.manager.getTransaction().begin();
        this.manager.persist(product);
        this.manager.getTransaction().commit();
    }
}
