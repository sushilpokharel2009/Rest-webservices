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
	
	List<VendorVO> searchActiveVendor(String active);

	VendorVO searchVendorByName(String vendorName);

	


}
