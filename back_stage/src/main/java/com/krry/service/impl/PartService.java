package com.krry.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krry.entity.Blog;
import com.krry.entity.Params;
import com.krry.mapper.BlogMapper;
import com.krry.mapper.PartMapper;
import com.krry.service.IPartService;

/**
 * 实现业务层
 * 实现service层接口，数据处理对接数据库
 * @author krry
 *
 */
@Service
public class PartService implements IPartService{

	@Autowired
	private PartMapper partMapper;
	
	/**
	 * 根据标签查询已发布的博客
	 * 时间戳截掉时分秒
	 * @param params
	 * @return
	 */
	public HashMap<String, Object> getBlogByTag(Params param) {

		List<Blog> blogList = partMapper.getBlogByTag(param);
		int blogLen = partMapper.getTagBlogCount(param);
		HashMap<String, Object> resData = new HashMap<>();
		
		int len = blogList.size();
		
		if (len > 0) {
			for (int i = 0; i < len; i++) {
				Blog curBlog = blogList.get(i);
				String createTime = curBlog.getCreateTime();
				String updateTime = curBlog.getUpdateTime();
				// 去掉 2018-09-04 13:24:05 的时分秒
				curBlog.setCreateTime(createTime.split(" ")[0]);
				curBlog.setUpdateTime(updateTime.split(" ")[0]);
			}
			resData.put("status", 200);
		} else {
			// 没有相关标签，不存在
			resData.put("status", 404);
		}
		resData.put("data", blogList);
		resData.put("blogLen", blogLen);
		
		return resData;
	}
	
	
	/**
	 * 搜索已发布的博客
	 * 时间戳截掉时分秒
	 * @param params
	 * @return
	 */
	public HashMap<String, Object> getBlogBykeyword(Params param) {

		List<Blog> blogList = partMapper.getBlogBykeyword(param);
		int blogLen = partMapper.getKeyworkBlogCount(param);
		HashMap<String, Object> resData = new HashMap<>();
		
		int len = blogList.size();
		
		if (len > 0) {
			for (int i = 0; i < len; i++) {
				Blog curBlog = blogList.get(i);
				String createTime = curBlog.getCreateTime();
				String updateTime = curBlog.getUpdateTime();
				// 去掉 2018-09-04 13:24:05 的时分秒
				curBlog.setCreateTime(createTime.split(" ")[0]);
				curBlog.setUpdateTime(updateTime.split(" ")[0]);
			}
			resData.put("status", 200);
		} else {
			// 查询无果
			resData.put("status", 406);
		}
		resData.put("data", blogList);
		resData.put("blogLen", blogLen);
		
		return resData;
	}


}



