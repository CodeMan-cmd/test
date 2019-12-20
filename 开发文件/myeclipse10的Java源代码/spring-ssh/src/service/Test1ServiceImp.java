package service;

import dao.Text1DAO;

public class Test1ServiceImp implements Test1Service {
private Text1DAO text1Dao;

public Text1DAO getText1Dao() {
	return text1Dao;
}

public void setText1Dao(Text1DAO text1Dao) {
	this.text1Dao = text1Dao;
}
}
