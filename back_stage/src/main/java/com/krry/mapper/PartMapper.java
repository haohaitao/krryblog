package com.krry.mapper;

import java.util.List;

import com.krry.entity.Blog;
import com.krry.entity.Params;

public interface PartMapper {
	
	/**
	 * 根据标签查询已发布的博客
	 * @return
	 */
	public List<Blog> getBlogByTag(Params param);
	
	
	/**
	 * 根据标签查询已发布的博客的总数
	 * @return
	 */
	public int getTagBlogCount(Params param);
	
	/**
	 * 搜索已发布的博客
	 * @return
	 */
	public List<Blog> getBlogBykeyword(Params param);
	
	
	/**
	 * 搜索已发布的博客的总数
	 * @return
	 */
	public int getKeyworkBlogCount(Params param);

}
