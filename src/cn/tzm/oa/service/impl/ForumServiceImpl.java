package cn.tzm.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tzm.oa.base.DaoSuppImpl;
import cn.tzm.oa.domain.Forum;
import cn.tzm.oa.service.ForumService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends DaoSuppImpl<Forum> implements
		ForumService {

	// 重写findAll()方法，在查询时按position的值排序
	public List<Forum> findAll() {
		return getSession().createQuery(//
				" FROM Forum f ORDER BY f.position ")//
				.list();
	}

	/**
	 * 重写save()方法，在里面设置position的值，是position的最大值+1
	 */
	public void save(Forum forum) {
		// 保存数据
		getSession().save(forum);
		// 设置position的值
		forum.setPosition(forum.getId().intValue());
	}

	public void moveUP(Long id) {
		// 1.找出要交换位子的Forum对象
		Forum forum = getById(id);
		Forum other = (Forum) getSession().createQuery(//
				" FROM Forum f WHERE f.position<? ORDER BY f.position DESC ")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)// 从结果列中的那个索引开始取数据
				.setMaxResults(1)// 最多取几条数据
				.uniqueResult();
		// 最上面的不可以上移
		if (other == null) {
			return;
		}
		// 2.交换position
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);
		// 3.保存到数据库中
		getSession().update(forum);
		getSession().update(other);

	}

	public void moveDown(Long id) {
		// 1.找出要交换位子的Forum对象
		Forum forum = getById(id);
		Forum other = (Forum) getSession().createQuery(//
				" FROM Forum f WHERE f.position>? ORDER BY f.position ASC ")//
				.setParameter(0, forum.getPosition())//
				.setFirstResult(0)// 从结果列中的那个索引开始取数据
				.setMaxResults(1)// 最多取几条数据
				.uniqueResult();
		// 最下面的不可以下移
		if (other == null) {
			return;
		}
		// 2.交换position
		int temp = forum.getPosition();
		forum.setPosition(other.getPosition());
		other.setPosition(temp);

		// 3.保存到数据库中
		getSession().update(forum);
		getSession().update(other);

	}

}
