package com.krry.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.krry.entity.Blog;
import com.krry.entity.Params;
import com.krry.entity.User;
import com.krry.mapper.AdminMapper;
import com.krry.mapper.BlogMapper;
import com.krry.service.IAdminService;

/**
 * 实现业务层
 * 实现service层接口，数据处理对接数据库
 * @author krry
 *
 */
@Service
public class AdminService implements IAdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private BlogMapper blogMapper;
	
	
	/**
	 * 登录
	 * @return
	 */
	public String login(User user){
		
		User realUser = adminMapper.getUserByName(user);
		if (realUser != null) {
			if (realUser.getPassword().equals(user.getPassword())) {
				return "success";
			} else {
				return "密码错误哦~";
			}
		} else {
			return "用户名不存在哦~";
		}
	}

	
	/**
	 * 查询相关链接 / 关于我
	 * @return
	 */
	public HashMap<String, Object> getLinkOrAbout(String title) {
		
		Blog newBlog = new Blog();
		
		Blog blog = adminMapper.getLinkOrAbout(title);
		HashMap<String, Object> resData = new HashMap<>();
		
		if (blog != null) {
			// 设置点击量+1
			int id = blog.getId();
			int hit = blog.getHit();
			blog.setHit(++hit);
			newBlog.setHit(hit);
			newBlog.setId(id);
			
			blogMapper.updateBlog(newBlog);
			
			// 处理查询出timestamp时间类型多了个 .0  的问题
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置日期格式
			try {
				Date createData = df.parse(blog.getCreateTime());
				Date updateData = df.parse(blog.getUpdateTime());
				String createTime = df.format(createData);
				String updateTime = df.format(updateData);
				blog.setCreateTime(createTime);
				blog.setUpdateTime(updateTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resData.put("status", 200);
		} else {
			resData.put("status", 404);
		}
		resData.put("data", blog);
		
		return resData;
	}
	
	/**
	 * 获取博客详情页（编辑）
	 * @return
	 */
	public HashMap<String, Object> getBlogDetail(int id){
		
		Blog blog = adminMapper.getBlogDetail(id);
		
		HashMap<String, Object> resData = new HashMap<>();
		
		if (blog != null) {
			
			// 处理查询出timestamp时间类型多了个 .0  的问题
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 设置日期格式
			try {
				Date createData = df.parse(blog.getCreateTime());
				Date updateData = df.parse(blog.getUpdateTime());
				String createTime = df.format(createData);
				String updateTime = df.format(updateData);
				blog.setCreateTime(createTime);
				blog.setUpdateTime(updateTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resData.put("status", 200);
		} else {
			resData.put("status", 404);
		}
		resData.put("data", blog);
		
		return resData;
	}
	
	
	/**
	 * 分页所有博客（发布和未发布）、博客总数
	 * 时间戳截掉时分秒
	 * @param params
	 * @return
	 */
	public HashMap<String, Object> getBlog(Params params) {
		
		// 分页
		int pageNo = params.getPageNo();
		int pageSize = params.getPageSize();
		
		PageHelper.startPage(pageNo, pageSize);
		
		List<Blog> blogList = adminMapper.getBlog();
		int blogLen = adminMapper.getBlogCount();
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
			// TODO
		}
		// 用PageInfo对结果进行包装
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogList);
        List<Blog> pageBlog = pageInfo.getList();
		resData.put("data", pageBlog);
		resData.put("blogLen", blogLen);
		
		return resData;
	}
	
	


}



