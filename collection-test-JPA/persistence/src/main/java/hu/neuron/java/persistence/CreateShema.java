package hu.neuron.java.persistence;

import hu.neuron.java.persistence.dao.RoleDAO;
import hu.neuron.java.persistence.dto.RoleDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateShema {
	private static final Logger logger = Logger.getLogger(CreateShema.class);

	@Autowired
	public RoleDAO roleDAO;

	public void insertRoles() {
		RoleDTO dto = null;
		try {
			if (roleDAO.findRoleByName("ROLE_USER") == null) {
				dto = new RoleDTO(null, "ROLE_USER");
				roleDAO.save(dto);
			}
			if (roleDAO.findRoleByName("ROLE_ADMIN") == null) {
				dto = new RoleDTO(null, "ROLE_ADMIN");
				roleDAO.save(dto);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
