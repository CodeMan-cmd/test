package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ItemService;

/***
 * ҳ����������
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

}
