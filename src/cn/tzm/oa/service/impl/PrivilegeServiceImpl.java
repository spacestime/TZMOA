package cn.tzm.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tzm.oa.base.DaoSuppImpl;
import cn.tzm.oa.domain.Privilege;
import cn.tzm.oa.service.PrivilegeService;
@Service("privilegeService")
@SuppressWarnings("unchecked")
public class PrivilegeServiceImpl extends DaoSuppImpl<Privilege> implements
		PrivilegeService {

	@Transactional
	public List<Privilege> findTopList() {
		
		return getSession().createQuery(//
				"FROM Privilege p WHERE p.parent IS NULL")//
				.list();
	}

	@Transactional
	public List<String> getAllPrivilegeUrls() {
		
		return getSession().createQuery(//
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL").list();
	}

	

}
