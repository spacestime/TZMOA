package cn.tzm.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tzm.oa.base.DaoSuppImpl;
import cn.tzm.oa.domain.Department;
import cn.tzm.oa.service.DepartmentService;

@Service("departmentService")
@SuppressWarnings("unchecked")
public class DepartmentServiceImpl extends DaoSuppImpl<Department> implements DepartmentService {
	
	public List<Department> findTopList() {
		return getSession().createQuery(//
				"FROM Department d where d.parent is NULL")//
				.list();
	}

	public List<Department> findChildrenByPr(Long parentId) {
		return getSession().createQuery(//
				"FROM Department d where d.parent.id=?")//
				.setParameter(0, parentId)//
				.list();
	}

}
