package hu.neuron.java.service.converter;

import hu.neuron.java.persistence.dto.ResultDTO;
import hu.neuron.java.service.vo.ResultVO;

import java.util.ArrayList;
import java.util.List;

public class ResultConverter {

	public static ResultVO toVO(ResultDTO dto){
		if (dto == null) {
			return null;
		}
		ResultVO vo = new ResultVO();
		vo.setId(dto.getId());
		vo.setName(dto.getName());
		vo.setInitTime(dto.getInitTime());
		vo.setAccessTime(dto.getAccessTime());
		vo.setDeleteTime(dto.getDeleteTime());
		vo.setSortTime(dto.getSortTime());
		return vo;
	}
	
	public static List<ResultVO> toVO(List<ResultDTO> dtos){
		if (dtos == null) {
			return null;
		}
		List<ResultVO> vos = new ArrayList<>();
		for (ResultDTO dto : dtos) {
			vos.add(toVO(dto));
		}
		return vos;
	}
	
	public static ResultDTO toDTO(ResultVO vo){
		if (vo == null) {
			return null;
		}
		ResultDTO dto = new ResultDTO();
		dto.setId(vo.getId());
		dto.setName(vo.getName());
		dto.setInitTime(vo.getInitTime());
		dto.setAccessTime(vo.getAccessTime());
		dto.setDeleteTime(vo.getDeleteTime());
		dto.setSortTime(vo.getSortTime());
		return dto;
	}
	
	public static List<ResultDTO> toDTO(List<ResultVO> vos){
		if (vos == null) {
			return null;
		}
		List<ResultDTO> dtos = new ArrayList<>();
		for (ResultVO vo : vos) {
			dtos.add(toDTO(vo));
		}
		return dtos;
	}
	
	
}
