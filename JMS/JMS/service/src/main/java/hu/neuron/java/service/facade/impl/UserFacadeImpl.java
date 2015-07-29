package hu.neuron.java.service.facade.impl;

import hu.neuron.java.service.RoleServiceRemote;
import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.facade.UserFacadeLocal;
import hu.neuron.java.service.facade.UserFacadeRemote;
import hu.neuron.java.service.impl.UserServiceImpl;
import hu.neuron.java.service.vo.RoleVO;
import hu.neuron.java.service.vo.UserVO;

import java.io.Serializable;
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
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(name = "UserFacade", mappedName = "UserFacade")
@Local(UserFacadeLocal.class)
@Remote(UserFacadeRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserFacadeImpl implements UserFacadeLocal, UserFacadeRemote,
		Serializable {
	
	private static final long serialVersionUID = -1296528259371447796L;

	private static final Logger logger = Logger.getLogger(UserFacadeImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	UserServiceLocal userService;

	@EJB(mappedName = "RoleService", name = "RoleService")
	RoleServiceRemote roleServiceRemote;

	public UserFacadeImpl() {
	}

	@Override
	public UserVO findUserAndRolesByName(String name) throws Exception {
		logger.debug(entityManager);
		UserVO userVO = userService.findUserByName(name);
		if (userVO != null) {
			userVO = roleServiceRemote.setUpRoles(userVO);
		}
		return userVO;
	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {
		userService.registrationUser(userVO);

	}

	@Override
	public UserVO findUserByName(String name) throws Exception {

		return userService.findUserByName(name);
	}

	@Override
	public List<UserVO> getUserList(int i, int pageSize, String sortField,
			int dir, String filter, String filterColumnName) {

		return userService.getUserList(i, pageSize, sortField, dir, filter,
				filterColumnName);
	}

	@Override
	public RoleVO getRoleByName(String role) {

		return userService.getRoleByName(role);
	}

	@Override
	public void saveUser(UserVO selectedUser) {
		userService.saveUser(selectedUser);

	}

	@Override
	public UserVO setUpRoles(UserVO vo) throws Exception {

		return roleServiceRemote.setUpRoles(vo);
	}

	@Override
	public int getRowNumber() {

		return roleServiceRemote.getRowNumber();
	}

	@Override
	public List<RoleVO> getRoles() {

		return roleServiceRemote.getRoles();
	}

	@Override
	public void saveRole(RoleVO roleVO) {
		roleServiceRemote.saveRole(roleVO);

	}

	@Override
	public void updateRole(RoleVO roleVO) {
		roleServiceRemote.updateRole(roleVO);
	}

	@Override
	public void removeRole(RoleVO roleVO) {
		roleServiceRemote.removeRole(roleVO);

	}

	@Override
	public List<RoleVO> getRoles(int i, int pageSize, String sortField,
			int dir, String filter, String filterColumnName) {
		return roleServiceRemote.getRoles(i, pageSize, sortField, dir, filter,
				filterColumnName);
	}

	@Override
	public int getRoleCount() {
		return roleServiceRemote.getRoleCount();
	}

}
