package hu.neuron.java.service.webservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://hu.neuron")
public interface TaskWebService {

	@WebMethod(operationName = "generate")
	@WebResult(name = "generate")
	public void generate(int i);

}
