package hu.neuron.java.core;

import hu.neuron.java.core.dao.RoleDao;
import hu.neuron.java.core.entity.Role;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateShema {
	private static final Logger logger = Logger.getLogger(CreateShema.class);

	@Autowired
	public RoleDao roleDAO;

	public void insertRoles() {
		Role dto = null;
		try {
			if (roleDAO.findRoleByName("ROLE_USER") == null) {
				dto = new Role();
				dto.setName("ROLE_USER");
				roleDAO.save(dto);
			}
			if (roleDAO.findRoleByName("ROLE_ADMIN") == null) {
				dto = new Role();
				dto.setName("ROLE_ADMIN");
				roleDAO.save(dto);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
