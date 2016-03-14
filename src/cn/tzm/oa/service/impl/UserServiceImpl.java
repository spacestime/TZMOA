package cn.tzm.oa.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tzm.oa.base.DaoSuppImpl;
import cn.tzm.oa.domain.User;
import cn.tzm.oa.service.UserService;


@Service("userService")
public class UserServiceImpl extends DaoSuppImpl<User> implements UserService {
	
	@Transactional
	public void save(User user) {
		//密码默认是123456
		String md5=DigestUtils.md5Hex("123456");
		user.setPassword(md5);
		getSession().save(user);
	}

	
	public User findByLoginNameAndPassword(String loginName, String password) {
		//uniqueResult()如果不唯一会报错
		return (User) getSession().createQuery("FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, DigestUtils.md5Hex(password))//
				.uniqueResult();
	}

}
