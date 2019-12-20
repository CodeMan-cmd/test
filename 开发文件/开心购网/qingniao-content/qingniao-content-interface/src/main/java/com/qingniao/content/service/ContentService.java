package com.qingniao.content.service;

import java.util.List;

import com.qingniao.common.pojo.EasyUIDataGridResult;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.pojo.TbContent;

public interface ContentService {

	public EasyUIDataGridResult getContentsByCateId(long cateId,int page,int pageSize);
	public QingNiaoResult addContent(TbContent content);
	public List<TbContent> getContentsByCateId(long cateId);
}
