package entity;

public class PetOwner {
	private int id;
	private String name;
	private String password;
	private int money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "PetOwner [id=" + id + ", name=" + name + ", password="
				+ password + ", money=" + money + "]";
	}
	
}
