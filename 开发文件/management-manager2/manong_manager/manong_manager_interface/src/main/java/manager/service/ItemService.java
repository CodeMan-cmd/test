package manager.service;

import common.pojo.EasyUIDataGridResult;
import common.pojo.QingNiaoResult;
import manager.pojo.TbItem;
import manager.pojo.TbItemDesc;

public interface ItemService {
	
	public TbItem getItem(long itemId);
	
	public EasyUIDataGridResult getItemList(int page, int rows);
	
	public QingNiaoResult addItem(TbItem item, String desc);
	
	public TbItemDesc getItemDescById(long itemId);
}
