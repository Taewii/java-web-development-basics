package metube.repositories;

public interface GenericRepository<E, K> {

    E save(E entity);

    void update(E entity);

    E findById(K id);
}
