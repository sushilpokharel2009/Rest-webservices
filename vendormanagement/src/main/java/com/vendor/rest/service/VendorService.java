package com.vendor.rest.service;

import java.util.List;

import com.vendor.rest.entity.VendorEntity;
import com.vendor.rest.vo.VendorVO;

public interface VendorService {
	
	VendorVO createVendor(final VendorVO vendor);
	
	VendorVO updateVendor(final VendorVO vendor);
	
	void activateVendor(Long pk);
	
	void deActivateVendor(final Long pk);
	
	VendorVO findVendorById(Long pk);
	
	VendorEntity findVendorByCode(final String vendorCode);
	
//	List<VendorVO> searchActiveVendor();
	List<VendorVO> searchActiveVendor(Object active);
	
	List<VendorVO> searchVendor(String VendorName, String streetAddress, String addressLine2, String city,
			String state, String zipCode, String vendorPhoneNumber, String vendorFaxNumber, String vendorCode);
	
	
	List<VendorVO> searchVendorByName(String VendorName);
	
	List<VendorVO> searchVendorByAddress( String streetAddress);
	
	List<VendorVO> searchVendorByCity(String city);
	
	List<VendorVO> searchVendorByState(String state);
	
	
	
}
