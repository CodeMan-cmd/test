package dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.Books;
import util.Page;
@Repository("userMapper")
public interface UserMapper {
	//添加
	public int insertBooks(@Param("b")Books b);
	//查询
	public List<Books> selectBooks();
	//查询出总记录数
	public int getCountUser(@Param("b") Books b);
	public List<Books> getAllUser(@Param("b") Books b, @Param("p") Page p);
}
