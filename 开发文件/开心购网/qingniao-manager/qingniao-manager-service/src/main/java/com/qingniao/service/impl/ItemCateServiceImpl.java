package com.qingniao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qingniao.common.pojo.EasyUITreeNode;
import com.qingniao.mapper.TbItemCatMapper;
import com.qingniao.pojo.TbItemCat;
import com.qingniao.pojo.TbItemCatExample;
import com.qingniao.pojo.TbItemCatExample.Criteria;
import com.qingniao.service.ItemCateService;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ItemCateServiceImpl implements ItemCateService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getItemCateByParentId(long id) {
		
		List<EasyUITreeNode> nodes = new ArrayList<EasyUITreeNode>();
		
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		
		List<TbItemCat> itemCates = itemCatMapper.selectByExample(example );
		for(TbItemCat cat:itemCates){
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(cat.getId());
			node.setText(cat.getName());
			node.setState(cat.getIsParent()?"closed":"open");
			nodes.add(node);
		} 
		return nodes;
	}

}
