package de.medicalcolumbus.sandbox.web.model;

import de.medicalcolumbus.sandbox.domain.entity.Country;
import org.primefaces.model.SelectableDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Data model for the country list.
 *
 * @author chromyd
 */
public class CountryDataModel extends ListDataModel<Country> implements SelectableDataModel<Country> {
	private static Logger log = LoggerFactory.getLogger(CountryDataModel.class);

	public CountryDataModel(List<Country> list) {
		super(list);
	}

	@Override
	public Object getRowKey(Country country) {
		return country.getCountryId();
	}

	@Override
	public Country getRowData(String s) {
		for (Country c : (List<Country>) getWrappedData()) {
			if (c.getCountryId().equals(s)) return c;
		}
		return null;
	}

	public void deleteCountry(Country country) {
		log.debug("Trying to delete {}", country);
		((List<Country>) getWrappedData()).remove(country);
	}
}
