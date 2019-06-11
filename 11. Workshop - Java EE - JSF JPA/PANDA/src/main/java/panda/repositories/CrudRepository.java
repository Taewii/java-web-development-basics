package panda.repositories;

import panda.domain.entities.Identifiable;

import java.util.List;

public interface CrudRepository<Entity extends Identifiable<Id>, Id> {

    Entity findOne(Id id);

    List<Entity> findAll();

    void save(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

    void deleteById(Id entityId);
}
