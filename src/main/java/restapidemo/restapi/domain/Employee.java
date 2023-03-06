package restapidemo.restapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Employee {
    
    @Id @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    public Employee() {}

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        int employeeId
        ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = employeeId;
    }


    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}