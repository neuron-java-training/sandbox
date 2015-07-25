package hu.neuron.java.core.dao.impl;

import hu.neuron.java.common.dao.BaseEntityInterface;
import hu.neuron.java.common.dao.RoleDaoLocal;
import hu.neuron.java.common.dao.RoleDaoRemote;
import hu.neuron.java.common.dao.UserDaoLocal;
import hu.neuron.java.common.dto.RoleDTO;
import hu.neuron.java.common.dto.UserDTO;
import hu.neuron.java.core.entity.Role;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Stateless
@Local(RoleDaoLocal.class)
@Remote(RoleDaoRemote.class)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class RoleDaoImpl extends BaseDaoImpl<Role, RoleDTO> implements
		RoleDaoLocal, RoleDaoRemote {

	@EJB
	UserDaoLocal userDAO;

	public RoleDaoImpl() {
		super(Role.class);
	}

	@Override
	public Role toEntity(RoleDTO dto, BaseEntityInterface entity) {
		Role ret = (Role) entity;
		if (dto.getId() == null || entity == null) {
			ret = new Role();

		}
		ret.setId(dto.getId());
		ret.setName(dto.getName());
		return ret;
	}

	@Override
	public RoleDTO toDto(BaseEntityInterface entity) {
		RoleDTO ret = new RoleDTO();
		if (entity == null) {
			return null;
		}
		ret.setName(((Role) entity).getName());
		ret.setId(entity.getId());

		return ret;
	}

	@Override
	public List<RoleDTO> findRolesByUserId(Long id) throws Exception {
		TypedQuery<Role> createNamedQuery = entityManager.createNamedQuery(
				"findRolesByUserId", entityClass);
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
		UserDTO user = userDAO.find(userId);
		List<RoleDTO> roles = user.getRoles();
		if (roles == null) {
			roles = new ArrayList<RoleDTO>();
		}
		roles.add(find(roleId));
		user.setRoles(roles);
		userDAO.update(user);
	}

	@Override
	public void removeRoleFromUser(Long roleId, Long userId) throws Exception {

		UserDTO user = userDAO.find(userId);
		user.getRoles().remove(find(roleId));
		userDAO.save(user);

	}

	@Override
	public RoleDTO findRoleByName(String name) throws Exception {
		TypedQuery<Role> createNamedQuery = entityManager.createNamedQuery(
				"findRoleByName", entityClass);
		createNamedQuery.setParameter("pName", name);

		Role rv = null;
		try {
			rv = createNamedQuery.getSingleResult();
		} catch (NoResultException e) {

		}
		return toDto(rv);
	}

}
