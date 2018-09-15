package com.krry.mapper;

import java.util.List;

import com.krry.entity.Blog;
import com.krry.entity.Classify;

/**
 * 持久层
 * @author w
 *
 */
public interface BlogMapper {
	
	/**
	 * 查询已发布的博客
	 * @return
	 */
	public List<Blog> getBlog();
	
	/**
	 * 查询已发布的博客总数
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
	 * 查询已发布的分类博客
	 * @return
	 */
	public List<Blog> getBlogByClassifyId(int id);
	
	/**
	 * 查询已发布的分类博客总数
	 * @return
	 */
	public int getBlogClassifyCount(int id);
	
	/**
	 * 查询分类博客的名称
	 * @return
	 */
	public String getBlogClassifyName(int id);
	
	/**
	 * 增加博客
	 * @return
	 */
	public void addBlog(Blog blog);
	
	/**
	 * 修改博客
	 * @param blog
	 */
	public void updateBlog(Blog blog);

}
