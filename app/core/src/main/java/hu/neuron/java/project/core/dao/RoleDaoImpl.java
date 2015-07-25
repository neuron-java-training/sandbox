package hu.neuron.java.project.core.dao;

import hu.neuron.java.project.core.entity.Role;
import hu.neuron.java.project.core.entity.User;
import hu.neuron.java.project.core.vo.RoleVO;
import hu.neuron.java.project.core.vo.UserVO;

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
@Transactional(propagation=Propagation.SUPPORTS)
public class RoleDaoImpl extends BaseDaoImpl<Role, RoleVO> implements RoleDAO {

	@Autowired
	UserDAO userDAO;

	@Override
	public List<RoleVO> findRolesByUserId(Long id) throws Exception {
		TypedQuery<Role> createNamedQuery = entityManager.createNamedQuery(
				"findRolesByUserId", entityClass);
		createNamedQuery.setParameter("pUserId", id);
		List<Role> resultList = createNamedQuery.getResultList();

		List<RoleVO> rv = new ArrayList<>();
		for (Role e : resultList) {
			rv.add(toVo(e));
		}
		return rv;
	}

	@Override
	public void addRoleToUser(Long roleId, Long userId) throws Exception {

		BaseDAO<User,UserVO> baseConvertDao = (BaseDAO<User,UserVO>) userDAO;
		User user = baseConvertDao.findEntity(userId);
		Collection<Role> roles = user.getRoles();
		if(roles==null){
			roles = new ArrayList<Role>();	
		}
		roles.add(findEntity(roleId));
		user.setRoles(roles);
		baseConvertDao.saveEntity(user);
	}

	@Override
	public void removeRoleFromUser(Long roleId, Long userId) throws Exception {
		
	}

	@Override
	public RoleVO findRoleByName(String name) throws Exception {
		TypedQuery<Role> createNamedQuery = entityManager.createNamedQuery("findRoleByName",
				Role.class);
		createNamedQuery.setParameter("pName", name);

		Role r = null;
		try {
			r = createNamedQuery.getSingleResult();
		} catch (NoResultException e) {

		}

		return toVo(r);
	}
	
	@Override
	public Role toEntity(RoleVO vo, Role entity) {
		Role ret = entity;
		if (vo.getId() == null || entity == null) {
			ret = new Role();

		}
		ret.setId(vo.getId());
		ret.setName(vo.getName());
		return ret;
	}
	
	@Override
	public RoleVO toVo(Role entity) {
		RoleVO ret = new RoleVO();
		if (entity == null) {
			return null;
		}
		ret.setName(entity.getName());
		ret.setId(entity.getId());

		return ret;
	}
}
