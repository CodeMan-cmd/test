package text;

import java.math.BigDecimal;
import java.util.List;


import org.junit.Test;

import dao.Text1;
import dao.Text1DAO;

public class TextJunit {
	Text1DAO dao = new Text1DAO();
	@Test
	public void test() {
		List<Text1> dao2 = dao.findAll();
		for (Text1 text1 : dao2) {
			System.out.println(text1);
		}
	}

	//添加 
	@Test
	public void text3() {
		Text1 text1=new Text1();
		BigDecimal b=new BigDecimal(10);
		text1.setId(b);
		text1.setName("李四");
		Text1DAO ddo=new Text1DAO();
		ddo.save(text1);
	}
	//带参查询
	@Test
	public void test3() {
		List<Text1> dao2 = dao.findAll("童辉煌");
		for (Text1 text1 : dao2) {
			System.out.println(text1.getId()+text1.getName());
		}
	}
	//删除
	@Test
	public void test4() {
		Text1 text1=new Text1();
		BigDecimal b=new BigDecimal(12);
		text1.setId(b);
		dao.delete(text1);
	}
	//更新
	@Test
	public void text5(){
		Text1 text1=new Text1();
		BigDecimal b=new BigDecimal(10);
		text1.setId(b);
		text1.setName("改了");
		dao.saveOrUpdate(text1);
	}
}
