package cn.tzm.oa.test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import cn.tzm.oa.domain.Department;
import cn.tzm.oa.domain.Role;
import cn.tzm.oa.domain.User;
import cn.tzm.oa.service.DepartmentService;
import cn.tzm.oa.service.RoleService;
import cn.tzm.oa.utils.SpringInit;
import cn.tzm.oa.view.action.DepartmentAction;

public class TestSpging extends SpringInit{
	
	
	
	@Test
	public void testSessionFactory() throws Exception
	{
		SessionFactory sf= (SessionFactory) context.getBean("sessionFactory");
		System.out.println(sf.openSession());
	}
	
	
//	@Test
//	public void testAction()
//	{
//		RoleService roleService= (RoleService) context.getBean("roleService");
//		System.out.println(roleService);
//		List<Role> role= roleService.findAll();
//		System.out.println(role.size());
//	}
	
	@Test
	public void testAddRole() throws Exception
	{
		Role user=new Role();
		user.setName("tzm");
		RoleService roleService= (RoleService) context.getBean("roleService");
		System.out.println(roleService);
		roleService.save(user);
		
	}
	
	@Test
	public void testAddDepartment() throws Exception
	{
		//Department department=new Department();
		//department.setName("dddddd");
		//DepartmentAction d=new DepartmentAction();
		
		DepartmentService roleService= (DepartmentService) context.getBean("departmentService");
		roleService.delete(1L);
		//System.out.println(roleService);
		//roleService.save(department);
		
	}
}
