package com.qingniao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qingniao.common.pojo.EasyUITreeNode;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.content.service.ContentCateService;
import com.qingniao.mapper.TbContentCategoryMapper;
import com.qingniao.pojo.TbContentCategory;
import com.qingniao.pojo.TbContentCategoryExample;
import com.qingniao.pojo.TbContentCategoryExample.Criteria;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ContentCateServiceImpl implements ContentCateService{

	@Autowired
	private TbContentCategoryMapper contentCateMapper;
	
	@Override
	public List<EasyUITreeNode> getContentCatesById(long id) {
		List<EasyUITreeNode> nodes = new ArrayList<EasyUITreeNode>();
		
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<TbContentCategory>  contentCates = contentCateMapper.selectByExample(example);
		for(TbContentCategory cate:contentCates){
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(cate.getId());
			node.setState(cate.getIsParent()?"closed":"open");
			node.setText(cate.getName());
			nodes.add(node);
		}
		return nodes;
	}

	@Override
	public QingNiaoResult addContentCate(Long parentId, String name) {
		TbContentCategory contentCate = new TbContentCategory();
		contentCate.setParentId(parentId);
		contentCate.setName(name);
		contentCate.setStatus(1);
		contentCate.setSortOrder(1);
		contentCate.setIsParent(false);
		contentCate.setCreated(new Date());
		contentCate.setUpdated(new Date()); 
		
		contentCateMapper.insert(contentCate);
		
		//判断新增节点的上一级是否是父节点 如果不是  就要更新，如果是  什么都不做 
		TbContentCategory  contentCateParent = contentCateMapper.selectByPrimaryKey(parentId);
		if(!contentCateParent.getIsParent()){  //不是父节点
			contentCateParent.setIsParent(true);
			contentCateMapper.updateByPrimaryKey(contentCateParent);
		}
		return QingNiaoResult.ok();
	}

}
