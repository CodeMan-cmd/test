package pojo;

import java.util.List;

public class Role {

	private int id;
	private String role_name;
	/**
	 * 当前员工类型的集合
	 */
	private List<User> user;
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public Role(int id, String role_name) {
		super();
		this.id = id;
		this.role_name = role_name;
	}
	public Role() {
		super();
	}
	
	
	
}
