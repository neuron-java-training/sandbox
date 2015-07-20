package hu.neuron.java.persistence.dto;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoleDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;

	public RoleDTO() {
	}

	public RoleDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	public static final class RoleDTOMapper implements RowMapper<RoleDTO> {

		public RoleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setId(rs.getLong("id"));
			roleDTO.setName(rs.getString("name"));
			return roleDTO;
		}
	}
}
