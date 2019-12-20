package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Books;
import utils.Page;

public interface BookMapper {
	// 分页查询
	public List<Books> selectAll(@Param("page") Page page,
			@Param("type") int type, @Param("text") String text);

	// 查询记录数，模糊查询
	public int selectCountByBook(@Param("type") int type,
			@Param("text") String text);

	// 新增
	public int addBook(@Param("b") Books b);
}
