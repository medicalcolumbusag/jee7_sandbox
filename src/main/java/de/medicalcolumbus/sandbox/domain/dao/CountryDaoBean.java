package de.medicalcolumbus.sandbox.domain.dao;

import de.medicalcolumbus.sandbox.domain.entity.Country;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by chromyd on 17/01/14.
 */
@Stateless
public class CountryDaoBean implements CountryDao {

	@PersistenceContext
	private EntityManager em;


	@Override
	public List<Country> findAll() {
		return em.createNamedQuery("Country.findAll", Country.class).getResultList();
	}
}
