package employeeregister.web.managedbeans;

import employeeregister.services.EmployeeService;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

@Model
@NoArgsConstructor
public class RemoveEmployeeBean {

    private EmployeeService employeeService;

    @Inject
    public RemoveEmployeeBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void remove(String id) throws IOException {
        this.employeeService.removeEmployee(id);
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }
}
