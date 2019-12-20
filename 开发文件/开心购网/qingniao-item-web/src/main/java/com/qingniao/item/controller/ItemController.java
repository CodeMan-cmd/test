package com.qingniao.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingniao.item.pojo.Item;
import com.qingniao.pojo.TbItem;
import com.qingniao.pojo.TbItemDesc;
import com.qingniao.service.ItemService;

 
@Controller
public class ItemController {
 
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	public String getItemById(@PathVariable Long itemId,Model model){
		
		TbItem tbItem = itemService.getItemById(itemId);
		TbItemDesc tbItemDesc = itemService.getItemDescByItemId(itemId);
		
		Item item = new Item(tbItem);
		item.setItemDesc(tbItemDesc);
		
		model.addAttribute("item", item);
		
		return "item";
		
	}
}
