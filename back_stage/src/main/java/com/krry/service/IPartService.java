package com.krry.service;

import java.util.HashMap;

import com.krry.entity.Params;

/**
 * 业务层
 * @author asusaad
 *
 */
public interface IPartService {
	
	/**
	 * 根据标签查询已发布的博客
	 * @return
	 */
	public HashMap<String, Object> getBlogByTag(Params param);
	
	/**
	 * 搜索已发布的博客
	 * @return
	 */
	public HashMap<String, Object> getBlogBykeyword(Params param);
	
	
}
