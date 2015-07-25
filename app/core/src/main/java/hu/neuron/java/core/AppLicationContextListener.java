package hu.neuron.java.core;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

@Startup
@Singleton
public class AppLicationContextListener {

	Logger logger = Logger.getLogger(AppLicationContextListener.class);

	@EJB
	CreateShema createShema;

	@PostConstruct
	public void init() {
		logger.info("start");
		System.out.println("start");
		try {
			createShema.insertRoles();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	};
}