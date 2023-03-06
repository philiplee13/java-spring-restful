package restapidemo.restapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import restapidemo.restapi.domain.Employee;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Employee employee) {
        String sql = """
                INSERT INTO employees (first_name, last_name)
                VALUES (?,?);
                """;
        return jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName());
    }

    @Override
    public Optional<Employee> find(int id) {
        String sql = """
                SELECT * FROM employees
                WHERE employee_id = ?;
                """;
        Employee employee = jdbcTemplate.queryForObject(
            sql,
            (resultSet, index) -> {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int employeeId = resultSet.getInt("employee_id");
                return new Employee(firstName, lastName, employeeId);
            }, new Object[]{id});
        return Optional.ofNullable(employee);
    }

    @Override
    public int delete(int id) {
        String sql = """
                DELETE FROM employees
                WHERE employee_id = ?;
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int checkForEmployee(int id) {
        String sql = """
                SELECT count(*) FROM employees
                WHERE employee_id = ?
                """;
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[]{id});
    }

    @Override
    public List<Employee> listAllEmployees() {
        String sql = """
                SELECT * FROM employees;
                """;
        return jdbcTemplate.query(sql, (resultSet, index) -> {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int employeeId = resultSet.getInt("employee_id");
            Employee employee = new Employee(firstName, lastName, employeeId);
            return employee;
        });
    }
}