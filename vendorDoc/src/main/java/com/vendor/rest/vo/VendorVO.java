package com.vendor.rest.vo;

public class VendorVO {
	private long pk;
	private String VendorName;
	private String streetAddress;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String vendorPhoneNumber;
	private String vendorFaxNumber;
	private String vendorCode;
	
	public VendorVO() {
		
	}
	
	public VendorVO(long pk, String vendorName, String streetAddress, String addressLine2, String city, String state,
			String zipCode, String vendorPhoneNumber, String vendorFaxNumber, String vendorCode, String vendorEmail) {
		super();
		this.pk = pk;
		VendorName = vendorName;
		this.streetAddress = streetAddress;
		this.addressLine2 = addressLine2;
		this.city = city; 
		this.state = state;
		this.zipCode = zipCode;
		this.vendorPhoneNumber = vendorPhoneNumber;
		this.vendorFaxNumber = vendorFaxNumber;
		this.vendorCode = vendorCode;
		this.vendorEmail = vendorEmail;
	}
	
	public long getPk() {
		return pk;
	}
	public void setPk(long pk) {
		this.pk = pk;
	}
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
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
	private String vendorEmail;



	@Override
	public String toString() {
		return "VendorVO [pk=" + pk + ", VendorName=" + VendorName + ", streetAddress=" + streetAddress
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", vendorPhoneNumber=" + vendorPhoneNumber + ", vendorFaxNumber=" + vendorFaxNumber + ", vendorCode="
				+ vendorCode + ", vendorEmail=" + vendorEmail + "]";
	}
	
}
