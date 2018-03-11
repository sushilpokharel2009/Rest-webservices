package com.vendor.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vendor.rest.status.VendorEnum;

@Entity
@Table(name = "VENDOR_DB")
@NamedQuery(name=QueryConstant.VENDOR_SEARCH_QUERY,query="select v from VendorEntity v where UPPER(v.vendorName)=:vendorName ")
public class VendorEntity {
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="vSeq",sequenceName="VENDOR_SEQ")
	@GeneratedValue(generator="vSeq")
	private Long id;
	
	
	@Column(name = "VENDOR_NAME")
	private String vendorName;
	
	@Column(name = "STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ZIP_CODE")
	private String zipCode;
	
	@Column(name = "VENDOR_PHONE_NUMBER")
	private String vendorPhoneNumber;
			
	@Column(name = "VENDOR_FAX_NUMBER")
	private String vendorFaxNumber;
	
	@Column(name = "VENDOR_CODE")
	private String vendorCode;
	
	@Column(name = "VENDOR_EMAIL")
	private  String vendorEmail;
	
	 @Enumerated(EnumType.ORDINAL)
	@Column(name = "VENDOR_STATUS")
	private VendorEnum status;

	

	public VendorEnum getStatus() {
		return status;
	}

	public void setStatus(VendorEnum status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getVendorPhoneNumber() {
		return vendorPhoneNumber;
	}

	public void setVendorPhoneNumber(String vendorPhoneNumber) {
		this.vendorPhoneNumber = vendorPhoneNumber;
	}

	public String getVendorFaxNumber() {
		return vendorFaxNumber;
	}

	public void setVendorFaxNumber(String vendorFaxNumber) {
		this.vendorFaxNumber = vendorFaxNumber;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	@Override
	public String toString() {
		return "VendorEntity [id=" + id + ", vendorName=" + vendorName + ", streetAddress=" + streetAddress
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", vendorPhoneNumber=" + vendorPhoneNumber + ", vendorFaxNumber=" + vendorFaxNumber + ", vendorCode="
				+ vendorCode + ", vendorEmail=" + vendorEmail + "]";
	}

	
	
	
		
	
}




