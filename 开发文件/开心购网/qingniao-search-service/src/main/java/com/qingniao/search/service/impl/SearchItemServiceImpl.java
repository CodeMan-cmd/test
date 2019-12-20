package com.qingniao.search.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qingniao.common.pojo.ItemSearch;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.pojo.SearchResult;
import com.qingniao.search.mapper.ItemSearchMapper;
import com.qingniao.search.service.SearchItemService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SearchItemServiceImpl implements SearchItemService {

	@Autowired
	private SolrServer solrServer;

	@Autowired
	private ItemSearchMapper itemSearchMapper;

	@Override
	public QingNiaoResult importItem() {
		List<SolrInputDocument> documents = new ArrayList<SolrInputDocument>();
		try {

			List<ItemSearch> lists = itemSearchMapper.getItemSearch();
			for (ItemSearch item : lists) {
				SolrInputDocument doc = new SolrInputDocument();
				
				doc.addField("id", item.getId());
				doc.addField("item_title", item.getTitle());
				doc.addField("item_sell_point", item.getSell_point());
				doc.addField("item_price", item.getPrice());
				doc.addField("item_image", item.getImage());
				doc.addField("item_category_name", item.getCategory_name());
				doc.addField("item_desc", item.getItem_desc());
				
				documents.add(doc);
			}
			solrServer.add(documents);
			solrServer.commit();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return QingNiaoResult.ok();
	}

	@Override
	public SearchResult searchItemByCondition(String q,int page,int pageSize) throws Exception{
		
		SearchResult searchResult = new SearchResult();
		
		List<ItemSearch> lists = new ArrayList<ItemSearch>();
		//去索引库搜索
		SolrQuery query = new SolrQuery();
		query.setQuery(q);
		query.set("df", "item_title");   
		
		//设置分页
		query.setStart((page-1)*pageSize);
		query.setRows(pageSize);
		
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");
		
		QueryResponse response = solrServer.query(query);
		SolrDocumentList results = response.getResults();
		
		for(SolrDocument document: results){
			
			ItemSearch item = new ItemSearch();
			item.setId((String) document.get("id"));
			item.setCategory_name((String) document.get("item_category_name"));
			item.setImage((String) document.get("item_image"));
			item.setPrice((long) document.get("item_price"));
			item.setSell_point((String) document.get("item_sell_point"));
			
			Map<String, Map<String, List<String>>> map = response.getHighlighting();
			List<String> temp = map.get(document.get("id")).get("item_title");
			if(temp != null && temp.size()>0){
				item.setTitle(temp.get(0));
			}else{
				item.setTitle((String)document.get("item_title"));
			}
			lists.add(item);
		}
		
		searchResult.setItemList(lists);
		//总记录数
		int count = (int)results.getNumFound();
		searchResult.setRecordCount(count);
		searchResult.setTotalPages(count%pageSize==0?(count/pageSize):(count/pageSize+1));
		return searchResult;
	}

}
