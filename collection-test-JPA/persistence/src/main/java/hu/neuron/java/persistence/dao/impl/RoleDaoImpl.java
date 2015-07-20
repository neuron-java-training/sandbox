package hu.neuron.java.persistence.dao.impl;


import hu.neuron.java.persistence.dao.RoleDAO;
import hu.neuron.java.persistence.dao.UserDAO;
import hu.neuron.java.persistence.dto.RoleDTO;
import hu.neuron.java.persistence.dto.UserDTO;
import hu.neuron.java.persistence.entity.Role;
import hu.neuron.java.persistence.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class RoleDaoImpl extends BaseDaoImpl<Role, RoleDTO> implements BaseConvertDao<Role, RoleDTO>, RoleDAO {
	@Autowired
	UserDAO userDAO;

	@Override
	public Role toEntity(RoleDTO dto, Role entity) {
		Role ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new Role();

		}
		ret.setId(dto.getId());
		ret.setName(dto.getName());
		return ret;
	}

	@Override
	public RoleDTO toDto(Role entity) {
		RoleDTO ret = new RoleDTO();
		if (entity == null) {
			return null;
		}
		ret.setName(entity.getName());
		ret.setId(entity.getId());

		return ret;
	}

	@Override
	public List<RoleDTO> findRolesByUserId(Long id) throws Exception {
		TypedQuery<Role> createNamedQuery = entityManager.createNamedQuery("findRolesByUserId", entityClass);
		createNamedQuery.setParameter("pUserId", id);
		List<Role> resultList = createNamedQuery.getResultList();

		List<RoleDTO> rv = new ArrayList<RoleDTO>();
		for (Role e : resultList) {
			rv.add(toDto(e));
		}
		return rv;

	}

	@Override
	public void addRoleToUser(Long roleId, Long userId) throws Exception {
		BaseConvertDao<User, UserDTO> baseConvertDao = (BaseConvertDao<User, UserDTO>) userDAO;
		User user = baseConvertDao.findEntity(userId);
		Collection<Role> roles = user.getRoles();
		if (roles == null) {
			roles = new ArrayList<Role>();
		}
		roles.add(findEntity(roleId));
		user.setRoles(roles);
		baseConvertDao.saveEntity(user);
	}

	@Override
	public void removeRoleFromUser(Long roleId, Long userId) throws Exception {
		BaseConvertDao<User, UserDTO> baseConvertDao = (BaseConvertDao<User, UserDTO>) userDAO;
		User user = baseConvertDao.findEntity(userId);
		user.getRoles().remove(findEntity(roleId));
		baseConvertDao.saveEntity(user);

	}

	@Override
	public RoleDTO findRoleByName(String name) throws Exception {
		TypedQuery<Role> createNamedQuery = entityManager.createNamedQuery("findRoleByName", entityClass);
		createNamedQuery.setParameter("pName", name);

		Role rv = null;
		try {
			rv = createNamedQuery.getSingleResult();
		} catch (NoResultException e) {

		}
		return toDto(rv);
	}

}
