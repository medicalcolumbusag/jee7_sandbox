package de.medicalcolumbus.sandbox.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = HospitalMapping.FIND_BY_CUSTOMER_ID,
				query = "select o from HospitalMapping o where o.hospitalMappingId.customerId = :customerId")
				})
@Table(name = "SBE_ETN_MAP_HOSPITAL")
public class HospitalMapping {

	public final static String FIND_BY_CUSTOMER_ID = "HospitalMapping.findByCustomerId";

	@EmbeddedId
	private HospitalMappingId hospitalMappingId;

	@Column(name = "MC_ID", nullable = false, length = 30)
	private String mcId;

	@Column(name = "MULTIPLIER")
	private Long multiplier;

	@Column(name = "DIVISOR")
	private Long divisor;

	@Column(name = "CREATE_USER", nullable = false, length = 30)
	private String createUser;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", nullable = false)  //date oracle
	private Date createDate;

	@Column(name = "CHANGE_USER", length = 30)
	private String changeUser;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHANGE_DATE")
	private Date changeDate;

	@Column(name = "SPARTE", nullable = false, length = 2)
	private String branch; //default M

	@Column(name = "CTRL_FLAG", length = 2)
	private String ctrlFlag;

	@Column(name = "COMPLEMENT", length = 20)
	private String complement;

	@Column(name = "REFERENCE", length = 50)
	private String reference;

	@Column(name = "MENGEN_ZAEHLER" )
	private Long amountNumerator;

	@Column(name = "MENGEN_NENNER" )
	private Long amountDenominator;

	@Column(name = "PREIS_ZAEHLER" )
	private Long priceNumerator;

	@Column(name = "PREIS_NENNER" )
	private Long priceDenominator;

	@Column(name = "LOCK_ARTICLE", length = 1)
	private String lockArticle;

	public HospitalMapping() {
		super();
	}

	public HospitalMapping(	HospitalMappingId hospitalMappingId,
							String mcId,
							Long multiplier,
							Long divisor,
							String createUser,
							Date createDate,
							String changeUser,
							Date changeDate,
							String branch,
							String ctrlFlag,
							String complement,
							String reference,
							String vendorId,
							Long amountNumerator,
							Long amountDenominator,
							Long priceNumerator,
							Long priceDenominator,
							String lockArticle) {
		super();
		this.hospitalMappingId = hospitalMappingId;
		this.mcId = mcId;
		this.multiplier = multiplier;
		this.divisor = divisor;
		this.createUser = createUser;
		this.createDate = createDate;
		this.changeUser = changeUser;
		this.changeDate = changeDate;
		this.branch = branch;
		this.ctrlFlag = ctrlFlag;
		this.complement = complement;
		this.reference = reference;
		this.amountNumerator = amountNumerator;
		this.amountDenominator = amountDenominator;
		this.priceNumerator = priceNumerator;
		this.priceDenominator = priceDenominator;
		this.lockArticle = lockArticle;
	}

	public HospitalMappingId getHmp() {
		return hospitalMappingId;
	}

	public void setHmp(HospitalMappingId hospitalMappingId) {
		hospitalMappingId = hospitalMappingId;
	}

	public String getMcId() {
		return mcId;
	}

	public void setMcId(String mcId) {
		this.mcId = mcId;
	}

	public Long getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(Long multiplier) {
		this.multiplier = multiplier;
	}

	public Long getDivisor() {
		return divisor;
	}

	public void setDivisor(Long divisor) {
		this.divisor = divisor;
	}

	public String getCreateUser() {
		return createUser;
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

	public String getChangeUser() {
		return changeUser;
	}

	public void setChangeUser(String changeUser) {
		this.changeUser = changeUser;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCtrlFlag() {
		return ctrlFlag;
	}

	public void setCtrlFlag(String ctrlFlag) {
		this.ctrlFlag = ctrlFlag;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public String getLockArticle() {
		return lockArticle;
	}

	public void setLockArticle(String lockArticle) {
		this.lockArticle = lockArticle;
	}

}
