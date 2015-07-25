package hu.neuron.java.core;

import hu.neuron.java.common.dao.RoleDaoLocal;
import hu.neuron.java.common.dto.RoleDTO;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import org.apache.log4j.Logger;

@Stateless
@LocalBean
@TransactionAttribute
public class CreateShema {
	private static final Logger logger = Logger.getLogger(CreateShema.class);

	@EJB
	public RoleDaoLocal roleDAO;

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
