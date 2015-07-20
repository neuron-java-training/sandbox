package hu.neuron.java.persistence.dto;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ResultDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Long initTime;
	private Long accessTime;
	private Long deleteTime;
	private Long sortTime;
	
	public ResultDTO() {
	}

	public ResultDTO(Long id, String name, Long initTime, Long accessTime, Long deleteTime, Long sortTime) {
		super();
		this.id = id;
		this.name = name;
		this.initTime = initTime;
		this.accessTime = accessTime;
		this.deleteTime = deleteTime;
		this.sortTime = sortTime;
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

	public Long getInitTime() {
		return initTime;
	}

	public void setInitTime(Long initTime) {
		this.initTime = initTime;
	}

	public Long getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}

	public Long getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Long deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Long getSortTime() {
		return sortTime;
	}

	public void setSortTime(Long sortTime) {
		this.sortTime = sortTime;
	}
	
	public static final class ResultDTOMapper implements RowMapper<ResultDTO> {

		public ResultDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ResultDTO resultDTO = new ResultDTO();
			resultDTO.setId(rs.getLong("id"));
			resultDTO.setName(rs.getString("name"));
			resultDTO.setInitTime(rs.getLong("initTime"));
			resultDTO.setAccessTime(rs.getLong("accessTime"));
			resultDTO.setDeleteTime(rs.getLong("delteTime"));
			resultDTO.setSortTime(rs.getLong("sortTime"));
			return resultDTO;
		}
	}
	
	

}
