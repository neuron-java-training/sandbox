package hu.neuron.java.persistence.dto;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = -1265516570893529965L;

	private Long id;
	private String userName;
	private String password;

	public UserDTO() {
	}

	public UserDTO(Long id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + ", password="
				+ password + "]";
	}

	public static final class UserDTOMapper implements RowMapper<UserDTO> {

		public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(rs.getLong("id"));
			userDTO.setUserName(rs.getString("name"));
			userDTO.setPassword(rs.getString("password"));
			return userDTO;
		}
	}

}
