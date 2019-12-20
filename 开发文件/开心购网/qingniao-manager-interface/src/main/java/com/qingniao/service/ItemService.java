package com.qingniao.service;

import com.qingniao.common.pojo.EasyUIDataGridResult;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.pojo.TbItem;
import com.qingniao.pojo.TbItemDesc;

public interface ItemService {

	
	public EasyUIDataGridResult  getItems(int page,int rows);
	public QingNiaoResult addItem(TbItem item,String desc);
	
	public TbItem getItemById(long itemId);
	public TbItemDesc getItemDescByItemId(long itemId);
	
}
