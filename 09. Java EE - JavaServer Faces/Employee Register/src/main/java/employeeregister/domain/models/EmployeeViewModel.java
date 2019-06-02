package employeeregister.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeViewModel {

    private String id;
    private String firstName;
    private String lastName;
    private String position;
    private BigDecimal salary;
    private int age;
}
