package de.medicalcolumbus.sandbox.web.model;

import de.medicalcolumbus.sandbox.domain.entity.Country;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Data model for the country list.
 *
 * @author chromyd
 */
public class CountryDataModel extends ListDataModel<Country> implements SelectableDataModel<Country> {
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

	public void deleteFirstCountry() {
		((List<Country>) getWrappedData()).remove(0);
	}
}
