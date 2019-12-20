package dao;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Text1 entity. @author MyEclipse Persistence Tools
 */

public class Text1 implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Text1 [id=" + id + ", name=" + name +"]";
	}

	private BigDecimal id;
	private String name;
	private Set test2s = new HashSet(0);

	// Constructors

	/** default constructor */
	public Text1() {
	}

	/** full constructor */
	public Text1(String name, Set test2s) {
		this.name = name;
		this.test2s = test2s;
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

	public Set getTest2s() {
		return this.test2s;
	}

	public void setTest2s(Set test2s) {
		this.test2s = test2s;
	}

}