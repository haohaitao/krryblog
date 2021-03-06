package com.krry.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.krry.entity.Blog;
import com.krry.entity.Params;
import com.krry.service.IBlogService;
import com.krry.util.UploadUtil;

/**
 * Controller
 * controller层，作为请求转发
 * @author krry
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private IBlogService blogService;
	
	
	/**
	 * 查询博客
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBlog")
	public HashMap<String, Object> getBlog(Params params){
		
		HashMap<String, Object> resData = blogService.getBlog(params);
		
		return resData;
	}
	
	
	/**
	 * 获取博客详情页
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBlogDetail/{id}")
	public HashMap<String, Object> getBlogDetail(@PathVariable("id")Integer id){
		
		HashMap<String, Object> resData = blogService.getBlogDetail(id);
		
		return resData;
	}
	
	
	/**
	 * 查询博客的分类
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getClassify")
	public HashMap<String, Object> getClassify(){
		
		HashMap<String, Object> resData = blogService.getClassify();
		
		return resData;
	}
	
	
	/**
	 * 获取分类博客、博客总数
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBlogByClassifyId/{id}")
	public HashMap<String, Object> getBlogByClassifyId(@PathVariable("id")Integer id, Params params){
		
		HashMap<String, Object> resData = blogService.getBlogByClassifyId(id, params);
		
		return resData;
	}
	
	
	/**
	 * 新增博客
	 * @param blog
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addBlog")
	public int addBlog(Blog blog){
		
		int id = blogService.addBlog(blog);
		
		return id;
	}
	
	
	/**
	 * 上传封面图片
	 * @param file
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/upload")
	public String krryupload(@RequestParam("imgFile") MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		
		// 调用工具类完成上传，返回相关数据到页面
		return UploadUtil.singleupload(file, request);
	}
	
	/**
	 * 修改博客
	 * @param blog
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateBlog")
	public String updateBlog(Blog blog){
		
		String msg = blogService.updateBlog(blog);
		
		return msg;
	}
	
	/**
	 * 博客评论数+1
	 * @param blog
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCommonBlog")
	public String updateCommonBlog(Blog blog){
		
		String msg = blogService.updateCommonBlog(blog);
		
		return msg;
	}
	
}



