package hu.neuron.java.service;

import hu.neuron.java.service.vo.UserVO;

public interface UserServiceRemote {

	public UserVO findUserByName(String name) throws Exception;

	public void registrationUser(UserVO userVO) throws Exception;

	public UserVO setUpRoles(UserVO vo) throws Exception;
}
