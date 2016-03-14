package cn.tzm.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tzm.oa.base.DaoSuppImpl;
import cn.tzm.oa.domain.Forum;
import cn.tzm.oa.domain.Topic;
import cn.tzm.oa.service.TopicService;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends DaoSuppImpl<Topic> implements TopicService {

	public List<Topic> findByForum(Forum forum) {
		
		return getSession().createQuery(//
				//FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC
				"FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC")//
				.setParameter(0, forum)//
				.list();
	}
	
	public void save(Topic topic) {
		//1.设置属性并保存
		topic.setType(topic.TYPE_NORMAL);// 普通帖
		topic.setReplyCount(0);//默认为0回复
		topic.setLastReply(null);//最后的回复
		topic.setPostTime(new Date());//当前时间
		topic.setLastUpdateTime(topic.getPostTime());//默认为主题的发表时间
		
		getSession().save(topic);
		
		//2.更新相关的信息
		Forum forum=topic.getForum();
		
		forum.setTopicCount(forum.getTopicCount()+1);//主题数+1
		forum.setArticleCount(forum.getArticleCount()+1);// 文章数量（主题+回复）
		forum.setLastTopic(topic);// 最后发表的主题
		
		getSession().update(forum);
		
	}
	
}
