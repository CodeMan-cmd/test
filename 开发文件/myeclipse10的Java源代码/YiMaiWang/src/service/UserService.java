package service;
import java.util.List;


import pojo.Easybuy_user;

public interface UserService {
		public int insertUser(Easybuy_user user);
		//登录
		public List<Easybuy_user> selectUser(String loginName,String password);
		//异步判断
		public List<Easybuy_user> selectJudgment(String loginName);
}
