package com.krry.service;

import java.util.List;
import com.krry.entity.Blog;

/**
 * service层：处理业务逻辑（impl里面实现）
 * @author asusaad
 *
 */
public interface IBlogService {
	
	/**
	 * 查询所有博客
	 * @return
	 */
	public List<Blog> getBlog();
	
	/**
	 * 增加博客
	 * @return
	 */
	public int addBlog(Blog blog);
	
}
