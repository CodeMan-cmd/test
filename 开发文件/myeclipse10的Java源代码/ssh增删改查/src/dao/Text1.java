package dao;

import java.math.BigDecimal;

/**
 * Text1 entity. @author MyEclipse Persistence Tools
 */

public class Text1 implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String name;

	// Constructors

	@Override
	public String toString() {
		return "Text1 [id=" + id + ", name=" + name + "]";
	}

	/** default constructor */
	public Text1() {
	}

	/** full constructor */
	public Text1(String name) {
		this.name = name;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}