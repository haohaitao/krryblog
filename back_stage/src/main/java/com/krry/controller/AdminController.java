package com.krry.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.krry.service.IAdminService;

/**
 * Controller
 * controller层，作为请求转发
 * @author krry
 *
 */
@Controller  // 表示是多例模式，每个用户返回的web层是不一样的
@RequestMapping("/krry")
public class AdminController {
	
	@Autowired
	private IAdminService adminService;
	
	
	/**
	 * 查询相关链接 / 关于我
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLinkOrAbout")
	public HashMap<String, Object> getBlog(@RequestParam("title") String title){
		
		HashMap<String, Object> resData = adminService.getLinkOrAbout(title);
		
		return resData;
	}
	
	
}



