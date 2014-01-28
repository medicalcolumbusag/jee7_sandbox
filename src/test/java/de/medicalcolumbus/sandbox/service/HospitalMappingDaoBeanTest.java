package de.medicalcolumbus.sandbox.service;

import static org.hamcrest.core.Is.is;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import de.medicalcolumbus.sandbox.domain.HospitalMapping;
import de.medicalcolumbus.sandbox.domain.dao.HospitalMappingDao;

public class HospitalMappingDaoBeanTest extends BaseArquillianTest {

	@Inject
	private HospitalMappingDao hospitalMappingDao;

	@Test
	public void shouldFindHospitalMappingByPrimaryKey() throws ParseException {

		Assert.assertNotNull(hospitalMappingDao.findByPrimaryKey(	"77548",
																	"202491",
																	"Stück",
																	"9878787"));

	}

	@Test
	public void shouldFindAllRowsbyCustomerId() {

		List<HospitalMapping> hospitalMappingList = hospitalMappingDao.findByCustomerId("77548");

		for (HospitalMapping hp : hospitalMappingList) {
			System.out.println(hp.getMcId() + " " + hp.getCreateUser());
		}

		Assert.assertThat(hospitalMappingList.size(), is(2));

	}

}
