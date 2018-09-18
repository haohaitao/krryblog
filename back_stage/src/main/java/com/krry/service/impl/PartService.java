package com.krry.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public HashMap<String, Object> getBlogByTag(Params params) {
		
		// 分页
		int pageNo = params.getPageNo();
		int pageSize = params.getPageSize();
		
		PageHelper.startPage(pageNo, pageSize);
				
		List<Blog> blogList = partMapper.getBlogByTag(params);
		int blogLen = partMapper.getTagBlogCount(params);
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
		// 用PageInfo对结果进行包装
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogList);
        List<Blog> pageBlog = pageInfo.getList();
		resData.put("data", pageBlog);
		resData.put("blogLen", blogLen);
		
		return resData;
	}
	
	
	/**
	 * 搜索已发布的博客
	 * 时间戳截掉时分秒
	 * @param params
	 * @return
	 */
	public HashMap<String, Object> getBlogBykeyword(Params params) {
		
		// 分页
		int pageNo = params.getPageNo();
		int pageSize = params.getPageSize();
		
		PageHelper.startPage(pageNo, pageSize);
		
		List<Blog> blogList = partMapper.getBlogBykeyword(params);
		int blogLen = partMapper.getKeyworkBlogCount(params);
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
		// 用PageInfo对结果进行包装
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogList);
        List<Blog> pageBlog = pageInfo.getList();
		resData.put("data", pageBlog);
		resData.put("blogLen", blogLen);
		
		return resData;
	}


}



