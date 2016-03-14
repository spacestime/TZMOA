package cn.tzm.oa.service;

import cn.tzm.oa.base.DaoSupport;
import cn.tzm.oa.domain.User;

public interface UserService extends DaoSupport<User>{
	/**
	 * 验证用户名与密码，如果正确返回这个用户，否则是null 
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);
	
}
