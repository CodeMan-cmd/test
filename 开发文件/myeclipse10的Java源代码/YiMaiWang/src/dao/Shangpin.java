package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.Easybuy_product;
import util.Page;

@Repository("shangpin")
public interface Shangpin {
		public List<Easybuy_product> selectProdct();
		/*//搜索引擎
		public List<Easybuy_product> souSoYinQing(@Param("name")String name);*/
		//数据条数
		public int selectCount(@Param("name2") Easybuy_product name2);
		//模糊查询页数和条数
		public List<Easybuy_product> selectLimit(@Param("name2")Easybuy_product name2 , @Param("p") Page p);
}
