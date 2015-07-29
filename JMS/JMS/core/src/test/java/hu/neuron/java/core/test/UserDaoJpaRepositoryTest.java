package hu.neuron.java.core.test;

import hu.neuron.java.core.dao.UserDao;
import hu.neuron.java.core.entity.User;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserDaoJpaRepositoryTest {

	private static final Logger logger = Logger
			.getLogger(UserDaoJpaRepositoryTest.class);

	@Autowired
	UserDao userDao;

	@Test
	public void test1Save() {
		try {
			ArrayList<User> users = new ArrayList<>();

			for (int i = 10; i < 110; i++) {
				User user = new User();
				user.setUserName("test" + i);
				user.setPassword("test" + i);
				users.add(user);
			}

			users = (ArrayList<User>) userDao.save(users);

			for (User user : users) {
				logger.info("user: " + user);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test2Sort() {
		try {
			Sort sort = new Sort(Sort.Direction.DESC, "userName");
			List<User> users = userDao.findAll(sort);

			for (User user : users) {
				logger.info("sorting User: " + user);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test3Paging() {
		try {

			Sort sort = new Sort(Sort.Direction.ASC, "userName");
			PageRequest pageable = new PageRequest(0, 10, sort);
			Page<User> userpage = userDao.findAll(pageable);

			logger.info("getTotalElements: " + userpage.getTotalElements());
			logger.info("getTotalPages: " + userpage.getTotalPages());
			logger.info("getSize: " + userpage.getSize());
			logger.info("getNumber: " + userpage.getNumber());
			logger.info("getNumberOfElements: "
					+ userpage.getNumberOfElements());

			for (User user : userpage) {
				logger.info("Page 1 user: " + user);
			}

			for (User user : userpage.getContent()) {
				logger.info("Page 1 content user: " + user);
			}

			Pageable pageable2 = userpage.nextPageable();

			userpage = userDao.findAll(pageable2);

			logger.info("getTotalElements: " + userpage.getTotalElements());
			logger.info("getTotalPages: " + userpage.getTotalPages());
			logger.info("getSize: " + userpage.getSize());
			logger.info("getNumber: " + userpage.getNumber());
			logger.info("getNumberOfElements: "
					+ userpage.getNumberOfElements());

			for (User user : userpage) {
				logger.info("Page 2 user: " + user);
			}

			for (User user : userpage.getContent()) {
				logger.info("Page 2  content user: " + user);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
}
