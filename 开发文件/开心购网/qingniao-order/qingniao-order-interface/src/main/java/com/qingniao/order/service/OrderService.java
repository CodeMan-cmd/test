package com.qingniao.order.service;

import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.order.pojo.OrderInfo;

public interface OrderService {
	
	public QingNiaoResult createOrder(OrderInfo orderInfo);

}
