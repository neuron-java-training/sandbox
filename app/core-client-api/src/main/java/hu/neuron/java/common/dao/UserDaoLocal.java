package hu.neuron.java.common.dao;

import hu.neuron.java.common.dto.UserDTO;

public interface UserDaoLocal extends BaseDao<UserDTO> {

	UserDTO findUserByName(String name) throws Exception;

}
