/**
 * LoginBean.java
 * 
 */

package com.tutorial;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginBean {
	private String name;
	private String password;
	private int age;

	@EJB
	private EmployeeMgr employeeMgr;

	public String getName() {
		return name;
	}

	public Employee getEmployeeByEmail() {

		return employeeMgr.findByEmail(name);
	}

	public List<Employee> getEmployees() {
		return employeeMgr.findAll();
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
