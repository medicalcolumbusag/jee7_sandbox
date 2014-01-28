package de.medicalcolumbus.sandbox.domain.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.medicalcolumbus.sandbox.domain.HospitalMapping;
import de.medicalcolumbus.sandbox.domain.HospitalMappingId;

@Stateless
public class HospitalMappingDaoBean implements HospitalMappingDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<HospitalMapping> findByCustomerId(String customerId) {
		return em.createNamedQuery(	HospitalMapping.FIND_BY_CUSTOMER_ID,
									HospitalMapping.class).setParameter("customerId",
																		customerId).getResultList();
	}

	@Override
	public HospitalMapping findByPrimaryKey(String customerId,
											String customerMaterialId,
											String salesUnit,
											String vendorId) {

		HospitalMappingId hospitalMappingId = new HospitalMappingId(customerId,
																	customerMaterialId,
																	salesUnit,
																	vendorId);

		return em.find(HospitalMapping.class, hospitalMappingId);

	}
}
