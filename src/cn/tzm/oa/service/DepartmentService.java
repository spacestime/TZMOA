package cn.tzm.oa.service;

import java.util.List;

import cn.tzm.oa.base.DaoSupport;
import cn.tzm.oa.domain.Department;

public interface DepartmentService extends DaoSupport<Department>{

	/**
	 * 查询所有顶级部门的列表
	 * @return
	 */
	public List<Department> findTopList();
	/**
	 * 查询指定部门列表
	 * @param parentId
	 * @return
	 */
	public List<Department> findChildrenByPr(Long parentId);
}
