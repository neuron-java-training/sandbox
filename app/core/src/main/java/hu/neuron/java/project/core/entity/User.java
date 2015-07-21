package hu.neuron.java.project.core.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@NamedQuery(name = "findUserByName", query = "SELECT u FROM User u  WHERE u.userName = :pName")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String userName;

	private String password;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "user_role_sw")
	private Collection<Role> roles;

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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
