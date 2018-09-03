package com.krry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krry.entity.Blog;
import com.krry.entity.Classify;
import com.krry.mapper.BlogMapper;
import com.krry.service.IBlogService;

/**
 * 实现service层接口
 * @author krry
 *
 */
@Service
public class BlogService implements IBlogService{

	@Autowired
	private BlogMapper blogMapper;
	
	
	public List<Blog> getBlog() {
		
		List<Blog> blogList = blogMapper.getBlog();
		
		return blogList;
	}

	
	public List<Classify> getClassify() {
		
		List<Classify> classifyList = blogMapper.getClassify();
		
		return classifyList;
	}
	
	
	public int addBlog(Blog blog) {
		
		int id = blogMapper.addBlog(blog);
		return id;
	}


}
