package employeeregister.repositories;

import employeeregister.domain.entities.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext(unitName = "employee_register")
    private EntityManager manager;

    @Override
    public void save(Employee employee) {
        this.manager.persist(employee);
    }

    @Override
    public List<Employee> findAll() {
        return this.manager
                .createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }

    @Override
    public boolean delete(String id) {
        int res = this.manager
                .createQuery("DELETE FROM Employee e WHERE e.id = :id")
                .setParameter("id", id)
                .executeUpdate();

        return res > 0;
    }
}
