package hu.neuron.java.project.core;


import hu.neuron.java.project.core.db.RoleDAO;
import hu.neuron.java.project.core.db.UserDAO;
import hu.neuron.java.project.core.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateShema {


	@Autowired
	public RoleDAO roleDAO;
	
	@Autowired
	public UserDAO userDAO;

	public void insertRoles() {
		RoleVO rvo = null;
		try {
			if (roleDAO.findRoleByName("ROLE_USER") == null) {
				rvo = new RoleVO();
				rvo.setId(null);
				rvo.setName("ROLE_USER");
				roleDAO.save(rvo);
			}
			if (roleDAO.findRoleByName("ROLE_ADMIN") == null) {
				rvo = new RoleVO();
				rvo.setId(null);
				rvo.setName("ROLE_ADMIN");
				roleDAO.save(rvo);
			}	
		} catch (Exception e) {
			System.err.println("Nem sikerült a sémát létrehozni");
		}
	}

}
