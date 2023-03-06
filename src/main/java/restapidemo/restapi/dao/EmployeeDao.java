package restapidemo.restapi.dao;

import restapidemo.restapi.domain.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    int create(Employee employee);

    Optional<Employee> find(int id);

    int delete(int id);

    int checkForEmployee(int id);

    List<Employee> listAllEmployees();
}