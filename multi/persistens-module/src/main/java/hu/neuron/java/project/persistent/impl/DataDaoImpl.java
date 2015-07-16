package hu.neuron.java.project.persistent.impl;

import hu.neuron.java.project.persistens.DataDao;
import hu.neuron.java.project.persistens.DataVO;
import hu.neuron.java.project.persistens.DataVO.DataVOMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class DataDaoImpl implements DataDao
{

	private static HashMap<Long, DataVO> dbMock = new HashMap<>();
	private Connection connection;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private DataDaoImpl()
	{

	}

	public DataDaoImpl(Connection connection)
	{
		this.connection = connection;

	}

	@Override
	public Long save(final DataVO dataVO)
	{

		final String INSERT_SQL = "insert into data (data1,data2,data3) values(?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator()
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException
			{
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, dataVO.getData1());
				ps.setString(2, dataVO.getData2());
				ps.setString(3, dataVO.getData3());
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(DataVO dataVO)
	{
		this.jdbcTemplate.update("update data set data1 = ?, data2 = ?, data3 = ?,  where id = ?",
				dataVO.getData1(), dataVO.getData2(), dataVO.getData3(), dataVO.getId());
	}

	@Override
	public void delete(Long id)
	{
		this.jdbcTemplate.update("delete from data where id = ?", id);
	}

	@Override
	public DataVO findById(Long id)
	{
		try
		{
			return this.jdbcTemplate.queryForObject("select * from data where id=?",
					new Object[] { id }, new DataVOMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
	}

	@Override
	public List<DataVO> findAll()
	{
		return this.jdbcTemplate.query("select * from data", new DataVOMapper());
	}

}
