package com.krry.service;

import java.util.HashMap;

import com.krry.entity.Blog;
import com.krry.entity.User;

public interface IAdminService {

	/**
	 * 登录
	 * @return
	 */
	public String login(User user);
	
	
	/**
	 * 查询相关链接 / 关于我
	 * @return
	 */
	public HashMap<String, Object> getLinkOrAbout(String title);

}
