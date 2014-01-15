package com.tutorial;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "Employee.findAll", query = "select o from Employee o"),
		@NamedQuery(name = "Employee.findByEmail", query = "select o from Employee o where o.email = :email") })
@Table(name = "EMPLOYEES")
public class Employee {
	@Column(name = "COMMISSION_PCT")
	private Double commissionPct;
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	@Column(nullable = false, unique = true, length = 25)
	private String email;
	@Id
	@Column(name = "EMPLOYEE_ID", nullable = false)
	private Long employeeId;
	@Column(name = "FIRST_NAME", length = 20)
	private String firstName;
	@Column(name = "HIRE_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	@Column(name = "JOB_ID", nullable = false, length = 10)
	private String jobId;
	@Column(name = "LAST_NAME", nullable = false, length = 25)
	private String lastName;
	@Column(name = "PHONE_NUMBER", length = 20)
	private String phoneNumber;
	private Double salary;
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee employee;
	@OneToMany(mappedBy = "employee")
	private List<Employee> employeeList;

	public Employee() {
	}

	public Employee(Double commissionPct, Long departmentId, String email,
			Long employeeId, String firstName, Date hireDate,
			String jobId, String lastName, Employee employee,
			String phoneNumber, Double salary) {
		this.commissionPct = commissionPct;
		this.departmentId = departmentId;
		this.email = email;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.lastName = lastName;
		this.employee = employee;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public Employee addEmployee(Employee employee) {
		getEmployeeList().add(employee);
		employee.setEmployee(this);
		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployeeList().remove(employee);
		employee.setEmployee(null);
		return employee;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName
				+ (employee != null ? "(manager : " + employee + ")" : "");
	}
}
