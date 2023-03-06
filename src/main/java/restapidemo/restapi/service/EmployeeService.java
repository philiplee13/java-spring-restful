package restapidemo.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restapidemo.restapi.dao.EmployeeDaoImpl;
import restapidemo.restapi.domain.Employee;
import java.util.List;


@Service
public class EmployeeService {

    private EmployeeDaoImpl employeeDaoImpl;

    @Autowired
    public EmployeeService(EmployeeDaoImpl employeeDao) {
        this.employeeDaoImpl = employeeDao;
    }

    public int createEmployee(Employee employee) {
        return employeeDaoImpl.create(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDaoImpl.listAllEmployees();
    }

    public Employee getSpecificEmployee(int id) {
        return employeeDaoImpl.find(id).orElse(null);
    }

    public int deleteEmployee(int id) {
        return employeeDaoImpl.delete(id);
    }

    public int checkForEmployee(int id) {
        return employeeDaoImpl.checkForEmployee(id);
    }

}