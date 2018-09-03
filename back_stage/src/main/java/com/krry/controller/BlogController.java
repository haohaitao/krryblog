package com.krry.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krry.entity.Blog;
import com.krry.entity.Classify;
import com.krry.service.IBlogService;

/**
 * Controller
 * controller层，作为请求转发
 * @author krry
 *
 */
@Controller  // 表示是多例模式，每个用户返回的web层是不一样的
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	/**
	 * 查询博客
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBlog")
	public HashMap<String, Object> getBlog(){
		
		List<Blog> blogList = blogService.getBlog();
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
	@ResponseBody
	@RequestMapping("/getClassify")
	public HashMap<String, Object> getClassify(){
		
		List<Classify> classifyList = blogService.getClassify();
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
	@ResponseBody
	@RequestMapping("/addBlog")
	public int addBlog(Blog blog){
		System.out.println("插入："+blog);
		int id = blogService.addBlog(blog);
		return id;
	}
	
}



