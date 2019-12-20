package entity;

import java.sql.Date;

public class Pet {
	private int id;
	private String name;
	private String typName;
	private int health;
	private int love;
	private Date birthday;
	private int iwner_id;
	private int store_id;
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
	public String getTypName() {
		return typName;
	}
	public void setTypName(String typName) {
		this.typName = typName;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getIwner_id() {
		return iwner_id;
	}
	public void setIwner_id(int iwner_id) {
		this.iwner_id = iwner_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", typName=" + typName
				+ ", health=" + health + ", love=" + love + ", birthday="
				+ birthday + ", iwner_id=" + iwner_id + ", store_id="
				+ store_id + "]";
	}
	
}
