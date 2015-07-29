package hu.neuron.java.service.impl;

import hu.neuron.java.core.dao.RoleDao;
import hu.neuron.java.core.dao.UserDao;
import hu.neuron.java.core.entity.Role;
import hu.neuron.java.core.entity.User;
import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.UserServiceRemote;
import hu.neuron.java.service.converter.RoleConverter;
import hu.neuron.java.service.converter.UserConverter;
import hu.neuron.java.service.vo.RoleVO;
import hu.neuron.java.service.vo.UserVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "UserService")
@Local(UserServiceLocal.class)
@Remote(UserServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UserServiceImpl implements UserServiceLocal, UserServiceRemote,
		Serializable {

	private static final long serialVersionUID = 7081140322696230547L;

	private static final Logger logger = Logger
			.getLogger(UserServiceImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@EJB
	RoleConverter roleConverter;

	@EJB
	UserConverter userConverter;

	public UserServiceImpl() {
	}

	@Override
	public UserVO findUserByName(String name) throws Exception {
		logger.debug(entityManager);
		UserVO vo = userConverter.toVO(userDao.findUserByName(name));
		return vo;

	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {

		User user = userDao.save(userConverter.toEntity(userVO));
		Role userRole = roleDao.findRoleByName("ROLE_USER");
		roleDao.addRoleToUser(userRole.getId(), user.getId());
	}

	@Override
	public List<UserVO> getUserList(int page, int size, String sortField,
			int sortOrder, String filter, String filterColumnName) {
		Direction dir = sortOrder == 1 ? Sort.Direction.ASC
				: Sort.Direction.DESC;
		PageRequest pageRequest = new PageRequest(page, size, new Sort(
				new org.springframework.data.domain.Sort.Order(dir, sortField)));
		List<UserVO> ret = new ArrayList<UserVO>(size);
		Page<User> entities;

		if (filter.length() != 0 && filterColumnName.equals("userName")) {
			entities = userDao.findByUserNameStartsWith(filter, pageRequest);
		} else {
			entities = userDao.findAll(pageRequest);
		}

		if (entities != null && entities.getSize() > 0) {
			List<User> contents = entities.getContent();
			for (User m : contents) {
				ret.add(userConverter.toVO(m));

			}
		}
		return ret;
	}

	@Override
	public RoleVO getRoleByName(String role) {
		RoleVO vo = null;
		try {
			vo = roleConverter.toVO(roleDao.findRoleByName(role));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public UserVO saveUser(UserVO selectedUser) {

		UserVO vo = userConverter.toVO(userDao.save(userConverter
				.toEntity(selectedUser)));
		return vo;

	}

	@Override
	public List<UserVO> getUserList() {

		return userConverter.toVO(userDao.findAll());
	}

	@Override
	public UserVO getUserById(Long id) {
		return userConverter.toVO(userDao.findOne(id));
	}

}
