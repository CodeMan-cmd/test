package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ItemService;

/***
 * 页面管理控制器
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

}
