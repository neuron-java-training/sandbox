package hu.neuron.java.project.business;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DataBVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String data1;
	private String data2;
	private String data3;

	public DataBVO() {
	}

	public DataBVO(Long id, String data1, String data2, String data3) {
		super();
		this.id = id;
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

	@Override
	public String toString() {
		return "DataVO [id=" + id + ", data1=" + data1 + ", data2=" + data2
				+ ", data3=" + data3 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		DataBVO other = (DataBVO) obj;
		if (id == null) {
			if (other.id != null)
			{
				return false;
			}
		} else if (!id.equals(other.id))
		{
			return false;
		}
		return true;
	}
	
	public static final class DataBVOMapper implements RowMapper<DataBVO> {

		@Override
		public DataBVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DataBVO roleDTO = new DataBVO();
			roleDTO.setId(rs.getLong("id"));
			roleDTO.setData1(rs.getString("data1"));
			roleDTO.setData2(rs.getString("data3"));
			roleDTO.setData3(rs.getString("data2"));
			return roleDTO;
		}
	}

}
