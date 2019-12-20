package com.qingniao.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.utils.CookieUtils;
import com.qingniao.common.utils.JsonUtils;
import com.qingniao.pojo.TbItem;
import com.qingniao.service.ItemService;

@Controller
public class CartController {
	
	@Autowired
	private ItemService itemServiceImpl;

	@Value("${TT_CART}")
	private String TT_CART;
	
	@Value("${CART_EXPIRE}")
	private int CART_EXPIRE;

	@RequestMapping("/add/cart/{itemId}")
	public String addCart(@PathVariable Long itemId, int num,
			HttpServletRequest request,HttpServletResponse response) {
 
		// 思路 ？？ 根据itemId去查询 是否有该商品 如果有 数量相加 否则 新增到购物车 cookie
		List<TbItem> items = getItemList(request);
		boolean flag = false;
		for(TbItem item : items){
			//如果有  直接改数量
			if(itemId.longValue() == item.getId()){
				item.setNum(item.getNum()+num);
				flag = true;
				break;
			}
		}
		if(!flag){
			//这个商品   添加到cookie中  先要根据itemId把商品查出来
			TbItem item = itemServiceImpl.getItemById(itemId);
			String strImage = item.getImage();
			if(StringUtils.isNotBlank(strImage)){
				String[] strs = strImage.split(",");
				item.setImage(strs[0]);
			}
			item.setNum(num); 
			items.add(item);
		}
		CookieUtils.setCookie(request, response, TT_CART, 
					JsonUtils.objectToJson(items),CART_EXPIRE,true);
		return "cartSuccess";
	}

	public List<TbItem> getItemList(HttpServletRequest request) {

		String str = CookieUtils.getCookieValue(request, TT_CART,true);
		if (StringUtils.isNotBlank(str)) {
			List<TbItem> items = JsonUtils.jsonToList(str, TbItem.class);
			return items;
		}
		return new ArrayList<TbItem>();

	}
	
	/*
	 * 去购物车结算模块
	 */
	
	@RequestMapping("/cart/cart")
	public String showCartList(HttpServletRequest request,Model model){
		List<TbItem> lists = getItemList(request);
		model.addAttribute("cartList", lists);
		return "cart";
	}
	
	/*
	 * 购物车数量的修改模块
	 */
	
	@RequestMapping("/cart/update/num/{itemId}/{itemNum}")
	@ResponseBody
	public QingNiaoResult updateCartNum(@PathVariable Long itemId,@PathVariable Integer itemNum,
			HttpServletRequest request,HttpServletResponse response){
		List<TbItem> lists = getItemList(request);
		for(TbItem item : lists){
			if(itemId.longValue() == item.getId()){
				item.setNum(itemNum);
				break;
			}
		}
		CookieUtils.setCookie(request, response, TT_CART, JsonUtils.objectToJson(lists),CART_EXPIRE,true);
		return QingNiaoResult.ok();
	}
	
	/*
	 * 购物车数量的删除模块
	 */
	@RequestMapping("/cart/delete/{itemId}")
	public String deleteItemByItemId(@PathVariable Long itemId,
			HttpServletRequest request,HttpServletResponse response){
		List<TbItem> lists = getItemList(request);
		for(TbItem item : lists){
			if(itemId.longValue() == item.getId()){
				lists.remove(item);
				break;
			}
		}
		CookieUtils.setCookie(request, response, TT_CART, JsonUtils.objectToJson(lists),CART_EXPIRE,true);
		return "redirect:/cart/cart.html";
	}
}
