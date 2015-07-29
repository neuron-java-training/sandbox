package hu.neuron.java.service;

import java.util.List;

import hu.neuron.java.service.vo.RoleVO;
import hu.neuron.java.service.vo.UserVO;

public interface RoleServiceLocal {

	public UserVO setUpRoles(UserVO vo) throws Exception;

	public int getRowNumber();

	public List<RoleVO> getRoles();

	public RoleVO getRoleByName(String role);

	public void saveRole(RoleVO roleVO);

	public void updateRole(RoleVO roleVO);

	public void removeRole(RoleVO roleVO);

	public List<RoleVO> getRoles(int i, int pageSize, String sortField,
			int dir, String filter, String filterColumnName);

	public int getRoleCount();
}
