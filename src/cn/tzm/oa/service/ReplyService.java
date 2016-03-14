package cn.tzm.oa.service;

import java.util.List;

import cn.tzm.oa.base.DaoSupport;
import cn.tzm.oa.domain.Reply;
import cn.tzm.oa.domain.Topic;

public interface ReplyService extends DaoSupport<Reply> {

	/**
	 * 查询指定主题的回复列表.排序：最新的回复拍到最后面
	 * @param topic
	 * @return
	 */
	List<Reply> findByTopic(Topic topic);

}
