package hu.neuron.java.service.webservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://hu.neuron")
public interface UserWebService {

	@WebMethod(operationName = "userList")
	@WebResult(name = "userList")
	public UserListWebServiceVo getUserList();

}
