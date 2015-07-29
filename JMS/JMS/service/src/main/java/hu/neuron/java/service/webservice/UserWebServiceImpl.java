package hu.neuron.java.service.webservice;

import hu.neuron.java.service.UserServiceLocal;
import hu.neuron.java.service.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

/**
 * Session Bean implementation class UserServiceBean
 */
@Stateless(mappedName = "UserWebService", name = "UserWebServiceImpl")
@WebService(name = "UserWebServicePort", serviceName = "UserWebService", targetNamespace = "http://hu.neuron", endpointInterface = "hu.neuron.java.service.webservice.UserWebService")
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UserWebServiceImpl implements UserWebService {
	@EJB
	UserServiceLocal serviceBeanLocal;

	@Autowired
	@Qualifier("mapper")
	Mapper mapper;

	public UserListWebServiceVo getUserList() {
		List<UserVO> userVOs = serviceBeanLocal.getUserList();
		UserListWebServiceVo rv = new UserListWebServiceVo();
		rv.setList(new ArrayList<UserWebServiceVo>());
		for (UserVO userVO : userVOs) {
			rv.getList().add(mapper.map(userVO, UserWebServiceVo.class));
		}
		return rv;
	}
}
