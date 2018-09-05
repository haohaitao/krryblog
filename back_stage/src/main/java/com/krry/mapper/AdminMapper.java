package com.krry.mapper;

import com.krry.entity.Blog;

public interface AdminMapper {
	
	/**
	 * 查询相关链接 / 关于我
	 * @return
	 */
	public Blog getLinkOrAbout(String title);

}
