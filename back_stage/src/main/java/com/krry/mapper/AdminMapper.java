package com.krry.mapper;

import java.util.List;

import com.krry.entity.Blog;
import com.krry.entity.User;

/**
 * 持久层
 * @author w
 *
 */
public interface AdminMapper {
	
	/**
	 * 查询根据用户名查询
	 * @return
	 */
	public User getUserByName(User user);
	
	/**
	 * 查询相关链接 / 关于我
	 * @return
	 */
	public Blog getLinkOrAbout(String title);
	
	/**
	 * 获取博客详情页（编辑）
	 * @return
	 */
	public Blog getBlogDetail(int id);
	
	
	/**
	 * 分页所有博客（发布和未发布）
	 * @return
	 */
	public List<Blog> getBlog();
	
	/**
	 * 博客总数
	 * @return
	 */
	public int getBlogCount();

}



