package com.tutorial;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeMgrBean implements EmployeeMgr {


	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> findAll() {
		return em.createNamedQuery("Employee.findAll", Employee.class)
				.getResultList();

	}

	@Override
	public Employee findByEmail(String email) {
		return em.createNamedQuery("Employee.findByEmail", Employee.class)
				.setParameter("email", email).getSingleResult();

	}

}
