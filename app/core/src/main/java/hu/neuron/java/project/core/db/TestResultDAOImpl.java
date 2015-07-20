package hu.neuron.java.project.core.db;

import hu.neuron.java.project.core.TestResult;
import hu.neuron.java.project.core.TestResultVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TestResultDAOImpl implements TestResultDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Long save(final TestResult tr) {

		final String INSERT_SQL = "insert into results values(?,?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
						Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, 0);
				ps.setString(2, tr.getCollectionName());
				ps.setLong(3, tr.getInitTime());
				ps.setLong(4, tr.getFillTime());
				ps.setLong(5, tr.getSortTime());
				ps.setLong(6, tr.getAccessTime());
				ps.setLong(7, tr.getDeletionTime());
				ps.setLong(8, tr.getDuplicateEliminationTime());
				return ps;
			}
		}, keyHolder);
		
		return keyHolder.getKey().longValue();
	}

	@Override
	public List<TestResultVO> readAll() {
		return this.jdbcTemplate.query("select * from results",
				new TestResultVOMapper());
	}
	
	public static final class TestResultVOMapper implements RowMapper<TestResultVO> {

		public TestResultVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new TestResultVO(rs.getString("name"),rs.getLong("init"),rs.getLong("fill"),
					rs.getLong("sort"),rs.getLong("access"),rs.getLong("delete"),
					rs.getLong("unduplicate"));
		}
	}

}
