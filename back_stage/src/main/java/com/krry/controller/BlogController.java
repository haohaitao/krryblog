package com.krry.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.krry.entity.Blog;
import com.krry.service.IBlogService;

/**
 * Controller
 * controller层，作为请求转发
 * @author krry
 *
 */
@Controller  // 表示是多例模式，每个用户返回的web层是不一样的
@RequestMapping("/index")
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	/**
	 * ajax请求查询
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/index")
	public List<Blog> getBlog(){
		
		List<Blog> blog = blogService.getBlog();
		System.out.println(blog);
		return blog;
	}
	
}



