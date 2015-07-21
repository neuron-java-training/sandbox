package hu.neuron.java.project.business.mapper;

import hu.neuron.java.project.business.bo.UserBO;
import hu.neuron.java.project.core.entity.User;

public class UserMapper {

	public UserBO convertEntitytoBO(User userEntity) {
		UserBO userBO = new UserBO();
		userBO.setId(userEntity.getId());
		userBO.setName(userEntity.getName());
		userBO.setPassword(userEntity.getPassword());
		userBO.setRole(userEntity.getRole());
		return userBO;
	}

	public User convertEntitytoBO(UserBO userBO) {
		User userEntity = new User();
		userEntity.setId(userBO.getId());
		userEntity.setName(userBO.getName());
		userEntity.setPassword(userBO.getPassword());
		userEntity.setRole(userBO.getRole());
		return userEntity;
	}

}
