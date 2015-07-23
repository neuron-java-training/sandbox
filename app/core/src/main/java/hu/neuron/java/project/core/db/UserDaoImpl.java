package hu.neuron.java.project.core.db;

import hu.neuron.java.project.core.entity.User;
import hu.neuron.java.project.core.vo.UserVO;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDaoImpl extends BaseDaoImpl<User, UserVO> implements UserDAO {

	@Autowired
	private RoleDAO roleDao;

	@Override
	public User toEntity(UserVO vo, User entity) {
		User user = entity;
		if (vo.getId() == null || entity == null) {
			user = new User();
		}
		user.setId(vo.getId());
		user.setUserName(vo.getUserName());
		user.setPassword(vo.getPassword());
		return user;
	}

	@Override
	public UserVO toVo(User entity) {
		UserVO ret = new UserVO();
		if (entity == null) {
			return null;
		}
		ret.setId(entity.getId());
		ret.setUserName(entity.getUserName());
		ret.setPassword(entity.getPassword());

		return ret;
	}

	@Override
	public UserVO findUserByName(String name) throws Exception {
		User rv;
		try {
			Query query = entityManager.createNamedQuery("findUserByName",
					entityClass);
			query.setParameter("pName", name);

			rv = (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return toVo(rv);
	}

}
