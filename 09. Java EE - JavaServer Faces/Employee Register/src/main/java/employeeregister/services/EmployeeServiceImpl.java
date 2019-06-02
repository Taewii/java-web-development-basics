package employeeregister.services;

import employeeregister.domain.entities.Employee;
import employeeregister.domain.models.EmployeeRegisterBindingModel;
import employeeregister.domain.models.EmployeeViewModel;
import employeeregister.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(EmployeeRegisterBindingModel employee) {
        this.employeeRepository.save(this.mapper.map(employee, Employee.class));
    }

    @Override
    public List<EmployeeViewModel> findAll() {
        return this.employeeRepository
                .findAll()
                .stream()
                .map(employee -> this.mapper.map(employee, EmployeeViewModel.class))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean removeEmployee(String id) {
        return this.employeeRepository.delete(id);
    }
}
