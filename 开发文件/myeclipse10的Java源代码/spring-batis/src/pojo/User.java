package pojo;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.alibaba.fastjson.annotation.JSONField;


public class User {
  private  int id;
  @NotEmpty(message="用户编码不能为空")//校验注解ksr-303验证
  private  String  userCode;
  private  String userName;
  private  String userPassword;
  private  int gender;
  @JSONField(format="yyyy-MM-dd")//传递json数据日期格式
  private  Date  birthday;
  private  String phone ;
  private  String address;  
  private  int userRole;   
  private  int createBy;
  @JSONField(format="yyyy-MM-dd")//传递json数据日期格式
  private  Date  creationDate;
  private  int modifBy;
  @JSONField(format="yyyy-MM-dd")//传递json数据日期格式
  private Date  modifyDate;
  private String a_idPicPath;//证件照地址
  
public String getA_idPicPath() {
	return a_idPicPath;
}

public void setA_idPicPath(String a_idPicPath) {
	this.a_idPicPath = a_idPicPath;
}

public User() {
	super();
}

public User(int id, String userCode, String userName, String userPassword) {
	super();
	this.id = id;
	this.userCode = userCode;
	this.userName = userName;
	this.userPassword = userPassword;
}

@Override
public String toString() {
	return "User [id=" + id + ", userCode=" + userCode + ", userName="
			+ userName + ", userPassword=" + userPassword + ", gender="
			+ gender + ", birthday=" + birthday + ", phone=" + phone
			+ ", address=" + address + ", userRole=" + userRole + ", createBy="
			+ createBy + ", creationDate=" + creationDate + ", modifBy="
			+ modifBy + ", modifyDate=" + modifyDate + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserCode() {
	return userCode;
}
public void setUserCode(String userCode) {
	this.userCode = userCode;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public int getGender() {
	return gender;
}
public void setGender(int gender) {
	this.gender = gender;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getUserRole() {
	return userRole;
}
public void setUserRole(int userRole) {
	this.userRole = userRole;
}
public int getCreateBy() {
	return createBy;
}
public void setCreateBy(int createBy) {
	this.createBy = createBy;
}
public Date getCreationDate() {
	return creationDate;
}
public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}
public int getModifBy() {
	return modifBy;
}
public void setModifBy(int modifBy) {
	this.modifBy = modifBy;
}
public Date getModifyDate() {
	return modifyDate;
}
public void setModifyDate(Date modifyDate) {
	this.modifyDate = modifyDate;
}
}
