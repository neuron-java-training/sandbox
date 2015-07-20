package hu.neuron.java.persistence.dao;

import hu.neuron.java.persistence.dto.UserDTO;

public interface UserDAO extends BaseDAO<UserDTO> {

	UserDTO findUserByName(String name) throws Exception;

}
