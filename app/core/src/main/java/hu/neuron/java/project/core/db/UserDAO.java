package hu.neuron.java.project.core.db;

import hu.neuron.java.project.core.entity.User;
import hu.neuron.java.project.core.vo.UserVO;

public interface UserDAO extends BaseDAO<User,UserVO> {

	UserVO findUserByName(String name) throws Exception;

}
