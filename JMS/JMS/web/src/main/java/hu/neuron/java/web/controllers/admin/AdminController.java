package hu.neuron.java.web.controllers.admin;

import hu.neuron.java.service.RoleServiceLocal;
import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.facade.UserFacadeLocal;
import hu.neuron.java.service.vo.RoleVO;
import hu.neuron.java.service.vo.UserVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 * Controller for the admin site.
 */
@ViewScoped
@ManagedBean(name = "adminController")
public class AdminController implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The manage user facade service. */

	@EJB(beanName = "UserFacade")
	private UserFacadeLocal userFacade;

	/** The role. */
	private String role;

	/** The selected user. */
	private UserVO selectedUser;

	/** The selected role. */
	private RoleVO selectedRole;

	/** The user roles. */
	private Set<RoleVO> userRoles = new HashSet<>();

	/**
	 * Completes the text.
	 *
	 * @param query
	 *            the query
	 * @return the list
	 */
	public List<String> completeText(String query) {
		List<String> results = new ArrayList<String>();
		List<RoleVO> roles = new ArrayList<RoleVO>();
		roles = getUserFacade().getRoles();
		for (RoleVO role : roles) {
			if (role.getName().toLowerCase().contains(query.toLowerCase())) {
				results.add(role.getName());
			}
		}

		return results;
	}

	/**
	 * On row select.
	 *
	 * @param event
	 *            the event
	 */
	public void onRowSelect(SelectEvent event) {
		selectedUser = (UserVO) event.getObject();
		setUserRoles(new HashSet<>(selectedUser.getRoles()));
		FacesContext.getCurrentInstance().addMessage(
				"createmsgs",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						selectedUser.getUserName()));
	}

	/**
	 * Adds the role to user.
	 */
	public void addRoleToUser() {
		userRoles.add(getUserFacade().getRoleByName(role));
	}

	/**
	 * Update user.
	 */
	public void updateUser() {
		selectedUser.setRoles(new ArrayList<>(userRoles));
		getUserFacade().saveUser(selectedUser);
	}

	/**
	 * On row unselect.
	 *
	 * @param event
	 *            the event
	 */
	public void onRowUnselect(UnselectEvent event) {
		selectedUser = null;
	}

	/**
	 * Unselect.
	 */
	public void unselect() {
		selectedUser = null;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role
	 *            the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the user roles.
	 *
	 * @return the user roles
	 */
	public Set<RoleVO> getUserRoles() {
		return userRoles;
	}

	/**
	 * Sets the user roles.
	 *
	 * @param userRoles
	 *            the new user roles
	 */
	public void setUserRoles(Set<RoleVO> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * Gets the manage user facade service.
	 *
	 * @return the manage user facade service
	 */

	/**
	 * Sets the manage user facade service.
	 *
	 * @param manageUserFacadeService
	 *            the new manage user facade service
	 */

	/**
	 * Gets the selected user.
	 *
	 * @return the selected user
	 */
	public UserVO getSelectedUser() {
		return selectedUser;
	}

	/**
	 * Sets the selected user.
	 *
	 * @param selectedUser
	 *            the new selected user
	 */
	public void setSelectedUser(UserVO selectedUser) {
		this.selectedUser = selectedUser;
	}

	/**
	 * Gets the selected role.
	 *
	 * @return the selected role
	 */
	public RoleVO getSelectedRole() {
		return selectedRole;
	}

	/**
	 * Sets the selected role.
	 *
	 * @param selectedRole
	 *            the new selected role
	 */
	public void setSelectedRole(RoleVO selectedRole) {
		this.selectedRole = selectedRole;
	}

	/**
	 * On role row select.
	 *
	 * @param event
	 *            the event
	 */
	public void onRoleRowSelect(SelectEvent event) {
		selectedRole = (RoleVO) event.getObject();
		FacesMessage msg = new FacesMessage("User Role: ",
				selectedRole.getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * On role row unselect.
	 *
	 * @param event
	 *            the event
	 */
	public void onRoleRowUnselect(UnselectEvent event) {
		selectedRole = null;
	}

	/**
	 * Removes the role.
	 */
	public void removeRole() {
		userRoles.remove(selectedRole);
	}

	public UserFacadeLocal getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacadeLocal userFacade) {
		this.userFacade = userFacade;
	}

}
