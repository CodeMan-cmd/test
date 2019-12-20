package com.qingniao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingniao.common.pojo.EasyUIDataGridResult;
import com.qingniao.common.pojo.EasyUITreeNode;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.content.service.ContentCateService;
import com.qingniao.content.service.ContentService;
import com.qingniao.pojo.TbContent;

@Controller
public class ContentController {

	@Autowired
	private ContentCateService contentCatesServiceImpl;
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatesById(@RequestParam(defaultValue="0",value="id")long id){
		List<EasyUITreeNode> nodes = contentCatesServiceImpl.getContentCatesById(id);
		return nodes;
	}
	
	@RequestMapping("/content/category/create")
	@ResponseBody
	public QingNiaoResult addContentCate(Long parentId,String name){
		return contentCatesServiceImpl.addContentCate(parentId, name);
	}
	
	/*
	 * 查询某个内容分类的  的内容列表
	 */
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult addContentCate(Long categoryId,@RequestParam(defaultValue="0")int page ,int rows){
		return contentService.getContentsByCateId(categoryId, page, rows);
	}
	
	/*
	 * 新增内容
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public QingNiaoResult addContent(TbContent content){
		return contentService.addContent(content);
	}
}
