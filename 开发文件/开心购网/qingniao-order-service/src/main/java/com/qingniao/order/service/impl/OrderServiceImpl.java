package com.qingniao.order.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.jedis.JedisClient;
import com.qingniao.mapper.TbOrderItemMapper;
import com.qingniao.mapper.TbOrderMapper;
import com.qingniao.mapper.TbOrderShippingMapper;
import com.qingniao.order.pojo.OrderInfo;
import com.qingniao.order.service.OrderService;
import com.qingniao.pojo.TbOrderItem;
import com.qingniao.pojo.TbOrderShipping;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderMapper orderMapper;
	
	@Autowired
	private TbOrderItemMapper orderItemMapper;
	
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	
	//订单的
	@Value("${ORDER_GEN_KEY}")
	private String ORDER_GEN_KEY;
	@Value("${ORDER_ID_BEGIN}")
	private String ORDER_ID_BEGIN;
	//订单明细
	@Value("${ORDER_ITEM_ID_GEN_KEY}")
	private String ORDER_ITEM_ID_GEN_KEY;
	@Value("${ORDER_ITEM_ID_BEGIN}")
	private String ORDER_ITEM_ID_BEGIN;
	
	@Autowired
	private JedisClient jedisClient;
	 
	@Override
	public QingNiaoResult createOrder(OrderInfo orderInfo) {
		
		//订单号  生成
		if(!jedisClient.exists(ORDER_GEN_KEY)){
			jedisClient.set(ORDER_GEN_KEY, ORDER_ID_BEGIN);
		}
		
		//订单号
		String orderId = jedisClient.incr(ORDER_GEN_KEY).toString();
		orderInfo.setOrderId(orderId);
		orderInfo.setPostFee("0");
		//1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
		orderInfo.setStatus(1);
		Date date = new Date();
		orderInfo.setCreateTime(date);
		orderInfo.setUpdateTime(date);
		//1、保存订单
		orderMapper.insert(orderInfo);
		 
		//2、保存订单明细
		List<TbOrderItem> items = orderInfo.getOrderItems();
		for(TbOrderItem item:items){
			
			//订单号  生成
			if(!jedisClient.exists(ORDER_ITEM_ID_GEN_KEY)){
				jedisClient.set(ORDER_ITEM_ID_GEN_KEY, ORDER_ITEM_ID_BEGIN);
			}
			String orderItemId = jedisClient.incr(ORDER_ITEM_ID_GEN_KEY).toString();
			item.setId(orderItemId);
			item.setOrderId(orderId);
			//item  
			orderItemMapper.insert(item);
		}
		
		//3、保存物流信息
		TbOrderShipping orderShip = orderInfo.getOrderShipping();
		orderShip.setOrderId(orderId);
		orderShip.setCreated(new Date());
		orderShip.setUpdated(new Date());
		orderShippingMapper.insert(orderShip);
		return QingNiaoResult.ok(orderId);
	}

}
