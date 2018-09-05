package com.krry.service;

import java.util.HashMap;

import com.krry.entity.Blog;

public interface IAdminService {

	/**
	 * 查询相关链接 / 关于我
	 * @return
	 */
	public HashMap<String, Object> getLinkOrAbout(String title);

}
