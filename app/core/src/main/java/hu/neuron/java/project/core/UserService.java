package hu.neuron.java.project.core;

import hu.neuron.java.project.core.entity.UserVO;


public interface UserService {

	UserVO findUserByName(String name) throws Exception;

	void registrationUser(UserVO userVO) throws Exception;
}
