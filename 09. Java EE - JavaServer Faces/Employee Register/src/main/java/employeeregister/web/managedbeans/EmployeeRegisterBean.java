package employeeregister.web.managedbeans;

import employeeregister.domain.models.EmployeeRegisterBindingModel;
import employeeregister.services.EmployeeService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class EmployeeRegisterBean {

    private EmployeeService employeeService;

    private EmployeeRegisterBindingModel employee = new EmployeeRegisterBindingModel();

    @Inject
    public EmployeeRegisterBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void register() {
        int a = 5;
        int b = 10;
    }

    public EmployeeRegisterBindingModel getEmployee() {
        return this.employee;
    }

    public void setEmployee(EmployeeRegisterBindingModel employee) {
        this.employee = employee;
    }
}
