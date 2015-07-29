package hu.neuron.java.service.converter;

import hu.neuron.java.core.entity.Role;
import hu.neuron.java.service.vo.RoleVO;

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
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
	private static final Logger logger = Logger.getLogger(RoleConverter.class);
	@Autowired
	@Qualifier("mapper")
	Mapper mapper;

	@PostConstruct
	void init() {

		logger.debug("RoleConverter init");
	}

	public RoleVO toVO(Role dto) {
		if (dto == null) {
			return null;
		}
		return mapper.map(dto, RoleVO.class);
	}

	public Role toEntity(RoleVO vo) {
		if (vo == null) {
			return null;
		}
		return mapper.map(vo, Role.class);
	}

	public List<RoleVO> toVO(List<Role> dtos) {
		if (dtos == null) {
			return null;
		}
		List<RoleVO> vos = new ArrayList<RoleVO>();
		for (Role dto : dtos) {
			vos.add(toVO(dto));
		}
		return vos;
	}

	public List<Role> toEntity(List<RoleVO> vos) {
		if (vos == null) {
			return null;
		}
		List<Role> dtos = new ArrayList<Role>();
		for (RoleVO vo : vos) {
			dtos.add(toEntity(vo));
		}
		return dtos;
	}

}
