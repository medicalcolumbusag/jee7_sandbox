package de.medicalcolumbus.sandbox.domain.entity;

import javax.persistence.*;

/**
 * Represents the country entity.
 *
 * @author chromyd
 */
@Entity
@NamedQueries(@NamedQuery(name = "Country.findAll", query = "select o from Country o"))
@Table(name = "COUNTRIES")
public class Country {
	@Id
	@Column(name = "COUNTRY_ID")
	private String countryId;
	@Column(name = "COUNTRY_NAME")
	private String countryName;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
}
