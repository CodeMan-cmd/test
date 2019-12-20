package com.qingniao.search.service;

import java.util.List;

import com.qingniao.common.pojo.ItemSearch;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.pojo.SearchResult;

public interface SearchItemService {
	
	public QingNiaoResult  importItem();

	public SearchResult searchItemByCondition(String q,int page,int pageSize) throws Exception;
}
