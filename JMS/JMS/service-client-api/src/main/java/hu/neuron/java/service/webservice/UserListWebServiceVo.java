package hu.neuron.java.service.webservice;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserList")
public class UserListWebServiceVo {

	@XmlElement(name = "users")
	private List<UserWebServiceVo> list;

	public List<UserWebServiceVo> getList() {
		return list;
	}

	public void setList(List<UserWebServiceVo> list) {
		this.list = list;
	}
}
