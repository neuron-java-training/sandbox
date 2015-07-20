package hu.neuron.java.persistence.dao;

import hu.neuron.java.persistence.dto.RoleDTO;

import java.util.List;

public interface RoleDAO extends BaseDAO<RoleDTO> {

	List<RoleDTO> findRolesByUserId(Long id) throws Exception;

	void addRoleToUser(Long roleId, Long userId) throws Exception;

	void removeRoleFromUser(Long roleId, Long userId) throws Exception;

	RoleDTO findRoleByName(String name) throws Exception;
}
