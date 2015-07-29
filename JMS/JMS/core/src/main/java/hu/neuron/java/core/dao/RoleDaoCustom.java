package hu.neuron.java.core.dao;

public interface RoleDaoCustom {

	void removeRoleFromUser(Long roleId, Long userId) throws Exception;

}
