package com.tutorial;

import java.util.List;

import javax.ejb.Local;

@Local
public interface EmployeeMgr {
	List<Employee> findAll();
	Employee findByEmail(String email);
}
