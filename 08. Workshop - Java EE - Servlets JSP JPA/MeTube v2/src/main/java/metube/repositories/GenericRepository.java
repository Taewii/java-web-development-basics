package metube.repositories;

public interface GenericRepository<E, K> {

    E save(E entity);

    E update(E entity);

    E findById(K id);
}
