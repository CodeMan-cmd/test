package pojo;

public class Easybuy_user {
	private int id;            //id自增
	private String loginName;  //登录名
	private String userName;	//用户名
	private String password;	//密码
	private String email;       //邮箱
	private String mobile;		//手机号
	//打印输出全部
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	//有参构造
	public Easybuy_user(int id, String loginName, String userName,
			String password, String email, String mobile) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}
	//无参构造
	public Easybuy_user() {
		super();
	}
	
}
