package metube.repositories;

import metube.domain.entities.Tube;

public interface GenericRepository<E, K> {

    E save(E entity);

    Tube update(Tube entity);

    E findById(K id);
}
