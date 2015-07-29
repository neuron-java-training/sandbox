package hu.neuron.java.service.converter;

import hu.neuron.java.core.entity.User;
import hu.neuron.java.service.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Singleton
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UserConverter {

	private static final Logger logger = Logger.getLogger(UserConverter.class);

	@Autowired
	@Qualifier("mapper")
	Mapper mapper;

	@PostConstruct
	void init() {

		logger.debug("UserConverter init");
	}

	public UserVO toVO(User dto) {
		if (dto == null) {
			return null;
		}
		return mapper.map(dto, UserVO.class);
	}

	public User toEntity(UserVO vo) {
		if (vo == null) {
			return null;
		}
		return mapper.map(vo, User.class);
	}

	public List<UserVO> toVO(List<User> dtos) {
		if (dtos == null) {
			return null;
		}
		List<UserVO> vos = new ArrayList<UserVO>();
		for (User dto : dtos) {
			vos.add(toVO(dto));
		}
		return vos;
	}

	public List<User> toEntity(List<UserVO> vos) {
		if (vos == null) {
			return null;
		}
		List<User> dtos = new ArrayList<User>();
		for (UserVO vo : vos) {
			dtos.add(toEntity(vo));
		}
		return dtos;
	}
}
