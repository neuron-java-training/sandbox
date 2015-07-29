package hu.neuron.java.core.test;

import hu.neuron.java.core.dao.RoleDao;
import hu.neuron.java.core.dao.UserDao;
import hu.neuron.java.core.entity.Role;
import hu.neuron.java.core.entity.User;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class RoleDaoTest {

	private static final Logger logger = Logger
			.getLogger(UserDaoTest.class);
	private static Role role;
	private static User user;

	@Autowired
	RoleDao roleDao;

	@Autowired
	UserDao userRepository;

	@Test
	public void test1Save() {
		role = new Role();
		role.setName("USER");
		roleDao.save(role);
	}

	@Test
	public void test2Update() {

		role.setName("ADMIN");
		role = roleDao.save(role);
	}

	@Test
	public void test3Find() {
		try {
			Role rolerv = roleDao.findOne(role.getId());
			logger.info("rv: " + rolerv);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test4Find() {
		try {
			Role rolerv = roleDao.findRoleByName(role.getName());
			logger.info("rv: " + rolerv);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test5FindAll() {

		try {
			List<Role> roles = roleDao.findAll();
			for (Role userDTO : roles) {
				logger.info("rv: " + userDTO);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test6Delete() {
		roleDao.delete(role.getId());

	}

	@Test
	public void test7AddRoleToUser() {
		try {
			user = new User();
			user.setUserName("test");
			user.setPassword("test");
			user = userRepository.save(user);
			logger.info("user: " + user);

			role = new Role();
			role.setName("USER");
			roleDao.save(role);

			logger.info("role: " + role);

			roleDao.addRoleToUser(role.getId(), user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test8FindRolesByUserId() {
		try {
			List<Role> roles = roleDao.findRolesByUserId(user.getId());

			for (Role userDTO : roles) {
				logger.info("rv: " + userDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test9RemoveRoleFromUser() {
		try {
			roleDao.removeRoleFromUser(role.getId(), user.getId());

			List<Role> roles = roleDao.findRolesByUserId(user.getId());

			for (Role userDTO : roles) {
				logger.info("rv: " + userDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
