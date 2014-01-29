package de.medicalcolumbus.sandbox.domain.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.medicalcolumbus.sandbox.domain.HospitalMapping;
import de.medicalcolumbus.sandbox.domain.HospitalMappingId;

@Stateless
public class HospitalMappingDaoBean implements HospitalMappingDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	public HospitalMapping findByPrimaryKey(HospitalMappingId hospitalMappingId) {

		return em.find(HospitalMapping.class, hospitalMappingId);

	}

	@Override @Transactional
	public void createHospitalMapping(HospitalMapping hospitalMapping) {

		em.persist(hospitalMapping);

	}

	@Override @Transactional
	public void removeHospitalMapping(HospitalMappingId hospitalMappingId) {

		em.remove(em.find(HospitalMapping.class, hospitalMappingId));

	}

}
