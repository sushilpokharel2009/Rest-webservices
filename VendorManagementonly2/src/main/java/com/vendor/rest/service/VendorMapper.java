package com.vendor.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vendor.rest.entity.VendorEntity;
import com.vendor.rest.vo.VendorVO;

@Component
public class VendorMapper {

	public VendorEntity mapToVendorEntity(final VendorVO vo) {
		return mapToVendorEntity(new VendorEntity(), vo);

	}

	public VendorEntity mapToVendorEntity(final VendorEntity vendorEntity, final VendorVO vo) {
		vendorEntity.setVendorName(vo.getVendorName());
		vendorEntity.setStreetAddress(vo.getStreetAddress());
		vendorEntity.setAddressLine2(vo.getAddressLine2());
		vendorEntity.setCity(vo.getCity());
		vendorEntity.setState(vo.getState());
		vendorEntity.setZipCode(vo.getZipCode());
		vendorEntity.setVendorPhoneNumber(vo.getVendorPhoneNumber());
		vendorEntity.setVendorFaxNumber(vo.getVendorFaxNumber());
		vendorEntity.setVendorCode(vo.getVendorCode());
		vendorEntity.setVendorEmail(vo.getVendorEmail());
		return vendorEntity;
	}

	public VendorVO mapToVendorVO(final VendorEntity entity) {
		VendorVO vo = new VendorVO();
		vo.setVendorName(entity.getVendorName());
		vo.setStreetAddress(entity.getStreetAddress());
		vo.setAddressLine2(entity.getAddressLine2());
		vo.setCity(entity.getCity());
		vo.setState(entity.getState());
		vo.setZipCode(entity.getZipCode());
		vo.setVendorPhoneNumber(entity.getVendorPhoneNumber());
		vo.setVendorFaxNumber(entity.getVendorFaxNumber());
		vo.setVendorCode(entity.getVendorCode());
		vo.setVendorEmail(entity.getVendorEmail());
		return vo;
	}

	public List<VendorVO> mapToVendorVO(final List<VendorEntity> entityList) {
		final List<VendorVO> li = new ArrayList<VendorVO>();
		for (VendorEntity entity : entityList) {
			li.add(mapToVendorVO(entity));
		}
		return li;
	}

}
