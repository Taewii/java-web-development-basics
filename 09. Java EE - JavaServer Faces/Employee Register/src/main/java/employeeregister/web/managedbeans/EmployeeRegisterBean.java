package employeeregister.web.managedbeans;

import employeeregister.domain.models.EmployeeRegisterBindingModel;
import employeeregister.services.EmployeeService;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

@Model
@NoArgsConstructor
public class EmployeeRegisterBean {

    private EmployeeService employeeService;

    private EmployeeRegisterBindingModel employee = new EmployeeRegisterBindingModel();

    @Inject
    public EmployeeRegisterBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void register() throws IOException {
        this.employeeService.save(this.employee);
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }

    public EmployeeRegisterBindingModel getEmployee() {
        return this.employee;
    }

    public void setEmployee(EmployeeRegisterBindingModel employee) {
        this.employee = employee;
    }
}
