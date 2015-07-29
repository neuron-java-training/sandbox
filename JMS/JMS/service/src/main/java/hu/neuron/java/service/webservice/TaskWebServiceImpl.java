package hu.neuron.java.service.webservice;

import hu.neruon.java.service.queue.TaskSenderRemote;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import javax.jws.WebService;

import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 * Session Bean implementation class UserServiceBean
 */
@Stateless(mappedName = "TaskWebService", name = "TaskWebServiceImpl")
@WebService(name = "TaskWebServicePort", serviceName = "TaskWebService", targetNamespace = "http://hu.neuron", endpointInterface = "hu.neuron.java.service.webservice.TaskWebService")
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class TaskWebServiceImpl implements TaskWebService {

	@EJB(mappedName = "TaskSender", name = "TaskSender")
	private TaskSenderRemote taskSenderRemote;

	@Override
	public void generate(int i) {

		try {
			taskSenderRemote.send(String.valueOf(i));
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
		}
	}
}
