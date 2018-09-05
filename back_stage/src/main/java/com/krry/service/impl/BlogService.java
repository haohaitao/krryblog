package com.krry.service.impl;

import java.text.ParseException;
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
	 * 分页查询博客、博客总数
	 * 时间戳截掉时分秒
	 * @param params
	 * @return
	 */
	public HashMap<String, Object> getBlog() {
		
		List<Blog> blogList = blogMapper.getBlog();
		int blogLen = blogMapper.getBlogCount();
		HashMap<String, Object> resData = new HashMap<>();
		
		int len = blogList.size();
		for (int i = 0; i < len; i++) {
			Blog curBlog = blogList.get(i);
			String createTime = curBlog.getCreateTime();
			String updateTime = curBlog.getUpdateTime();
			// 去掉 2018-09-04 13:24:05 的时分秒
			curBlog.setCreateTime(createTime.split(" ")[0]);
			curBlog.setUpdateTime(updateTime.split(" ")[0]);
		}
		
		if (blogList.size() > 0) {
			resData.put("status", 200);
		} else {
			// TODO
		}
		resData.put("data", blogList);
		resData.put("blogLen", blogLen);
		
		return resData;
	}
	
	
	/**
	 * 获取博客详情页
	 * @return
	 */
	public HashMap<String, Object> getBlogDetail(int id){
		
		Blog blog = blogMapper.getBlogDetail(id);
		HashMap<String, Object> resData = new HashMap<>();
		
		if (blog != null) {
			// 处理查询出timestamp时间类型多了个 .0  的问题
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置日期格式
			try {
				Date createData = df.parse(blog.getCreateTime());
				Date updateData = df.parse(blog.getUpdateTime());
				String createTime = df.format(createData);
				String updateTime = df.format(updateData);
				blog.setCreateTime(createTime);
				blog.setUpdateTime(updateTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(blog);
			
			resData.put("status", 200);
		} else {
			resData.put("status", 404);
		}
		resData.put("data", blog);
		
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



