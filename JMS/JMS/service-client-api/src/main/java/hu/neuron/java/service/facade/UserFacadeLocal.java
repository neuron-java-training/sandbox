package hu.neuron.java.service.facade;

import java.util.List;

import hu.neuron.java.service.vo.RoleVO;
import hu.neuron.java.service.vo.UserVO;

public interface UserFacadeLocal {

	public UserVO findUserAndRolesByName(String name) throws Exception;

	public void registrationUser(UserVO userVO) throws Exception;

	public UserVO findUserByName(String name) throws Exception;

	public List<UserVO> getUserList(int i, int pageSize, String sortField,
			int dir, String filter, String filterColumnName);

	public RoleVO getRoleByName(String role);

	public void saveUser(UserVO selectedUser);

	public UserVO setUpRoles(UserVO vo) throws Exception;

	public int getRowNumber();

	public List<RoleVO> getRoles();

	public void saveRole(RoleVO roleVO);

	public void updateRole(RoleVO roleVO);

	public void removeRole(RoleVO roleVO);

	public List<RoleVO> getRoles(int i, int pageSize, String sortField,
			int dir, String filter, String filterColumnName);

	public int getRoleCount();
}