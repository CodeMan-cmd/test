package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Books;
import util.Page;

public interface BooksService {
	//添加
	public int insertBooks(Books b);
	//查询
	public List<Books> selectBooks();
	//总记录数
	public int getCountUser( Books b);
	public List<Books> getAllUser(@Param("b") Books b, @Param("p") Page p);
}
