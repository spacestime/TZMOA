package cn.tzm.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.tzm.oa.base.BaseAction;
import cn.tzm.oa.domain.Forum;
import cn.tzm.oa.domain.PageBean;
import cn.tzm.oa.domain.Reply;
import cn.tzm.oa.domain.Topic;
import cn.tzm.oa.domain.User;
import cn.tzm.oa.utils.QueryHelper;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

	private Long forumId;

	/* 显示单个主题 */
	public String show() throws Exception {
		// 准备数据topic
		Topic topic=topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		
//		// 准备数据 replyList
//		List<Reply> replyList=replyService.findByTopic(topic);
//		ActionContext.getContext().put("replyList", replyList);
		
//		 // 准备分页的数据 v2
//		 String hql = "FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC";
//		 Object[] args = { topic };
//		 PageBean pageBean = replyService.getPageBean(pageNum, hql, args);
//		 ActionContext.getContext().getValueStack().push(pageBean);
//		
		//准备分页的数据
		 new QueryHelper(Reply.class, "r")//
		 .addWhereCondition(" r.topic=? ", topic)//
		 .addOrderByProperty(" r.postTime", true)//
		 .preparePageBean(replyService, pageNum);
		 
		return "show";
	}

	/* 发新帖页面 */
	public String addUI() throws Exception {
		// 准备数据
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);

		return "addUI";
	}

	/* 发新帖 */
	public String add() throws Exception {
		// 封装对象
		Topic topic = new Topic();
		// >> a, 表单中的参数
		topic.setTitle(model.getTitle());
		topic.setContent(model.getContent());
		topic.setForum(forumService.getById(forumId));
		// >> b, 在显示层才能获得的数据
		topic.setAuthor(getCurrentUser()); // 当前登录的用户
		topic.setIpAddr(getRequestIP()); // 客户端的IP地址

		// 调用业务方法
		topicService.save(topic);
		ActionContext.getContext().put("topicId", topic.getId());
		return "toShow";
	}

	

	// -----------
	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
}
