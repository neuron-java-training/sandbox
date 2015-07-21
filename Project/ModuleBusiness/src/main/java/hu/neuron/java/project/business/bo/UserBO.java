package hu.neuron.java.project.business.bo;

import java.io.Serializable;
import java.util.List;

public class UserBO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id=null;

	private String name;
	private String password;
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role
				+ "]";
	}

}
