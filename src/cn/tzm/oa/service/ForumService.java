package cn.tzm.oa.service;

import cn.tzm.oa.base.DaoSupport;
import cn.tzm.oa.domain.Forum;

public interface ForumService extends DaoSupport<Forum> {
	/**
	 * 上移 ，最上面的不能上移
	 * @param id 当前要移动的id
	 */
	void moveUP(Long id);
	/**
	 * 下移，最下面的不能下移
	 * @param id 当前要移动的id
	 */
	void moveDown(Long id);

}
