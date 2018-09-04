package com.krry.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krry.entity.Blog;
import com.krry.entity.Classify;
import com.krry.mapper.BlogMapper;
import com.krry.service.IBlogService;

/**
 * 实现service层接口，数据处理对接数据库
 * @author krry
 *
 */
@Service
public class BlogService implements IBlogService{

	@Autowired
	private BlogMapper blogMapper;
	
	/**
	 * 查询博客
	 * @param params
	 * @return
	 */
	public HashMap<String, Object> getBlog() {
		
		List<Blog> blogList = blogMapper.getBlog();
		HashMap<String, Object> resData = new HashMap<>();
		
		if (blogList.size() > 0) {
			resData.put("status", 200);
		} else {
			// TODO
		}
		resData.put("data", blogList);
		
		return resData;
	}

	
	/**
	 * 查询博客的分类
	 * @param params
	 * @return
	 */
	public HashMap<String, Object> getClassify() {
		
		List<Classify> classifyList = blogMapper.getClassify();
		HashMap<String, Object> resData = new HashMap<>();
		
		if (classifyList.size() > 0) {
			resData.put("status", 200);
		} else {
			// TODO
		}
		resData.put("data", classifyList);
		
		return resData;
	}
	
	
	/**
	 * 新增博客
	 * @param blog
	 * @return
	 */
	public int addBlog(Blog blog) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置日期格式
		String date = df.format(new Date()); // new Date()为获取当前系统时间，也可使用当前时间戳
		blog.setHit(0);
		blog.setComment(0);
		blog.setCreateTime(date);
		blog.setUpdateTime(date);
		
		int id = blogMapper.addBlog(blog);
		
		return id;
	}


}



