package com.vendor.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendor.rest.entity.QueryConstant;
import com.vendor.rest.entity.VendorEntity;
import com.vendor.rest.status.VendorEnum;
import com.vendor.rest.vo.VendorVO;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {
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
		final VendorEntity entity = en.find(VendorEntity.class, pk);
		return mapper.mapToVendorVO(entity);
	}

	@Override
	public VendorVO updateVendor(final VendorVO vendor) {
		VendorEntity entity = en.find(VendorEntity.class, vendor.getPk());
		entity = mapper.mapToVendorEntity(entity, vendor);
		en.persist(entity);
		return vendor;

	}
	// if(vendor.getPk() <= 0) {
	// return null;
	// }
	// vendor.put(vendor.getPk(),vendor);
	// return vendor;
	// }
	//

	@Override
	public void activateVendor(Long pk) {
		final VendorEntity entity = en.find(VendorEntity.class, pk);
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
		// SELECT conc FROM Concept conc WHERE conc.conceptPK.id =:cid
		TypedQuery<VendorEntity> query = en.createQuery("select v from VendorEntity v where v.vendorCode = :vendorCode",
				VendorEntity.class);
		query.setParameter("vendorCode", vendorCode);
		VendorEntity result = query.getSingleResult();
		// final VendorEntity entity = en.find(VendorEntity.class, vendorCode);
		return result;

	}

	@Override
	public List<VendorVO> searchActiveVendor() {
		TypedQuery<VendorEntity> vn = en.createNamedQuery(QueryConstant.CUSTOMER_SEARCH_QUERY, VendorEntity.class);
		vn.setParameter("active", "active");

		final List<VendorEntity> entity = vn.getResultList();
		List<VendorVO> venAct = mapper.mapToVendorVO(entity);
		return venAct;

	}

}
