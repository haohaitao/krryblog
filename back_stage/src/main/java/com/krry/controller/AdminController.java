package com.krry.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krry.entity.Params;
import com.krry.entity.User;
import com.krry.service.IAdminService;

/**
 * Controller
 * controller层，作为请求转发
 * @author krry
 *
 */
@Controller
@RequestMapping("/krry")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	
	/**
	 * 登录
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public String login(User user){
		
		String resData = adminService.login(user);
		
		return resData;
	}
	
	
	/**
	 * 查询相关链接 / 关于我
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLinkOrAbout")
	public HashMap<String, Object> getLinkOrAbout(HttpServletRequest request){
		
		String title = request.getParameter("title");
		HashMap<String, Object> resData = adminService.getLinkOrAbout(title);
		
		return resData;
	}
	
	
	/**
	 * 获取博客详情页（编辑）
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBlogDetail/{id}")
	public HashMap<String, Object> getBlogDetail(@PathVariable("id")Integer id){
		
		HashMap<String, Object> resData = adminService.getBlogDetail(id);
		
		return resData;
	}
	
	
	/**
	 * 分页所有博客（发布和未发布）、博客总数
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBlog")
	public HashMap<String, Object> getBlog(Params params){
		
		HashMap<String, Object> resData = adminService.getBlog(params);
		
		return resData;
	}
	
	
}



