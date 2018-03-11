package com.vendor.test;



import com.vendor.rest.entity.VendorEntity;
import com.vendor.rest.vo.VendorVO;

public class VendorData {
	
	public static VendorVO createVendorVO() {
		VendorVO vo = new VendorVO();
		vo.setVendorName("Coors Light");;
		vo.setStreetAddress("1905 Charlie Road");
		vo.setAddressLine2("123");;
		vo.setCity("Fortworth");
		vo.setState("Tx");;
		vo.setZipCode("76108");
		vo.setVendorPhoneNumber("33333333");
		vo.setVendorFaxNumber("222-2222222");
		vo.setVendorCode("222");
		vo.setVendorEmail("Personal Laptop");
		
		return vo;
	}

	public static VendorEntity createVendorEntity() {
		VendorEntity entity = new VendorEntity();
		entity.setVendorName("Coors Light");;
		entity.setStreetAddress("1905 Charlie Road");
		entity.setAddressLine2("123");;
		entity.setCity("Fortworth");
		entity.setState("Tx");;
		entity.setZipCode("76108");
		entity.setVendorPhoneNumber("33333333");
		entity.setVendorFaxNumber("222-2222222");
		entity.setVendorCode("222");
		entity.setVendorEmail("Personal Laptop");
		entity.setId((long)777);
		return entity;
	}

}
