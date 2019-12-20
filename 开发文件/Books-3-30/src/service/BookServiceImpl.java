package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pojo.Books;
import utils.Page;
import dao.BookMapper;

@Service
public class BookServiceImpl implements BookService {
	@Resource
	private BookMapper bookMapper;

	// 分页查询
	public List<Books> selectAll(Page page, int type, String text) {
		// TODO Auto-generated method stub
		return bookMapper.selectAll(page, type, text);
	}

	// 模糊查询
	public int selectCountByBook(int type, String text) {
		// TODO Auto-generated method stub
		return bookMapper.selectCountByBook(type, text);
	}

	// 添加
	public int addBook(Books b) {
		// TODO Auto-generated method stub
		return bookMapper.addBook(b);
	}

}
