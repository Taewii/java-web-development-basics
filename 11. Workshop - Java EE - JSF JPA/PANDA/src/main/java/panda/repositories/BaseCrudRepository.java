package panda.repositories;

import panda.domain.entities.Identifiable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseCrudRepository<Entity extends Identifiable<Id>, Id> implements CrudRepository<Entity, Id> {

    private Class<Entity> entityClass;

    @PersistenceContext(unitName = "panda")
    protected EntityManager entityManager;

    protected BaseCrudRepository() {
        this.entityClass = initEntityClass();
    }

    @Override
    public Entity findOne(Id id) {
        return this.entityManager.find(this.entityClass, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> findAll() {
        return this.entityManager
                .createQuery("FROM " + this.entityClass.getName())
                .getResultList();
    }

    @Override
    public void save(Entity entity) {
        this.entityManager.persist(entity);
    }

    @Override
    public void update(Entity entity) {
        this.entityManager.merge(entity);
    }

    @Override
    public void delete(Entity entity) {
        this.entityManager.remove(entity);
    }

    @Override
    public void deleteById(Id entityId) {
        Entity entity = this.findOne(entityId);
        this.delete(entity);
    }

    @SuppressWarnings("unchecked")
    private Class<Entity> initEntityClass() {
        return (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}