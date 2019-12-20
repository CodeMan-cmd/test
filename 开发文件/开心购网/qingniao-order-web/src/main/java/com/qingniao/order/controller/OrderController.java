package com.qingniao.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.utils.CookieUtils;
import com.qingniao.common.utils.JsonUtils;
import com.qingniao.order.pojo.OrderInfo;
import com.qingniao.order.service.OrderService;
import com.qingniao.pojo.TbItem;
import com.qingniao.pojo.TbOrderItem;
import com.qingniao.pojo.TbOrderShipping;
 
@Controller
public class OrderController {
	
	@Value("${TT_CART}")
	private String TT_CART;
	
	@Autowired
	private OrderService orderServiceImpl;
	

	@RequestMapping("order/order-cart")
	public String showOrder(Model model,HttpServletRequest request) {
		
		List<TbItem> items = getItemList(request);
		model.addAttribute("cartList",items );
		return "order-cart";
	}
	
	public List<TbItem> getItemList(HttpServletRequest request) {

		String str = CookieUtils.getCookieValue(request, TT_CART,true);
		if (StringUtils.isNotBlank(str)) {
			List<TbItem> items = JsonUtils.jsonToList(str, TbItem.class);
			return items;
		}
		return new ArrayList<TbItem>();
	}
	
	/*提交订单
	 * 
	 */
	
	@RequestMapping("/order/create")
	public String createOrder(OrderInfo orderInfo,Model model){
		QingNiaoResult result = orderServiceImpl.createOrder(orderInfo);
		model.addAttribute("orderId",result.getData());
		model.addAttribute("payment", orderInfo.getPayment());
		
		DateTime time = new DateTime();
		time=time.plusDays(3);
		model.addAttribute("date", time.toString("yyyy-MM-dd"));
		
		return "success";
	}
}
