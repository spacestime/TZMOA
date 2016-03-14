package cn.tzm.oa.base;

import java.util.List;

import cn.tzm.oa.domain.PageBean;
import cn.tzm.oa.domain.User;
import cn.tzm.oa.utils.QueryHelper;

public interface DaoSupport<T> {
	/**
	 * 添加实体
	 * @param user
	 */
	public void save(T user);
	/**
	 * 删除实体
	 * @param id
	 */
	public void delete(Long id);
	/**
	 * 更新实体
	 * @param user
	 */
	public void update(T user);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T getById(Long id);
	/**
	 * 根据id[]查询
	 * @param id
	 * @return
	 */
	public List<T> getByIds(Long[] ids);
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param hql
	 *            查询数据列表的hql语句，在方法内部会自动生成查询总数量的hql语句
	 * @param args
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum, String hql, Object[] args);

	/**
	 * 公共的查询分页信息的方法（最终版）
	 * 
	 * @param pageNum
	 * @param queryHelper
	 *            查询语句 + 参数列表
	 * @return
	 */
	PageBean getPageBean(int pageNum, QueryHelper queryHelper);
}
