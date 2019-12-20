package service;

import java.util.List;

import pojo.Books;
import utils.Page;

public interface BookService {
	// 分页
	public List<Books> selectAll(Page page, int type, String text);

	// 模糊查询
	public int selectCountByBook(int type, String text);

	// 新增
	public int addBook(Books b);
}
