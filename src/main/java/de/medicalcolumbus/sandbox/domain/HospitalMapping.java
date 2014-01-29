package de.medicalcolumbus.sandbox.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SBE_ETN_MAP_HOSPITAL")
public class HospitalMapping {

	public final static String FIND_BY_CUSTOMER_ID = "HospitalMapping.findByCustomerId";

	@EmbeddedId
	private HospitalMappingId hospitalMappingId;

	@Column(name = "MC_ID", nullable = false, length = 30)
	private String autoCounter;

	@Column(name = "CREATE_USER", nullable = false, length = 30)
	private String createUser;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", nullable = false)  //date oracle
	private Date createDate;

	@Column(name = "MENGEN_ZAEHLER" )
	private Long amountNumerator;

	@Column(name = "MENGEN_NENNER" )
	private Long amountDenominator;

	@Column(name = "PREIS_ZAEHLER" )
	private Long priceNumerator;

	@Column(name = "PREIS_NENNER" )
	private Long priceDenominator;

	public HospitalMapping() {
		super();
	}

	public HospitalMapping(	HospitalMappingId hospitalMappingId,
							String autoCounter,
							String createUser,
							Date createDate,
							Long amountNumerator,
							Long amountDenominator,
							Long priceNumerator,
							Long priceDenominator)
	{
		super();
		this.hospitalMappingId = hospitalMappingId;
		this.autoCounter = autoCounter;
		this.createUser = createUser;
		this.createDate = createDate;
		this.amountNumerator = amountNumerator;
		this.amountDenominator = amountDenominator;
		this.priceNumerator = priceNumerator;
		this.priceDenominator = priceDenominator;
	}

	public HospitalMappingId getHospitalMappingId() {
		return hospitalMappingId;
	}

	public void setHospitalMappingId(HospitalMappingId hospitalMappingId) {
		this.hospitalMappingId = hospitalMappingId;
	}

	public String getAutoCounter() {
		return autoCounter;
	}

	public void setAutoCounter(String autoCounter) {
		this.autoCounter = autoCounter;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getAmountNumerator() {
		return amountNumerator;
	}

	public void setAmountNumerator(Long amountNumerator) {
		this.amountNumerator = amountNumerator;
	}

	public Long getAmountDenominator() {
		return amountDenominator;
	}

	public void setAmountDenominator(Long amountDenominator) {
		this.amountDenominator = amountDenominator;
	}

	public Long getPriceNumerator() {
		return priceNumerator;
	}

	public void setPriceNumerator(Long priceNumerator) {
		this.priceNumerator = priceNumerator;
	}

	public Long getPriceDenominator() {
		return priceDenominator;
	}

	public void setPriceDenominator(Long priceDenominator) {
		this.priceDenominator = priceDenominator;
	}

}
