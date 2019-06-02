package employeeregister.web.managedbeans;

import employeeregister.domain.models.EmployeeViewModel;
import employeeregister.services.EmployeeService;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Model
@Getter
@NoArgsConstructor
public class ListEmployeesBean {

    private List<EmployeeViewModel> employees;
    private BigDecimal totalSalaries;
    private BigDecimal averageSalary;

    // throws "Error trying to load resource components.css with library primefaces",
    // but everything seems to be working
    private void init() {
        for (EmployeeViewModel employee : this.employees) {
            this.totalSalaries = this.totalSalaries.add(employee.getSalary());
        }
        if (!this.employees.isEmpty()) {
            this.averageSalary = this.totalSalaries.divide(BigDecimal.valueOf(this.employees.size()), 2, RoundingMode.HALF_UP);
        }
    }

    @Inject
    public ListEmployeesBean(EmployeeService employeeService) {
        this.employees = employeeService.findAll();
        this.totalSalaries = BigDecimal.ZERO;
        this.averageSalary = BigDecimal.ZERO;
        this.init();
    }
}
