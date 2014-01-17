package de.medicalcolumbus.sandbox.domain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a transfer object containing all data that the user needs to see.
 * @author Dusan Chromy
 */
@NamedNativeQuery(
        name="EmployeeDetails.findByCountryId",
        query="SELECT " +
                "  e.first_name, " +
                "  e.last_name, " +
                "  e.email, " +
                "  e.hire_date, " +
                "  d.department_name, " +
                "  l.city, " +
                "  l.state_province, " +
                "  l.country_id  " +
                "FROM " +
                "  employees e  " +
                "    JOIN departments d  " +
                "    ON e.department_id=d.department_id  " +
                "      JOIN locations l  " +
                "      ON d.location_id=l.location_id " +
                "WHERE l.country_id = ?1"
        ,
        resultSetMapping="employee-details"
)
@SqlResultSetMapping(name="employee-details",
        classes={
                @ConstructorResult(targetClass=EmployeeDetails.class, columns={
                        @ColumnResult(name="first_name", type=String.class),
                        @ColumnResult(name="last_name", type=String.class),
                        @ColumnResult(name="email", type=String.class),
                        @ColumnResult(name="hire_date", type=Date.class),
                        @ColumnResult(name="department_name", type=String.class),
                        @ColumnResult(name="city", type=String.class),
                        @ColumnResult(name="state_province", type=String.class),
                        @ColumnResult(name="country_id", type=String.class)
                })
        }
)
@Entity
public class EmployeeDetails {
    private String firstName;
    private String lastName;
    @Id
    private String email;
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    private String departmentName;
    private String city;
    private String stateProvince;
    private String countryId;

    public EmployeeDetails() {
    }

    public EmployeeDetails(String firstName, String lastName, String email, Date hireDate, String departmentName, String city, String stateProvince, String countryId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.departmentName = departmentName;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
