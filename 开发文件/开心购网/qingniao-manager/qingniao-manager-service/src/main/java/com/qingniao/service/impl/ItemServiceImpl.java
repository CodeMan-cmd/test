package com.qingniao.service.impl;

import java.util.Date;
import java.util.List;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingniao.common.pojo.EasyUIDataGridResult;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.utils.IDUtils;
import com.qingniao.common.utils.JsonUtils;
import com.qingniao.jedis.JedisClient;
import com.qingniao.mapper.TbItemDescMapper;
import com.qingniao.mapper.TbItemMapper;
import com.qingniao.pojo.TbItem;
import com.qingniao.pojo.TbItemDesc;
import com.qingniao.pojo.TbItemExample;
import com.qingniao.pojo.TbItemExample.Criteria;
import com.qingniao.service.ItemService;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${ITEM_INFO_PRE}")
	private String ITEM_INFO_PRE;
	
	@Value("${ITEM_EXPIRE_TIME}")
	private int ITEM_EXPIRE_TIME;
	
	 
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	
	@Autowired
	private JmsTemplate session;
	@Autowired
	private Destination destination;
	
	
	@Override
	public EasyUIDataGridResult getItems(int page, int rows) {
		EasyUIDataGridResult result  = new EasyUIDataGridResult();
		//分页
		PageHelper.startPage(page, rows);
		
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		
		List<TbItem> items = itemMapper.selectByExample(example);
		 
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(items);
		
		result.setRows(pageInfo.getList());///  第一页  30条记录
		result.setTotal(pageInfo.getTotal());
		return result;
	}


	@Override
	public QingNiaoResult addItem(TbItem item,   String desc) {
		
		final long id = IDUtils.genItemId();
		item.setId(id);
		item.setStatus((byte)1); 
		item.setUpdated(new Date());
		item.setCreated(new Date());
		itemMapper.insert(item);
		
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(id);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDesc.setItemDesc(desc);
		itemDescMapper.insert(itemDesc);
		
		//把新增的商品 放到消息队列去
		session.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				TextMessage textMessage = arg0.createTextMessage(id+"");
				return textMessage;
			}
		});
		return QingNiaoResult.ok();
	}


	@Override
	public TbItem getItemById(long itemId) {
		
		String str = jedisClient.get(ITEM_INFO_PRE+itemId+":BASE");
		if(StringUtils.isNotBlank(str)){ 
			TbItem item = JsonUtils.jsonToPojo(str, TbItem.class);
			return item;
		} 
		
		TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		jedisClient.set(ITEM_INFO_PRE+itemId+":BASE", JsonUtils.objectToJson(tbItem));
		jedisClient.expire(ITEM_INFO_PRE+itemId+":BASE", ITEM_EXPIRE_TIME);
 
		return tbItem;
	}
	 

	@Override
	public TbItemDesc getItemDescByItemId(long itemId) {
		
		String str = jedisClient.get(ITEM_INFO_PRE+itemId+":DESC");
		if(StringUtils.isNotBlank(str)){ 
			TbItemDesc itemDesc = JsonUtils.jsonToPojo(str, TbItemDesc.class);
			return itemDesc;
		} 
		
		TbItemDesc tbItemDesc= itemDescMapper.selectByPrimaryKey(itemId);
		jedisClient.set(ITEM_INFO_PRE+itemId+":DESC", JsonUtils.objectToJson(tbItemDesc));
		jedisClient.expire(ITEM_INFO_PRE+itemId+":DESC", ITEM_EXPIRE_TIME);
		
		return tbItemDesc;
	}

}
