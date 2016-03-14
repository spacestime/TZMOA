package cn.tzm.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.tzm.oa.base.BaseAction;
import cn.tzm.oa.domain.User;

@Controller
@Scope("prototype")
public class LoginoutAction extends BaseAction<User> {

	/**
	 * 登录页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String loginUI() throws Exception {

		return "loginUI";
	}

	/**
	 * 登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {

		//验证用户名与密码
		User user = userService.findByLoginNameAndPassword(model.getLoginName(),
				model.getPassword());
		if (user == null) {
			//如果登录名或密码不正确，就转回到登录页面并提示密码或用户名错误
			addFieldError("login", "密码或用户名错误!!");
			
			return "loginUI";
			
		} else {
			ActionContext.getContext().getSession().put("user", user);
			return "toHome";
		}
		
	}

	/**
	 * 注销
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
}
