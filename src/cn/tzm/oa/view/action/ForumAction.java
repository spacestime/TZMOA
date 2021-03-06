package cn.tzm.oa.view.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.tzm.oa.base.BaseAction;
import cn.tzm.oa.domain.Forum;
import cn.tzm.oa.domain.PageBean;
import cn.tzm.oa.domain.Topic;
import cn.tzm.oa.utils.QueryHelper;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	/**
	 * "0">全部主题< 
	 * "1">全部精华贴
	 */
	private int viewType;

	/**
	 * "0">默认排序（按最后更新时间排序，但所有置顶帖都在前面）</option>
	 * "1">按最后更新时间排序</option>
	 * "2">按主题发表时间排序</option> 
	 * "3">按回复数量排序</option>
	 */
	private int orderBy;

	/**
	 * value="true">降序</
	 * value="false">升序<
	 */
	private boolean asc;

	/* 板块列表 */
	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}

	/* 显示单个板块 */
	public String show() throws Exception {
		// 准备数据:Forum
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);

		// //准备数据:topicList
		// List<Topic> topicList=topicService.findByForum(forum);
		// ActionContext.getContext().put("topicList", topicList);

		// 准备分页的数据 v2 使用公共的分页方法
//		String hql = "FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
//		Object[] args = { forum };
//		PageBean pageBean = topicService.getPageBean(pageNum, hql, args);
//		ActionContext.getContext().getValueStack().push(pageBean); // 放到栈顶
		
//		//准备分页的数据 v3 带过滤条件与排序条件的
//		List<Object> argsList=new ArrayList<Object>();
//		String hql = "FROM Topic t WHERE t.forum=? ";
//		argsList.add(forum);
//		if(viewType==1){//1表示只看精华帖
//			hql+="AND t.type=? ";
//			argsList.add(Topic.TYPE_BEST);
//		}
//		/**
//		 * "0">默认排序（按最后更新时间排序，但所有置顶帖都在前面）</option>
//		 * "1">按最后更新时间排序</option>
//		 * "2">按主题发表时间排序</option> 
//		 * "3">按回复数量排序</option>
//		 */
//		if(orderBy==1){
//			hql+=" ORDER BY t.lastUpdateTime " +(asc ? "ASC" : "DESC");
//		}else if (orderBy==2) {
//			hql+=" ORDER BY t.postTime "+(asc ? "ASC" : "DESC");
//		}else if (orderBy==3) {
//			hql+=" ORDER BY t.replyCount "+(asc ? "ASC" : "DESC");
//		}else  {
//			hql+=" ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
//		}
//		Object[] args =argsList.toArray();
//		PageBean pageBean = topicService.getPageBean(pageNum, hql, args);
//		ActionContext.getContext().getValueStack().push(pageBean); // 放到栈顶
//		
		// 准备分页的数据 v4 （最终版）-- 使用QueryHelper
		new QueryHelper(Topic.class, "t")//
				.addWhereCondition("t.forum=?", forum)//
				.addWhereCondition((viewType == 1), "t.type=?", Topic.TYPE_BEST) // 1 表示只看精华帖
				.addOrderByProperty((orderBy == 1), "t.lastUpdateTime", asc) // 1 表示只按最后更新时间排序
				.addOrderByProperty((orderBy == 2), "t.postTime", asc) // 表示只按主题发表时间排序
				.addOrderByProperty((orderBy == 3), "t.replyCount", asc) // 表示只按回复数量排序
				.addOrderByProperty((orderBy == 0), "(CASE t.type WHEN 2 THEN 2 ELSE 0 END)", false)//
				.addOrderByProperty((orderBy == 0), "t.lastUpdateTime", false) // 0 表示默认排序(所有置顶帖在前面，并按最后更新时间降序排列)
				.preparePageBean(topicService, pageNum);
		
		return "show";
	}

	// ----------------------------
	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}
}
