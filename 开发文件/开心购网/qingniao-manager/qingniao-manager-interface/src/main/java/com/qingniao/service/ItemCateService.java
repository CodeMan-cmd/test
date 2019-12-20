package com.qingniao.service;

import java.util.List;

import com.qingniao.common.pojo.EasyUITreeNode;
import com.qingniao.pojo.TbItemCat;

public interface ItemCateService {

	public List<EasyUITreeNode> getItemCateByParentId(long id);
}
