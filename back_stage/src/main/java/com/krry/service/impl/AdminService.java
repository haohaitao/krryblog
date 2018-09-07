package com.krry.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krry.entity.Blog;
import com.krry.entity.User;
import com.krry.mapper.AdminMapper;
import com.krry.service.IAdminService;

/**
 * 实现service层接口，数据处理对接数据库
 * @author krry
 *
 */
@Service
public class AdminService implements IAdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	
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

	
	public HashMap<String, Object> getLinkOrAbout(String title) {
		
		Blog blog = adminMapper.getLinkOrAbout(title);
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
	
	


}



