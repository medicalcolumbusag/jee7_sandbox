package com.tutorial;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tutorial.qualifiers.EmployeeBeanQ;

@Stateless
@EmployeeBeanQ
public class EmployeeMgrBean implements EmployeeMgr {


	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> findAll() {
		return em.createNamedQuery(Employee.FIND_ALL, Employee.class)
				.getResultList();


	}

	@Override
	public Employee findByEmail(String email) {
		return em.createNamedQuery(Employee.FIND_BY_EMAIL, Employee.class)
				.setParameter("email", email).getSingleResult();


	}

}
