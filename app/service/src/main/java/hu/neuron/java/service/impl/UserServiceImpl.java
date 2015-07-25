package hu.neuron.java.service.impl;

import hu.neuron.java.common.dao.RoleDaoLocal;
import hu.neuron.java.common.dao.UserDaoLocal;
import hu.neuron.java.common.dto.RoleDTO;
import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.UserServiceRemote;
import hu.neuron.java.service.converter.RoleConverter;
import hu.neuron.java.service.converter.UserConverter;
import hu.neuron.java.service.vo.UserVO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(UserServiceLocal.class)
@Remote(UserServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserServiceImpl implements UserServiceLocal, UserServiceRemote {
	@EJB
	UserDaoLocal userDAO;
	@EJB
	RoleDaoLocal roleDAO;

	public UserServiceImpl() {
	}

	@Override
	public UserVO findUserByName(String name) throws Exception {
		UserVO vo = UserConverter.toVO(userDAO.findUserByName(name));
		return vo;

	}

	@Override
	public UserVO setUpRoles(UserVO vo) throws Exception {
		List<RoleDTO> roles;
		try {
			roles = roleDAO.findRolesByUserId(vo.getId());
			vo.setRoles(RoleConverter.toVO(roles));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;

	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {

		Long userId = userDAO.save(UserConverter.toDTO(userVO));
		RoleDTO userRole = roleDAO.findRoleByName("ROLE_USER");
		roleDAO.addRoleToUser(userRole.getId(), userId);
	}

}
