package cn.tzm.oa.service.impl;
import org.springframework.stereotype.Service;

import cn.tzm.oa.base.DaoSuppImpl;
import cn.tzm.oa.domain.Role;
import cn.tzm.oa.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends DaoSuppImpl<Role> implements RoleService {

}
