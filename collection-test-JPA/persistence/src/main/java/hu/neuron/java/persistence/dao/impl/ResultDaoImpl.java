package hu.neuron.java.persistence.dao.impl;

import hu.neuron.java.persistence.dao.ResultDAO;
import hu.neuron.java.persistence.dto.ResultDTO;
import hu.neuron.java.persistence.entity.Result;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class ResultDaoImpl extends BaseDaoImpl<Result, ResultDTO> implements BaseConvertDao<Result, ResultDTO>, ResultDAO {
	
	@Override
	public List<ResultDTO> getAverages() throws Exception {
		TypedQuery<String> names = entityManager.createQuery("SELECT DISTINCT(r.name) FROM Result r", String.class);
		List<String> existingNames = names.getResultList();
		
		List<ResultDTO> rv = new ArrayList<>();
		for (String name : existingNames) {
			List<Result> partResult = entityManager.createNamedQuery("Result.findByName").setParameter("name", name).getResultList();
			
			int size = partResult.size();
			Long sumOfAccess = 0l;
			Long sumOfInit = 0l;
			Long sumOfDelete = 0l;
			Long sumOfSort = 0l;
			
			for (Result result : partResult) {
				sumOfAccess += result.getAccessTime();
				sumOfAccess += result.getAccessTime();
				sumOfInit += result.getInitTime();
				sumOfDelete += result.getDeleteTime();
				sumOfSort += result.getSortTime();
			}
			
			sumOfAccess /= size;
			sumOfInit /= size;
			sumOfDelete /= size;
			sumOfSort /= size;
			
			rv.add(new ResultDTO(null,name,sumOfInit.longValue(),sumOfAccess.longValue(),sumOfDelete.longValue(),sumOfSort.longValue()));
		}
		
		return rv;
	}

	@Override
	public Result toEntity(ResultDTO dto, Result entity) {
		Result ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new Result();

		}
		ret.setId(dto.getId());
		ret.setName(dto.getName());
		ret.setAccessTime(dto.getAccessTime());
		ret.setDeleteTime(dto.getDeleteTime());
		ret.setSortTime(dto.getSortTime());
		ret.setInitTime(dto.getInitTime());

		return ret;
	}

	@Override
	public ResultDTO toDto(Result entity) {
		ResultDTO ret = new ResultDTO();
		if (entity == null) {
			return null;
		}
		ret.setName(entity.getName());
		ret.setId(entity.getId());
		ret.setAccessTime(entity.getAccessTime());
		ret.setDeleteTime(entity.getDeleteTime());
		ret.setSortTime(entity.getSortTime());
		ret.setInitTime(entity.getInitTime());

		return ret;
	}


}
