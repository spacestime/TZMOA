package cn.tzm.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tzm.oa.base.BaseAction;
import cn.tzm.oa.domain.Department;
import cn.tzm.oa.service.DepartmentService;
import cn.tzm.oa.utils.DepartmentUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

	private Long parentId;

	/**
	 * 列表：只显示统计部门，默认只显示顶级部门，
	 */
	public String list() throws Exception {

		List<Department> departmentList = null;
		if (parentId == null) {
			// 默认顶级部门列表
			departmentList = departmentService.findTopList();
		} else {
			// 显示指定部门列表
			departmentList = departmentService.findChildrenByPr(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {

		// 准备数据(树状结构
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(
				topList, null);
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		// 封装对象
		// 处理上级部门
		Department parent = departmentService.getById(parentId);
		model.setParent(parent);

		departmentService.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备要显示的数据
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);

		// 准备数据(树状结构
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtils.getAllDepartmentList(
				topList, department);
		ActionContext.getContext().put("departmentList", departmentList);

		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1.从数据库中获取要修改的原始对象
		Department department = departmentService.getById(model.getId());
		// 2.设置要要修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		// 处理上级部门
		Department parent = departmentService.getById(parentId);
		department.setParent(parent);
		// 3.跟新到数据库
		departmentService.update(department);
		return "toList";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
