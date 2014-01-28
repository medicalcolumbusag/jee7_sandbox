package de.medicalcolumbus.sandbox.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class HospitalMappingId implements Serializable{

	@Column(name = "CUST_ID", nullable = false, length = 20)
	private String customerId;

	@Column(name = "MATERIAL_ID", nullable = false, length = 50)
	private String customerMaterialId;

	@Column(name = "SALES_UNIT", nullable = false, length = 10)
	private String salesUnit;

	@Column(name = "KREDITOR_ID", nullable = false, length = 30)
	private String vendorId;



	public HospitalMappingId() {
		super();
	}
	public HospitalMappingId(	String customerId,
								String materialId,
								String salesUnit,
								String vendorId) {
		super();
		this.customerId = customerId;
		this.customerMaterialId = materialId;
		this.salesUnit = salesUnit;
		this.vendorId = vendorId;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMaterialId() {
		return customerMaterialId;
	}
	public void setMaterialId(String materialId) {
		this.customerMaterialId = materialId;
	}

	public String getSalesUnit() {
		return salesUnit;
	}
	public void setSalesUnit(String salesUnit) {
		this.salesUnit = salesUnit;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
					* result
					+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime
					* result
					+ ((customerMaterialId == null) ? 0 : customerMaterialId.hashCode());
		result = prime
					* result
					+ ((salesUnit == null) ? 0 : salesUnit.hashCode());
		result = prime
					* result
					+ ((vendorId == null) ? 0 : vendorId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HospitalMappingId other = (HospitalMappingId) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		}
		else
			if (!customerId.equals(other.customerId))
				return false;
		if (customerMaterialId == null) {
			if (other.customerMaterialId != null)
				return false;
		}
		else
			if (!customerMaterialId.equals(other.customerMaterialId))
				return false;
		if (salesUnit == null) {
			if (other.salesUnit != null)
				return false;
		}
		else
			if (!salesUnit.equals(other.salesUnit))
				return false;
		if (vendorId == null) {
			if (other.vendorId != null)
				return false;
		}
		else
			if (!vendorId.equals(other.vendorId))
				return false;
		return true;
	}




}
