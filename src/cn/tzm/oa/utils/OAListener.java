package cn.tzm.oa.utils;

import java.util.List;

import javax.annotation.PostConstruct;
//import javax.ejb.PostActivate;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;

import cn.tzm.oa.domain.Privilege;
import cn.tzm.oa.domain.User;
import cn.tzm.oa.service.PrivilegeService;
import cn.tzm.oa.service.UserService;

@Component
public class OAListener implements ServletContextListener {

	private Log log=LogFactory.getLog(OAListener.class);
	
	
	//初始化
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext application = sce.getServletContext();

		// 从Spring的容器中取出PrivilegeService的对象实例.
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application); // 获取Spring的监听器中创建的Spring容器对象
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeService");
		// 1，查询所有顶级的权限列表并放到application作用域中
		List<Privilege> topPrivilegeList = privilegeService.findTopList();
		//ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
		application.setAttribute("topPrivilegeList", topPrivilegeList);
		log.info("====== topPrivilegeList已经放到application作用域中了！ ======");
	
		//2.查询出所有的权限的URL集合放到application作用域中
		List<String> allPrivilegeUrls=privilegeService.getAllPrivilegeUrls();
		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
	
	}

	//销毁
	public void contextDestroyed(ServletContextEvent arg0) {
	
		
	}

	
	
}
