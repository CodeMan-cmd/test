package com.qingniao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qingniao.common.pojo.EasyUIDataGridResult;
import com.qingniao.common.pojo.EasyUITreeNode;
import com.qingniao.common.pojo.QingNiaoResult;
import com.qingniao.pojo.TbItem;
import com.qingniao.search.service.SearchItemService;
import com.qingniao.service.ItemCateService;
import com.qingniao.service.ItemService;
import com.qingniao.utils.FastDFSClient;

@Controller
public class ItemComtroller {

	
	@Autowired
	private ItemCateService itemCateServiceImpl;
	
	@Autowired
	private ItemService itemServiceImpl;
	
	@Autowired
	private SearchItemService searchItemServiceImpl;
	
	@Value("${imageServerUrl}")
	private String imageServerUrl;

	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItems(int page,int rows){
		EasyUIDataGridResult result = itemServiceImpl.getItems(page, rows);
		return result;
	}
	
	/*
	 * 选择商品类目
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCateByParentId(@RequestParam(name="id",defaultValue="0") long id){
		List<EasyUITreeNode> nodes = itemCateServiceImpl.getItemCateByParentId(id);
		return nodes;
	}
	
	/*
	 * 图片上传
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public Map<String,Object>  picUpload(MultipartFile uploadFile){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			String originalFilename  = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			String file = fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
			System.out.println(file);
			map.put("error", 0);
			map.put("url",  imageServerUrl + file);
		} catch (Exception e) {
			map.put("error", 1);
			map.put("message", "图片上传失败");
		}
		//页面需要json格式  {"error:0/1,"url":path"}
		return map; 
	}
	
	/*
	 * 保存商品
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public QingNiaoResult addItem(TbItem item,String desc){
		QingNiaoResult result = itemServiceImpl.addItem(item, desc);
		return result;
	}
	
	/**导入商品到索引库
	 */
	
	@RequestMapping("/item/import")
	@ResponseBody
	public QingNiaoResult importItem(){
		QingNiaoResult result = searchItemServiceImpl.importItem();
		return result;
	}
}
