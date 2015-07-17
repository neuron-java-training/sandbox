package hu.neuron.java.project.core.db;

import hu.neuron.java.project.core.TestResult;
import hu.neuron.java.project.core.TestResultVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestResultDAOImpl implements TestResultDAO {

	private Connection connection;

	public TestResultDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Long save(TestResult tr) {
		Long rv = null;
		PreparedStatement statement = null;
		try {
			String sql = "INSERT INTO results VALUES ( ?,?,?,?,?,?,?,? ) ";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, 0);
			statement.setString(2, tr.getCollectionName());
			statement.setLong(3, tr.getInitTime());
			statement.setLong(4, tr.getFillTime());
			statement.setLong(5, tr.getSortTime());
			statement.setLong(6, tr.getAccessTime());
			statement.setLong(7, tr.getDeletionTime());
			statement.setLong(8, tr.getDuplicateEliminationTime());
			statement.executeUpdate();

//			rs = statement.getgeneratedkeys();
//
//			if (rs.next()) {
//				rv = rs.getlong(1);
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rv;
	}

	@Override
	public List<TestResultVO> readAll() {
		ArrayList<TestResultVO> list = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			String sql = "select * from RESULTS";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				long init = resultSet.getLong("INIT");
				long fill = resultSet.getLong("FILL");
				long sort = resultSet.getLong("SORT");
				long access = resultSet.getLong("ACCESS");
				long delete = resultSet.getLong("DELETE");
				long unduplicate = resultSet.getLong("UNDUPLICATE");
				list.add(new TestResultVO(name,init,fill,sort,access,delete,unduplicate));
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
			/*try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		}
		return list;
	}

}
