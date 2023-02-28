package restapidemo.restapi.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restapidemo.restapi.domain.Employee;
import restapidemo.restapi.service.EmployeeService;
import java.util.List;
import java.util.Optional;



@RequestMapping("api/v1/employee")
@RestController
public class EmployeeEndpoint {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeEndpoint(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) { 
        employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path="{id}")
    public Employee getSpecificEmployee(@PathVariable int id) {
        return employeeService.getSpecificEmployee(id);
    }

    @DeleteMapping(path="{id}")
    public int deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

}