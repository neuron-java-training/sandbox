package hu.neuron.java.project.core;

import hu.neuron.java.project.core.entity.RoleVO;
import hu.neuron.java.project.core.entity.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public UserVO findUserByName(String name) throws Exception {
		UserVO uvo;
		try {
			uvo = this.jdbcTemplate.queryForObject(
					"select id ,name, password from user where name=?",
					new Object[] { name }, new UserVOMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		List<RoleVO> roles;	
		roles = this.jdbcTemplate
				.query("select r.id, r.name from role r, user_role_sw sw where sw.user_id = ? and sw.role_id = r.id",
						new Object[] { uvo.getId() }, new RoleDTOMapper());
		uvo.setRoles(roles);
		
		return uvo;
	}
	
	@Override
	public void registrationUser( final UserVO userVO) throws Exception {

		final String INSERT_SQL = "insert into user (name,password) values(?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL,
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, userVO.getUserName());
				ps.setString(2, userVO.getPassword());
				return ps;
			}
		}, keyHolder);

		Long userId = keyHolder.getKey().longValue();
		
		RoleVO userRole = null;
		
		try {
			userRole = this.jdbcTemplate.queryForObject(
					"select id,name from role where name=?",
					new Object[] { "ROLE_ADMIN" }, new RoleDTOMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		
		this.jdbcTemplate.update(
				"insert into user_role_sw (user_id,role_id) values(?,?)",
				userId, userRole.getId());
	}
	

	public static final class UserVOMapper implements RowMapper<UserVO> {

		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO userVO = new UserVO();
			userVO.setId(rs.getLong("id"));
			userVO.setUserName(rs.getString("name"));
			userVO.setPassword(rs.getString("password"));
			return userVO;
		}
	}
	
	public static final class RoleDTOMapper implements RowMapper<RoleVO> {

		public RoleVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleVO roleVO = new RoleVO();
			roleVO.setId(rs.getLong("id"));
			roleVO.setName(rs.getString("name"));
			return roleVO;
		}
	}
}
