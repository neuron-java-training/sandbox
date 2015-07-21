package hu.neuron.java.project.business.impl;

import hu.neuron.java.project.business.api.CollectionTestInterface;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CollectionTestImplLinkedList implements
		CollectionTestInterface<List<Map<String, Integer>>> {
	private List<Map<String, Integer>> datas = new LinkedList<Map<String, Integer>>();
	private boolean initTrue = false;

	public CollectionTestImplLinkedList() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		for (int j = 0, i = 0; j < 100; j++) {
			Map<String, Integer> row = new LinkedHashMap<String, Integer>();
			i = (int) (Math.random() * 100);
			row.put("N", i);
			datas.add(row);
		}
		initTrue = true;
	}

	@Override
	public void sorting() {
		// TODO Auto-generated method stub
		if (initTrue) {
			List<Map<String, Integer>> datasSorting = new LinkedList<Map<String, Integer>>();
			Map<String, Integer> row = new LinkedHashMap<String, Integer>();
			while (datas != null && !datas.isEmpty()) {
				int id = 0;
				row = datas.get(0);
				for (int i = 0; i < datas.size(); i++) {
					if (row.get("N") > (datas.get(i).get("N"))) {
						row = datas.get(i);
						id = i;
					}
				}
				datasSorting.add(row);
				datas.remove(id);
			}
			datas = datasSorting;
		} else {
			System.out.println("Init not has been used. Plz use it first.");
		}
	}

	@Override
	public int findItem(int i) {
		// TODO Auto-generated method stub
		if (initTrue) {
			return datas.get(i).get("N");
		} else {
			System.out.println("Init not has been used. Plz use it first.");
			return 0;
		}

	}

	@Override
	public void deleteItemsByRange(int i, int k) {
		// TODO Auto-generated method stub
		if (initTrue) {
			if (datas.size() >= k) {
				for (; i <= k; k--) {
					datas.remove(k);
				}
			}
		} else {
			System.out.println("Init not has been used. Plz use it first.");
		}
	}

	@Override
	public void duplicationClear() {
		// TODO Auto-generated method stub
		if (initTrue) {
			List<Map<String, Integer>> datasDuplication = new LinkedList<Map<String, Integer>>();
			Map<String, Integer> row = new LinkedHashMap<String, Integer>();
			while (datas != null && !datas.isEmpty()) {
				row = datas.get(0);
				for (int i = 0; i < datas.size(); i++) {
					if (row.get("N") == datas.get(i).get("N")) {
						datas.remove(i);
						i = -1;
					}
				}
				datasDuplication.add(row);
			}
			datas = datasDuplication;
		} else {
			System.out.println("Init not has been used. Plz use it first.");
		}
	}

	public List<Map<String, Integer>> getDatas() {
		return datas;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return datas.size();
	}
}
