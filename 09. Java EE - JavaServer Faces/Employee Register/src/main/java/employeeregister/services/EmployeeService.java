package employeeregister.services;

import employeeregister.domain.models.EmployeeRegisterBindingModel;
import employeeregister.domain.models.EmployeeViewModel;

import java.util.List;

public interface EmployeeService {
    void save(EmployeeRegisterBindingModel employee);

    List<EmployeeViewModel> findAll();

    boolean removeEmployee(String id);
}
