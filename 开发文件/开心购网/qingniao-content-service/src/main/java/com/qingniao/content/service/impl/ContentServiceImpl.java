package com.qingniao.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingniao.common.pojo.EasyUIDataGridResult;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.common.utils.JsonUtils;
import com.qingniao.content.service.ContentService;
import com.qingniao.jedis.JedisClient;
import com.qingniao.mapper.TbContentMapper;
import com.qingniao.pojo.TbContent;
import com.qingniao.pojo.TbContentExample;
import com.qingniao.pojo.TbContentExample.Criteria;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	
	@Value("${CONTENT_KEY}")
	private String CONTENT_KEY;
	
	
	
	
	@Override
	public EasyUIDataGridResult getContentsByCateId(long cateId,int page,int pageSize) {
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		PageHelper.startPage(page, pageSize);
		
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cateId);
		List<TbContent> contents = contentMapper.selectByExample(example);
		
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(contents);
		result.setRows(pageInfo.getList());
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public QingNiaoResult addContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		
		contentMapper.insert(content);
		//缓存同步
		
		jedisClient.hdel(CONTENT_KEY,content.getCategoryId()+"");
		
		return QingNiaoResult.ok();
	}

	@Override
	public List<TbContent> getContentsByCateId(long cateId) {
		 
		String str = jedisClient.hget(CONTENT_KEY,cateId+"");
		if(StringUtils.isNotBlank(str)){
			List<TbContent> lists = JsonUtils.jsonToList(str, TbContent.class);
			return lists;
		}
		
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cateId);
		List<TbContent> contents = contentMapper.selectByExample(example);
		//查出来之后  放入redis
		jedisClient.hset(CONTENT_KEY,cateId+"",JsonUtils.objectToJson(contents));
		 
		return contents;
	}

}
