package cn.tzm.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import cn.tzm.oa.base.BaseAction;
import cn.tzm.oa.domain.Reply;
import cn.tzm.oa.domain.Topic;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {
	
	private Long topicId;
	
	/*  发布回复页面 */
	public String addUI() throws Exception {
		//准备数据
		Topic topic= topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic); 
		
		return "addUI";
	}
	/* 发表回复 */
	public String add() throws Exception {
		//封装对象
		Reply reply=new Reply();
		
		//a、 表单中的参数
		reply.setContent(model.getContent());
		reply.setTopic(topicService.getById(topicId));
		//b、在显示层才能获取的数据
		reply.setAuthor(getCurrentUser());//当前登录的用户
		reply.setIpAddr(getRequestIP());//客服端IP
		
		replyService.save(reply);
		
		return "toShow";
	}
	
	///--------------------------------
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
}
