package hu.neuron.java.project.business.impl;

import hu.neuron.java.project.business.BusinessO;
import hu.neuron.java.project.business.DataBVO;
import hu.neuron.java.project.business.DataBVO.DataBVOMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class BusinessOImpl implements BusinessO
{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Long save(final DataBVO dataBVO)
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
				ps.setString(1, dataBVO.getData1());
				ps.setString(2, dataBVO.getData2());
				ps.setString(3, dataBVO.getData3());
				return ps;
			}
		}, keyHolder);

		return keyHolder.getKey().longValue();
	}

	@Override
	public void update(DataBVO dataBVO)
	{
		this.jdbcTemplate.update("update data set data1 = ?, data2 = ?, data3 = ?,  where id = ?",
				dataBVO.getData1(), dataBVO.getData2(), dataBVO.getData3(), dataBVO.getId());
	}

	@Override
	public void delete(Long id)
	{
		this.jdbcTemplate.update("delete from data where id = ?", id);
	}

	@Override
	public DataBVO findById(Long id)
	{
		try {
			return this.jdbcTemplate.queryForObject(
					"select * from data where id=?", new Object[] { id },
					new DataBVOMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<DataBVO> findAll()
	{
		return this.jdbcTemplate.query("select * from data",
				new DataBVOMapper());
	}

}
