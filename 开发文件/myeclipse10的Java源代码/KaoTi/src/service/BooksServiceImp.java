package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import dao.UserMapper;
import pojo.Books;
import util.Page;
@Repository("booksService")
public class BooksServiceImp implements BooksService {
	@Resource
	public UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public BooksServiceImp(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}
	public BooksServiceImp() {
		super();
	}

	
	public int insertBooks(Books b) {
		return userMapper.insertBooks(b);
	}

	public List<Books> selectBooks() {
		return userMapper.selectBooks();
	}

	public int getCountUser(Books b) {
		return userMapper.getCountUser(b);
	}

	public List<Books> getAllUser(Books b, Page p) {
		// 保存总计录数
		p.setZongjilushu(getCountUser(b));
		return userMapper.getAllUser(b, p);
	}
}
