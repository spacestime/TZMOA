package cn.tzm.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tzm.oa.base.DaoSuppImpl;
import cn.tzm.oa.domain.Forum;
import cn.tzm.oa.domain.Reply;
import cn.tzm.oa.domain.Topic;
import cn.tzm.oa.service.ReplyService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ReplyServiceImpl extends DaoSuppImpl<Reply> implements
		ReplyService {

	public List<Reply> findByTopic(Topic topic) {
		
		return getSession().createQuery(//
				//查询指定主题的回复列表.排序：最新的回复拍到最后面
				"FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC")//
				.setParameter(0, topic)//
				.list();
	}
	
	
	public void save(Reply reply) {
		 //1.设置属性并保存
		reply.setDeleted(false);//默认未删除状态
		reply.setPostTime(new Date());//当前时间
		getSession().save(reply);
		
		//2.更新相关的信息
		Topic topic=reply.getTopic();
		Forum forum=topic.getForum();
		
		forum.setArticleCount(forum.getArticleCount()+1);//板块的文章数量（主题+回复）
		topic.setReplyCount(topic.getReplyCount()+1);//主题的回复数量 
		topic.setLastReply(reply);//主题的最后发表的回复
		topic.setLastUpdateTime(reply.getPostTime());//主题的最后更新时间（主题的发表时间或最后回复时间）
		
		getSession().update(topic);
		getSession().update(forum);
		
	}
	

}
