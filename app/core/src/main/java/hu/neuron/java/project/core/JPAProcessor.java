package hu.neuron.java.project.core;

import hu.neuron.java.project.core.db.TestResultDAO;
import hu.neuron.java.project.core.vo.TestResultVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JPAProcessor {

	@Autowired
	private TestResultDAO dao;

	public JPAProcessor() {
	}

	public List<WebVO> generateVOs() {

		LinkedList<String> names = new LinkedList<>();
		List<TestResultVO> data = null;

		data = dao.readAll();

		for (TestResultVO trv : data) {
			if (!names.contains(trv.getClassName())) {
				names.add(trv.getClassName());
			}
		}

		HashMap<String, List<TestResultVO>> resultGroups = new HashMap<>();

		for (String name : names) {
			resultGroups.put(name, new LinkedList<TestResultVO>());
		}

		for (TestResultVO trv : data) {
			List<TestResultVO> list = resultGroups.get(trv.getClassName());
			list.add(trv);
		}

		LinkedList<AverageResult> averages = new LinkedList<>();

		for (List<TestResultVO> l : resultGroups.values()) {
			AverageResult ar = new AverageResult();
			ar.setCollectionName(l.get(0).getClassName());
			for (TestResultVO tr : l) {
				ar.addAccessTime(tr.getAccessTime());
				ar.addDeletionTime(tr.getDeletionTime());
				ar.addDuplicateEliminationTime(tr.getDuplicateTime());
				ar.addFillTime(tr.getFillTime());
				ar.addInitTime(tr.getInitTime());
				ar.addSortTime(tr.getSortTime());
			}
			averages.add(ar);
		}

		Collections.sort(averages);

		List<WebVO> list = new ArrayList<>();
		for (AverageResult ar : averages) {
			WebVO vo = new WebVO();
			vo.setClassName(ar.getCollectionName());
			vo.setN(ar.getN());
			vo.setAccessTime(ar.getAverageAccessTime() / TestResult.VIEWRATIO);
			vo.setDeletionTime(ar.getAverageDeletionTime() / TestResult.VIEWRATIO);
			vo.setDuplicateTime(ar.getAverageDuplicateEliminationTime() / TestResult.VIEWRATIO);
			vo.setFillTime(ar.getAverageFillTime() / TestResult.VIEWRATIO);
			vo.setInitTime(ar.getAverageInitTime() / TestResult.VIEWRATIO);
			vo.setSortTime(ar.getAverageSortTime() / TestResult.VIEWRATIO);
			list.add(vo);
		}
		return list;

	}
}
