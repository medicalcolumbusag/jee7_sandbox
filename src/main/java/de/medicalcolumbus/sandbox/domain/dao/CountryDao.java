package de.medicalcolumbus.sandbox.domain.dao;

import de.medicalcolumbus.sandbox.domain.entity.Country;

import java.util.List;

/**
 * Created by chromyd on 22/01/14.
 */
public interface CountryDao {
	List<Country> findAll();
}
