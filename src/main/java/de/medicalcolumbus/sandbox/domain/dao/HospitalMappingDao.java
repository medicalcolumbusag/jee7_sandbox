package de.medicalcolumbus.sandbox.domain.dao;

import de.medicalcolumbus.sandbox.domain.HospitalMapping;
import de.medicalcolumbus.sandbox.domain.HospitalMappingId;

public interface HospitalMappingDao {

	HospitalMapping findByPrimaryKey(HospitalMappingId hospitalMappingId);

	void createHospitalMapping(HospitalMapping hospitalMapping);

	void removeHospitalMapping(HospitalMappingId hospitalMappingId);

}
