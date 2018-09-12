package com.krry.service;

import java.util.HashMap;
import java.util.List;

import com.krry.entity.Blog;
import com.krry.entity.Classify;

/**
 * service层：处理业务逻辑（impl里面实现）
 * @author asusaad
 *
 */
public interface IBlogService {
	
	/**
	 * 分页查询博客、博客总数
	 * @return
	 */
	public HashMap<String, Object> getBlog();
	
	/**
	 * 获取博客详情页
	 * @return
	 */
	public HashMap<String, Object> getBlogDetail(int id);
	
	/**
	 * 查询博客的分类
	 * @return
	 */
	public HashMap<String, Object> getClassify();
	
	/**
	 * 获取分类博客、博客总数
	 * @return
	 */
	public HashMap<String, Object> getBlogByClassifyId(int id);
	
	/**
	 * 增加博客
	 * @return
	 */
	public int addBlog(Blog blog);
	
	/**
	 * 修改博客
	 * @param blog
	 */
	public String updateBlog(Blog blog);
	
}
