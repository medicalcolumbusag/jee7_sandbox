package de.medicalcolumbus.sandbox.domain.dao;

import de.medicalcolumbus.sandbox.domain.entity.EmployeeDetails;

import java.util.List;

/**
 * Created by chromyd on 17/01/14.
 */
public interface EmployeeDetailsDao {
    List<EmployeeDetails> findByCountryId(String countryId);
}
