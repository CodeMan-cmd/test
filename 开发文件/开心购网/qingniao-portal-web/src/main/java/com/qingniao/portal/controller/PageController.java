package com.qingniao.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingniao.common.utils.JsonUtils;
import com.qingniao.content.service.ContentService;
import com.qingniao.pojo.TbContent;
import com.qingniao.portal.pojo.Ad1Node;

@Controller
public class PageController {
	
	
	@Autowired
	private ContentService contentServiceImpl;
	
	@Value("${AD1_CATEGORY_ID}")
	private int AD1_CATEGORY_ID;
	
	@Value("${AD1_WIDTH}")
	private String AD1_WIDTH;
	@Value("${AD1_WIDTH_B}")
	private String AD1_WIDTH_B;
	@Value("${AD1_HEIGHT}")
	private String AD1_HEIGHT;
	@Value("${AD1_HEIGHT_B}")
	private String AD1_HEIGHT_B;
	
	@RequestMapping("/index")
	public String showIndex(Model model){
		List<Ad1Node> nodes = new ArrayList<Ad1Node>();
		List<TbContent> lists = getContentByCateId();
		for(TbContent content : lists){
			Ad1Node node = new Ad1Node();
			node.setSrc(content.getPic());
			node.setSrcB(content.getPic2());
			node.setHref(content.getUrl());
			
			node.setHeight(AD1_HEIGHT);
			node.setHeightB(AD1_HEIGHT_B);
			node.setWidth(AD1_WIDTH);
			node.setWidthB(AD1_WIDTH_B);
			nodes.add(node);
		}
		
		model.addAttribute("ad1",JsonUtils.objectToJson(nodes));
		return "index";
	}
	
	public List<TbContent> getContentByCateId(){
		List<TbContent> lists = contentServiceImpl.getContentsByCateId(AD1_CATEGORY_ID);
		return lists;
	}
}
