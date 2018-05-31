package cn.tzm.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;

import cn.tzm.oa.domain.User;
import cn.tzm.oa.service.DepartmentService;
import cn.tzm.oa.service.ForumService;
import cn.tzm.oa.service.ReplyService;
import cn.tzm.oa.service.RoleService;
import cn.tzm.oa.service.TopicService;
import cn.tzm.oa.service.UserService;
import cn.tzm.oa.service.PrivilegeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	@Resource(name = "roleService")
	protected RoleService roleService;
	
	@Resource(name = "departmentService")
	protected DepartmentService departmentService;
	
	@Resource(name="userService")
	protected UserService userService;
	
	@Resource(name="privilegeService")
	protected PrivilegeService privilegeService;
	
	@Resource
	protected ForumService forumService;
	
	@Resource
	protected ReplyService replyService;
	
	@Resource
	protected TopicService topicService;
	
	protected T model;
	
	public BaseAction() {
		try {
			// 通过反射获取T的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}
	

	// ========================= 对分页的支持 =========================

	protected int pageNum = 1; // 当前页，默认为第1页

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	//============================工具方法==========================
	/**
	 * 获取客户端的id
	 * @return
	 */
	public String getRequestIP() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	/**
	 *  获取当前登录
	 * @return
	 */
	public User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
}
