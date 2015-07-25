package hu.neuron.java.project.core.dao;


import hu.neuron.java.project.core.entity.Role;
import hu.neuron.java.project.core.vo.RoleVO;

import java.util.List;

public interface RoleDAO extends BaseDAO<Role,RoleVO> {

	List<RoleVO> findRolesByUserId(Long id) throws Exception;

	void addRoleToUser(Long roleId, Long userId) throws Exception;

	void removeRoleFromUser(Long roleId, Long userId) throws Exception;

	RoleVO findRoleByName(String name) throws Exception;
	
}
