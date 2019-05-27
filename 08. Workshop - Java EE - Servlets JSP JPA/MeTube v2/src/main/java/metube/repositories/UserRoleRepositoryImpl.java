package metube.repositories;

import metube.domain.entities.Role;
import metube.domain.entities.Tube;
import metube.domain.enums.UserRole;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserRoleRepositoryImpl implements UserRoleRepository {

    @PersistenceContext(unitName = "metube")
    private EntityManager manager;

    @Override
    public Role save(Role entity) {
        this.manager.persist(entity);
        return entity;
    }

    @Override
    public Role findByType(UserRole type) {
        return this.manager.createQuery("SELECT r FROM Role r WHERE r.role = :typee", Role.class)
                .setParameter("typee", UserRole.valueOf(type.name())) // no clue why it doesnt work with just the type param
                .getSingleResult();
    }

    @Override
    public Tube update(Tube entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Role findById(Integer id) {
        return null;
    }
}
