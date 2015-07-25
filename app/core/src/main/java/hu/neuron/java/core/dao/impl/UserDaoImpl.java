package hu.neuron.java.core.dao.impl;

import hu.neuron.java.common.dao.BaseEntityInterface;
import hu.neuron.java.common.dao.RoleDaoLocal;
import hu.neuron.java.common.dao.UserDaoLocal;
import hu.neuron.java.common.dao.UserDaoRemote;
import hu.neuron.java.common.dto.RoleDTO;
import hu.neuron.java.common.dto.UserDTO;
import hu.neuron.java.core.entity.Role;
import hu.neuron.java.core.entity.User;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
@Local(UserDaoLocal.class)
@Remote(UserDaoRemote.class)
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class UserDaoImpl extends BaseDaoImpl<User, UserDTO> implements
		UserDaoLocal, UserDaoRemote {

	@EJB
	private RoleDaoLocal roleDao;

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User toEntity(UserDTO dto, BaseEntityInterface entity) {
		User ret = (User) entity;
		if (dto.getId() == null || entity == null) {
			ret = new User();
			ret.setId(dto.getId());

		}
		if (dto.getRoles() != null) {
			List<Role> vos = new ArrayList<Role>();
			for (RoleDTO role : dto.getRoles()) {
				vos.add((Role) roleDao.toEntity(role, null));
			}
			ret.setRoles(vos);
		}
		ret.setId(dto.getId());
		ret.setUserName(dto.getUserName());
		ret.setPassword(dto.getPassword());

		return ret;
	}

	@Override
	public UserDTO toDto(BaseEntityInterface entity) {
		UserDTO ret = new UserDTO();
		if (entity == null) {
			return null;
		}

		if (((User) entity).getRoles() != null) {
			List<RoleDTO> vos = new ArrayList<RoleDTO>();
			for (Role role : ((User) entity).getRoles()) {
				vos.add(roleDao.toDto(role));
			}
			ret.setRoles(vos);
		}

		ret.setId(entity.getId());
		ret.setUserName(((User) entity).getUserName());
		ret.setPassword(((User) entity).getPassword());

		return ret;
	}

	@Override
	public UserDTO findUserByName(String name) throws Exception {
		User rv;
		try {
			Query query = entityManager.createNamedQuery("findUserByName",
					entityClass);
			query.setParameter("pName", name);

			rv = (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return toDto(rv);
	}

}
