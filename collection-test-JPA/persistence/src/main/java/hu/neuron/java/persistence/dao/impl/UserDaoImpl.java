package hu.neuron.java.persistence.dao.impl;

import hu.neuron.java.persistence.dao.RoleDAO;
import hu.neuron.java.persistence.dao.UserDAO;
import hu.neuron.java.persistence.dto.UserDTO;
import hu.neuron.java.persistence.entity.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDaoImpl extends BaseDaoImpl<User, UserDTO> implements BaseConvertDao<User, UserDTO>, UserDAO {

	@Autowired
	private RoleDAO roleDao;

	@Override
	public User toEntity(UserDTO dto, User entity) {
		User ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new User();
			ret.setId(dto.getId());

		}
		ret.setId(dto.getId());
		ret.setUserName(dto.getUserName());
		ret.setPassword(dto.getPassword());

		return ret;
	}

	@Override
	public UserDTO toDto(User entity) {
		UserDTO ret = new UserDTO();
		if (entity == null) {
			return null;
		}
		ret.setId(entity.getId());
		ret.setUserName(entity.getUserName());
		ret.setPassword(entity.getPassword());

		return ret;
	}

	@Override
	public UserDTO findUserByName(String name) throws Exception {
		User rv;
		try {
			Query query = entityManager.createNamedQuery("findUserByName", entityClass);
			query.setParameter("pName", name);

			rv = (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return toDto(rv);
	}

}
