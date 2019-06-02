package employeeregister.repositories;

import employeeregister.domain.entities.Employee;

import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee);

    List<Employee> findAll();

    boolean delete(String id);
}
