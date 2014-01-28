package de.medicalcolumbus.sandbox.domain.dao;

import java.util.List;

import de.medicalcolumbus.sandbox.domain.HospitalMapping;

public interface HospitalMappingDao {

	List<HospitalMapping> findByCustomerId(String customerId);

	HospitalMapping findByPrimaryKey(	String customerId,
										String customerMaterialId,
										String salesUnit,
										String vendorId);
}
