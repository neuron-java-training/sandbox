package hu.neuron.java.common.dao;

import hu.neuron.java.common.dto.RoleDTO;

import java.util.List;

public interface RoleDaoLocal extends BaseDao<RoleDTO> {

	List<RoleDTO> findRolesByUserId(Long id) throws Exception;

	void addRoleToUser(Long roleId, Long userId) throws Exception;

	void removeRoleFromUser(Long roleId, Long userId) throws Exception;

	RoleDTO findRoleByName(String name) throws Exception;
}
