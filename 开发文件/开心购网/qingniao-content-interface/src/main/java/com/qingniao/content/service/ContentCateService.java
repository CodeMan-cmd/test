package com.qingniao.content.service;

import java.util.List;


import com.qingniao.common.pojo.EasyUITreeNode;
import com.qingniao.common.pojo.QingNiaoResult;

public interface ContentCateService {

	public List<EasyUITreeNode> getContentCatesById(long id);
	public QingNiaoResult addContentCate(Long parentId,String name);
		
}
