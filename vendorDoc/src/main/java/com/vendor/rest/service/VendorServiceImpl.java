package com.vendor.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vendor.rest.entity.QueryConstant;
import com.vendor.rest.entity.VendorEntity;
import com.vendor.rest.exception.VendorNotFoundExcdeption;
import com.vendor.rest.status.VendorEnum;
import com.vendor.rest.vo.VendorVO;

@Service
@Transactional
public class VendorServiceImpl implements VendorService{
@PersistenceContext
private EntityManager en;

@Autowired
private VendorMapper mapper;

	@Override
	public VendorVO createVendor(final VendorVO vendor) {
		final VendorEntity entity = mapper.mapToVendorEntity(vendor);
		en.persist(entity);
		vendor.setPk(entity.getId());
		return vendor;
	}
	
	@Override
		public VendorVO findVendorById(Long pk) {		
		final VendorEntity entity = en.find(VendorEntity.class, pk );
		return mapper.mapToVendorVO(entity);
	}
	
//	private VendorEntity findVendorMethod(Long pk) {
//		final VendorEntity entity = en.find(VendorEntity.class, pk);
//		if(entity == null) {
//			throw new VendorNotFoundExcdeption("Vendor is not found for this ID" + pk);
//		}
//		return entity;
//	}

	@Override
	public VendorVO updateVendor(final VendorVO vendor) {
		VendorEntity entity = en.find(VendorEntity.class, vendor.getPk());
		entity=mapper.mapToVendorEntity(entity, vendor);
		en.persist(entity);
		return vendor;
		
	}	

	@Override
	public void  activateVendor(Long pk) {
		final VendorEntity entity= en.find(VendorEntity.class, pk);
		entity.setStatus(VendorEnum.ACTIVE_VENDOR);
		en.persist(entity);
	}
	
	@Override
	public void deActivateVendor(Long pk) {	
		VendorEntity entity = en.find(VendorEntity.class, pk);
		entity.setStatus(VendorEnum.INACTIVE_VENDOR);
		en.persist(entity);
		
	}

	@Override
	public VendorEntity findVendorByCode(String vendorCode) {
		TypedQuery<VendorEntity> query= en.createQuery("select v from VendorEntity v where v.vendorCode = :vendorCode", VendorEntity.class);
		query.setParameter("vendorCode", vendorCode);
		VendorEntity result= query.getSingleResult();
//		final VendorEntity entity = en.find(VendorEntity.class, vendorCode);
		return result;

	}

	@Override
	public List<VendorVO> searchActiveVendor(Object active) {
		TypedQuery<VendorEntity> vn = en.createNamedQuery(QueryConstant.VENDOR_SEARCH_QUERY, VendorEntity.class);
		vn.setParameter("active", active);
		final List<VendorEntity> entity = vn.getResultList();
		List<VendorVO> venAct = mapper.mapToVendorVO(entity);
		return venAct;
	}

	@Override
	public List<VendorVO> searchVendor(String VendorName, String streetAddress, String addressLine2, String city,
			String state, String zipCode, String vendorPhoneNumber, String vendorFaxNumber, String vendorCode){
		VendorName = StringUtils.isEmpty(VendorName)?"%": VendorName.trim() + "%";
		streetAddress = StringUtils.isEmpty(streetAddress)?"%": streetAddress.trim() + "%";
		addressLine2 = StringUtils.isEmpty(addressLine2)?"%": addressLine2.trim() + "%";
		city = StringUtils.isEmpty(city)?"%": city.trim() + "%";
		state = StringUtils.isEmpty(state)?"%": state.trim() + "%";
		zipCode = StringUtils.isEmpty(zipCode)?"%": zipCode.trim() + "%";
		vendorPhoneNumber = StringUtils.isEmpty(vendorPhoneNumber)?"%": vendorPhoneNumber.trim() + "%";
		vendorFaxNumber = StringUtils.isEmpty(vendorFaxNumber)?"%": vendorFaxNumber.trim() + "%";
		vendorCode = StringUtils.isEmpty(vendorCode)?"%": vendorCode.trim() + "%";
		
		final TypedQuery<VendorEntity> query = en.createQuery(QueryConstant.VENDOR_SEARCH_QUERY,VendorEntity.class);
		query.setParameter("vName", VendorName);
		query.setParameter("sAddress", streetAddress);
		query.setParameter("aLine2", addressLine2);
		query.setParameter("cty", city);
		query.setParameter("st", state);
		query.setParameter("zCode", zipCode);
		query.setParameter("vPhoneNumber", vendorPhoneNumber);
		query.setParameter("vFaxNumber", vendorFaxNumber);
		query.setParameter("vCode", vendorCode);
		
		List<VendorEntity> results = query.getResultList();
		
		return mapper.mapToVendorVO(results);
		
		
	  }

	@Override
	public List<VendorVO> searchVendorByName(String VendorName) {
		TypedQuery<VendorEntity> query= en.createQuery("select v from VendorEntity v where v.vendorName = :vendorName", VendorEntity.class);
		query.setParameter("vendorName", VendorName);
		final VendorEntity result= query.getSingleResult();
		
		return (List<VendorVO>) result;
	}

	@Override
	public List<VendorVO> searchVendorByAddress(String streetAddress) {
		TypedQuery<VendorEntity> query= en.createQuery("select v from VendorEntity v where v.streetAddress = :vendorAddress", VendorEntity.class);
		query.setParameter("streetAddress", streetAddress);
		final VendorEntity result= query.getSingleResult();
		return (List<VendorVO>) result;
	}

	@Override
	public List<VendorVO> searchVendorByCity(String city) {
		TypedQuery<VendorEntity> query= en.createQuery("select v from VendorEntity v where v.city = :vendorCity", VendorEntity.class);
		query.setParameter("vendorCity", city);
		final VendorEntity result= query.getSingleResult();
		
		return (List<VendorVO>) result;
	}

	@Override
	public List<VendorVO> searchVendorByState(String state) {
		TypedQuery<VendorEntity> query= en.createQuery("select v from VendorEntity v where v.state = :vendorState", VendorEntity.class);
		query.setParameter("vendorState", state);
		final VendorEntity result= query.getSingleResult();
		return (List<VendorVO>) result;
	}
}