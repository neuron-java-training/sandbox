package hu.neuron.java.core.test;

import hu.neuron.java.core.dao.UserDao;
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
public class UserDaoTest {

	private static final Logger logger = Logger.getLogger(UserDaoTest.class);

	private static User user;

	@Autowired
	UserDao userDao;

	@Test
	public void test1Save() {
		try {
			user = new User();
			user.setUserName("test");
			user.setPassword("test");
			user = userDao.save(user);
			logger.info("user: " + user);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test2Update() {
		try {
			user.setUserName("C");
			userDao.save(user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test3Find() {
		try {
			User rvDTO = userDao.findOne(user.getId());
			logger.info("rv: " + rvDTO);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test4Find() {
		try {
			User rvDTO = userDao.findUserByName(user.getUserName());
			logger.info("rv: " + rvDTO);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test5FindAll() {
		try {
			List<User> users = userDao.findAll();
			for (User userDTO : users) {
				logger.info("rv: " + userDTO);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test6Delete() {
		try {
			userDao.delete(user.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
}
