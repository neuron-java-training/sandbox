package hu.neuron.java.web.controllers.admin;

import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.facade.UserFacadeLocal;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "adminBean")
public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private LazyUserModel userModel;

	@EJB(beanName = "UserFacade")
	private UserFacadeLocal userFacade;

	@PostConstruct
	public void init() {
		userModel = new LazyUserModel(getUserFacade());
	}

	public LazyUserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(LazyUserModel userModel) {
		this.userModel = userModel;
	}

	public UserFacadeLocal getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacadeLocal userFacade) {
		this.userFacade = userFacade;
	}

}
