package dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pojo.Books;
import util.Page;
@Repository("userMapper")
public interface UserMapper {
	//���
	public int insertBooks(@Param("b")Books b);
	//��ѯ
	public List<Books> selectBooks();
	//��ѯ���ܼ�¼��
	public int getCountUser(@Param("b") Books b);
	public List<Books> getAllUser(@Param("b") Books b, @Param("p") Page p);
}
