package hu.neuron.java.project.core.dao;

import hu.neuron.java.project.core.TestResult;
import hu.neuron.java.project.core.vo.TestResultVO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class TestResultDAOImpl implements TestResultDAO {

	@PersistenceContext()
	protected EntityManager entityManager;

	@Override
	public Long save(TestResult tr) {
		System.out.println("saving testResult for: "+tr.getCollectionName());
		entityManager.persist(tr);
		System.out.println("saved id: "+tr.getId());
		return tr.getId();
	}

	@Override
	public List<TestResultVO> readAll() {
		TypedQuery<TestResult> createNamedQuery = entityManager.createNamedQuery(
				"findAllTestResults", TestResult.class);
		List<TestResult> resultList = createNamedQuery.getResultList();
		ArrayList<TestResultVO> rl = new ArrayList<>(resultList.size());
		for(TestResult tr: resultList){
			rl.add(toVo(tr));
		}
		return rl;
	}
	
	private TestResultVO toVo(TestResult entity) {
		TestResultVO ret = new TestResultVO();
		if (entity == null) {
			return null;
		}
		ret.setClassName(entity.getCollectionName());
		ret.setId(entity.getId());
		ret.setAccessTime(entity.getAccessTime());
		ret.setDeletionTime(entity.getDeletionTime());
		ret.setDuplicateTime(entity.getDuplicateEliminationTime());
		ret.setFillTime(entity.getFillTime());
		ret.setInitTime(entity.getInitTime());
		ret.setSortTime(entity.getSortTime());

		return ret;
	}

}
