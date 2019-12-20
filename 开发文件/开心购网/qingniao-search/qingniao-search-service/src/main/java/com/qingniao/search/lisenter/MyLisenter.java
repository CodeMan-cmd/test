package com.qingniao.search.lisenter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import com.qingniao.common.pojo.ItemSearch;
import com.qingniao.search.mapper.ItemSearchMapper;


public class MyLisenter implements MessageListener{

	
	@Autowired
	private ItemSearchMapper itemSearchDao;
	@Autowired
	private SolrServer solrServer;
	
	
	@Override
	public void onMessage(Message message) {
		  
		TextMessage textMessage = null;
		if (message instanceof TextMessage) {
			textMessage = (TextMessage) message;
			try {
				long itemId = Long.parseLong(textMessage.getText());
				//查商品   然后放到solr
				ItemSearch itemSearch = itemSearchDao.getItemByItemId(itemId);
				
				SolrInputDocument doc = new SolrInputDocument();
				doc.addField("id", itemSearch.getId());
				doc.addField("item_title", itemSearch.getTitle());
				doc.addField("item_sell_point", itemSearch.getSell_point());
				doc.addField("item_price", itemSearch.getPrice());
				doc.addField("item_image", itemSearch.getImage());
				doc.addField("item_category_name", itemSearch.getCategory_name());
				doc.addField("item_desc", itemSearch.getItem_desc());
				
				solrServer.add(doc);
				solrServer.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
