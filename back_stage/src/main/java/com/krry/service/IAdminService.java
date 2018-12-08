package com.krry.service;

import java.util.HashMap;

import com.krry.entity.Blog;
import com.krry.entity.Params;
import com.krry.entity.User;

/**
 * 业务层
 * @author w
 *
 */
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
	
	/**
	 * 获取博客详情页（编辑）
	 * @return
	 */
	public HashMap<String, Object> getBlogDetail(int id);
	
	
	/**
	 * 分页所有博客（发布和未发布）、博客总数
	 * @return
	 */
	public HashMap<String, Object> getBlog(Params parmas);

}
