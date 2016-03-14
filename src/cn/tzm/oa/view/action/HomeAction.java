package cn.tzm.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tzm.oa.base.BaseAction;
import cn.tzm.oa.domain.Privilege;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HomeAction extends BaseAction<Privilege> {

	
	
	public String index() throws Exception {
		
		return "index";
	}
	
	public String top() throws Exception {
		// TODO Auto-generated method stub
		return "top";
	}
	public String bottom() throws Exception {
		// TODO Auto-generated method stub
		return "bottom";
	}
	public String left() throws Exception {
	
		return "left";
	}
	
	public String right() throws Exception {
		// TODO Auto-generated method stub
		return "right";
	}
	
}
