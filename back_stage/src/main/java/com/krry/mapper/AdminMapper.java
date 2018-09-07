package com.krry.mapper;

import com.krry.entity.Blog;
import com.krry.entity.User;

public interface AdminMapper {
	
	/**
	 * 查询根据用户名查询
	 * @return
	 */
	public User getUserByName(User user);
	
	
	
	/**
	 * 查询相关链接 / 关于我
	 * @return
	 */
	public Blog getLinkOrAbout(String title);

}
