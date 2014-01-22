package de.medicalcolumbus.sandbox.web.bean;

import de.medicalcolumbus.sandbox.domain.dao.CountryDao;
import de.medicalcolumbus.sandbox.domain.dao.EmployeeDetailsDao;
import de.medicalcolumbus.sandbox.domain.entity.Country;
import de.medicalcolumbus.sandbox.domain.entity.EmployeeDetails;
import de.medicalcolumbus.sandbox.web.model.CountryDataModel;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

/**
 * Managed bean for the countries and employees view.
 *
 * @author chromyd
 */
@ManagedBean
@ViewScoped
public class CrossBean {
	private Country selectedCountry;
	@Inject
	private CountryDao countryDao;
	@Inject
	private EmployeeDetailsDao employeeDetailsDao;
	private CountryDataModel countryDataModel;

	@PostConstruct
	public void initializeModel() {
		countryDataModel = new CountryDataModel(countryDao.findAll());
		System.out.println("Initialized the model!");
	}

	public List<Country> getCountries() {
		return countryDao.findAll();
	}
	public CountryDataModel getCountryDataModel() {
		return countryDataModel;
	}

	public void setCountryDataModel(CountryDataModel countryDataModel) {
		this.countryDataModel = countryDataModel;
	}

	public Country getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(Country selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public List<EmployeeDetails> getEmployeesForSelectedCountry() {
		System.out.println("Getting employees for " + selectedCountry);
		if (selectedCountry == null) {
			return Collections.EMPTY_LIST;
		} else {
			return employeeDetailsDao.findByCountryId(selectedCountry.getCountryId());
		}
	}
}
