package com.qingniao.solr.test;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrTest {

	public static void main(String[] args) throws Exception {

		SolrServer server = new HttpSolrServer("http://192.168.128.128:8080/solr");
		SolrQuery query = new SolrQuery();
		
		query.setQuery("雪茄");  
		query.set("df", "item_keywords");   
		query.setHighlight(true);
		query.addHighlightField("item_title");
		
		
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");
		
		
		
		
		
		
		
		QueryResponse response = server.query(query);
		 
		SolrDocumentList results = response.getResults();
		for(SolrDocument document:results){
			System.out.println(document.get("id"));
			System.out.println(document.get("item_title"));
			System.out.println(document.get("item_price"));
			
			
			//获取高亮的内容
			Map<String, Map<String, List<String>>> highlighting = 
						response.getHighlighting();
			
			List<String> list = highlighting.get(document.get("id")).get("item_title");
			System.out.println(list.get(0));
			
			System.out.println("=========================================");
			
			//把服务器查到的 SolrDocument 对象  的内容   封装到另一个对象   然后响应给jsp
			
			
			
			
			
		}
		
	}

	public static void test() {
		// 把内容放到搜索库去
		/*
		 * SolrInputDocument document1 = new SolrInputDocument();
		 * document1.addField("id", "300"); document1.addField("item_title",
		 * "一条雪茄"); document1.addField("item_price", "60");
		 * 
		 * server.add(document1); server.commit();
		 * 
		 * server.deleteById("100"); server.commit();
		 * 
		 * 
		 * SolrQuery query = new SolrQuery();
		 *  query.setQuery("item_title:*雪*");
		 * 
		 * QueryResponse response = server.query(query);
		 * 
		 * SolrDocumentList results = response.getResults();
		 * System.out.println(results.getNumFound()); for(SolrDocument document
		 * : results){ System.out.println(document.get("id"));
		 * System.out.println(document.get("item_title"));
		 * System.out.println(document.get("item_price"));
		 * 
		 * }
		 */

	}

}
