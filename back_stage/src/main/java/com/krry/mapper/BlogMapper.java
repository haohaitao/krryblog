package com.krry.mapper;

import java.util.List;

import com.krry.entity.Blog;
import com.krry.entity.Classify;

public interface BlogMapper {
	
	/**
	 * 查询所有博客
	 * @return
	 */
	public List<Blog> getBlog();
	
	/**
	 * 查询所有博客总数
	 * @return
	 */
	public int getBlogCount();
	
	/**
	 * 获取博客详情页
	 * @return
	 */
	public Blog getBlogDetail(int id);
	
	/**
	 * 查询博客的分类
	 * @return
	 */
	public List<Classify> getClassify();
	
	/**
	 * 增加博客
	 * @return
	 */
	public int addBlog(Blog blog);

}
