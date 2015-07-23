package hu.neuron.java.project.core;

import hu.neuron.java.project.core.vo.UserVO;


public interface UserService {

	UserVO findUserAndRolesByName(String name) throws Exception;

	void registrationUser(UserVO userVO) throws Exception;
}
