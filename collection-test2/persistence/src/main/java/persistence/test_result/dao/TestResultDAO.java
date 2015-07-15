package persistence.test_result.dao;

import hu.neuron.java.persistence.test_result.TestResultDAOInterface;
import hu.neuron.java.persistence.test_result.TestResultDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persistence.test_result.ConnectionFactory;

public class TestResultDAO implements TestResultDAOInterface{
	
	Connection connection = null;
	
	public TestResultDAO() {
		super();
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Long save(TestResultDTO dto) throws Exception{
		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO results( name,initTime,accessTime,deleteTime,sortTime ) VALUES ( ?,?,?,?,? ) ";
			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, dto.getTestName());
			statement.setLong(2, dto.getInitTime());
			statement.setLong(3, dto.getAccessTime());
			statement.setLong(4, dto.getDeleteTime());
			statement.setLong(5, dto.getSortTime());
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(1);
			}

		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rv;
	}

	@Override
	public void update(TestResultDTO dto) throws Exception{
		PreparedStatement statement = null;
		try {
			String sql = "UPDATE results set name=? ,initTime=?, accessTime=?, deleteTime=?, sortTime=? where id=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, dto.getTestName());
			statement.setLong(2, dto.getInitTime());
			statement.setLong(3, dto.getAccessTime());
			statement.setLong(4, dto.getDeleteTime());
			statement.setLong(5, dto.getSortTime());
			statement.setLong(6, dto.getId());
			statement.executeUpdate();

		} catch (Exception e) {
			throw new Exception();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(Long id) throws Exception{
		PreparedStatement statement = null;
		try {
			String sql = "DELETE FROM results where id=? ";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public TestResultDTO find(Long id) throws Exception{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		TestResultDTO rv = null;
		try {

			String sql = "select * from results where id = ?";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String name = resultSet.getString("name");
				Long initTime = resultSet.getLong("initTime");
				Long accassTime = resultSet.getLong("accessTime");
				Long deleteTime = resultSet.getLong("deleteTime");
				Long sortTime = resultSet.getLong("sortTime");
			
				rv = new TestResultDTO(rvid, name, initTime, accassTime, deleteTime, sortTime);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rv;
	}

	@Override
	public List<TestResultDTO> findAll() throws Exception{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<TestResultDTO> rv = new ArrayList<TestResultDTO>();
		try {

			String sql = "select * from results";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String name = resultSet.getString("name");
				Long initTime = resultSet.getLong("initTime");
				Long accassTime = resultSet.getLong("accessTime");
				Long deleteTime = resultSet.getLong("deleteTime");
				Long sortTime = resultSet.getLong("sortTime");
				rv.add(new TestResultDTO(rvid, name, initTime, accassTime, deleteTime, sortTime));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rv;
	}

	@Override
	public List<TestResultDTO> getAverages() throws Exception{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<TestResultDTO> rv = new ArrayList<TestResultDTO>();
		try {

			String sql = "SELECT name, AVG(initTime) as initTime, AVG(accessTime) as accessTime, AVG(deleteTime)  as deleteTime, AVG(sortTime) as sortTime"
					+ " FROM results GROUP BY name";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Long initTime = resultSet.getLong("initTime");
				Long accassTime = resultSet.getLong("accessTime");
				Long deleteTime = resultSet.getLong("deleteTime");
				Long sortTime = resultSet.getLong("sortTime");
				rv.add(new TestResultDTO(null, name, initTime, accassTime, deleteTime, sortTime));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rv;
	}

}
