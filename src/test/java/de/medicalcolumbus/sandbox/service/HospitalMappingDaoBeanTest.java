package de.medicalcolumbus.sandbox.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import de.medicalcolumbus.sandbox.domain.HospitalMapping;
import de.medicalcolumbus.sandbox.domain.HospitalMappingId;
import de.medicalcolumbus.sandbox.domain.dao.HospitalMappingDao;

public class HospitalMappingDaoBeanTest extends BaseArquillianTest {

	@Inject
	private HospitalMappingDao hospitalMappingDao;

	@Test @Ignore
	public void findHospitalMappingByPrimaryKey() throws ParseException {

		HospitalMappingId hospitalMappingId = new HospitalMappingId("77548",
																	"202491",
																	"Stück",
																	"9878787");

		Assert.assertNotNull(hospitalMappingDao.findByPrimaryKey(hospitalMappingId));
	}

	@Test
	public void createHospitalMapping() throws ParseException {

		HospitalMappingId hospitalMappingId = new HospitalMappingId("77528",
																	"2024221",
																	"Stücke",
																	"9824447");

		String autoCounter = "434334";
		String createUser = "liparulol";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date createDate = sdf.parse("21/12/2012");
		Long amountNumerator = 1L;
		Long amountDenominator = 2L;
		Long priceNumerator = 2L;
		Long priceDenominator = 3L;

		HospitalMapping hospitalMapping = new HospitalMapping(	hospitalMappingId,
																autoCounter,
																createUser,
																createDate,
																amountNumerator,
																amountDenominator,
																priceNumerator,
																priceDenominator);

		hospitalMappingDao.createHospitalMapping(hospitalMapping);
	}

	@Test @Ignore
	public void deleteHospitalMapping() throws ParseException {

		HospitalMappingId hospitalMappingId = new HospitalMappingId("71538","211191",
																	"Stück","3232123");

		hospitalMappingDao.removeHospitalMapping(hospitalMappingId);

	}

}
