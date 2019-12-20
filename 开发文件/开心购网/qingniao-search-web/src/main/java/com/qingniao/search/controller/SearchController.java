package com.qingniao.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qingniao.common.pojo.ItemSearch;
import com.qingniao.common.pojo.SearchResult;
import com.qingniao.search.service.SearchItemService;

@Controller
public class SearchController {
	@Autowired
	private SearchItemService searchItemService;
	
	@Value("${SEARCH_PAGE_ROWS}")
	private Integer SEARCH_PAGE_ROWS;

	@RequestMapping("/search")
	public String searchItemByCondition(String q,@RequestParam(defaultValue="1")int page,
				Model model) throws Exception{
		String strq = new String(q.getBytes("ISO-8859-1"),"utf-8");
		
		SearchResult result = searchItemService.searchItemByCondition(strq,
						page,SEARCH_PAGE_ROWS);
		model.addAttribute("query", strq);
		model.addAttribute("itemList", result.getItemList());
		model.addAttribute("page", page);
		model.addAttribute("totalPages", result.getTotalPages());
		return "search"; //逻辑视图名
	}
}
