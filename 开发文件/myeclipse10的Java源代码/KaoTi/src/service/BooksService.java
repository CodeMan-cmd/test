package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Books;
import util.Page;

public interface BooksService {
	//���
	public int insertBooks(Books b);
	//��ѯ
	public List<Books> selectBooks();
	//�ܼ�¼��
	public int getCountUser( Books b);
	public List<Books> getAllUser(@Param("b") Books b, @Param("p") Page p);
}
