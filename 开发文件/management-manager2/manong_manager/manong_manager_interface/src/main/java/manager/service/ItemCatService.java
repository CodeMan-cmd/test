package manager.service;



import common.pojo.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {

	
	public List<EasyUITreeNode> getItemCatList(long parentId);
}
