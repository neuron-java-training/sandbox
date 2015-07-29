package hu.neuron.java.web.controllers;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequestScoped
@ManagedBean(name = "loginContoller")
public class LoginContoller {

	private String userName = null;
	private String password = null;

	@Autowired
	private AuthenticationManager authenticationManager = null;

	public String doLogin() throws IOException, ServletException {
		try {
			Authentication request = new UsernamePasswordAuthenticationToken(
					this.getUserName(), this.getPassword());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (BadCredentialsException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error!", "Bad Credentials"));
		}
		return null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}