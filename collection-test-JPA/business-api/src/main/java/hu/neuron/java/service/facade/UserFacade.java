package hu.neuron.java.service.facade;

import hu.neuron.java.service.vo.UserVO;

public interface UserFacade {

	public UserVO findUserAndRolesByName(String name) throws Exception;

	public void registrationUser(UserVO userVO) throws Exception;
}