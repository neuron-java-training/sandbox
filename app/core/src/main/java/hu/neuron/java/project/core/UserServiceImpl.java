package hu.neuron.java.project.core;

import hu.neuron.java.project.core.db.RoleDAO;
import hu.neuron.java.project.core.db.UserDAO;
import hu.neuron.java.project.core.vo.RoleVO;
import hu.neuron.java.project.core.vo.UserVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	RoleDAO roleDAO;

	@Override
	public UserVO findUserAndRolesByName(String name) throws Exception {

		UserVO uvo = userDAO.findUserByName(name);

		if (uvo != null) {
			uvo = setUpRoles(uvo);
		}
		return uvo;
	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {
		
		Long userId = userDAO.save(userVO);

		RoleVO userRole = roleDAO.findRoleByName("ROLE_USER");
		
		roleDAO.addRoleToUser(userRole.getId(), userId);

	}
	
	public UserVO setUpRoles(UserVO vo) throws Exception {
		List<RoleVO> roles;
		try {
			roles = roleDAO.findRolesByUserId(vo.getId());
			vo.setRoles(roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;

	}
}
