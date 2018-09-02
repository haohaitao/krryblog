package com.krry.mapper;

import java.util.List;

import com.krry.entity.Blog;

public interface BlogMapper {
	
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
