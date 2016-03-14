package cn.tzm.oa.service;

import java.util.List;

import cn.tzm.oa.base.DaoSupport;
import cn.tzm.oa.domain.Forum;
import cn.tzm.oa.domain.Topic;

public interface TopicService extends DaoSupport<Topic> {
	/**
	 * 查询指定板块中的主题列表，排序:最新在最前面，置顶帖在上面
	 * @param forum
	 * @return
	 */
	List<Topic> findByForum(Forum forum);

}
