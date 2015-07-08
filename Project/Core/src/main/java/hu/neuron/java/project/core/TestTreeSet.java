package hu.neuron.java.project.core;

import hu.neuron.java.project.common.CollectionSInterface;

import java.util.ArrayList;
import java.util.TreeSet;

public class TestTreeSet implements CollectionSInterface<TreeSet<Integer>> {
	private TreeSet<Integer> datas = new TreeSet();
	private boolean initTrue = false;

	public TestTreeSet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		for (int j = 0, i = 0; j < 100; j++) {
			i = (int) (Math.random() * 100);
			datas.add(i);
		}
		initTrue = true;
	}

	@Override
	public void sorting() {
		// TODO Auto-generated method stub
		if (initTrue) {
			// System.out.println("This method is worthless here...");
		} else {
			System.out.println("Init not has been used. Plz use it first.");
		}
	}

	@Override
	public int getItem(int i) {
		// TODO Auto-generated method stub
		if (initTrue) {
			ArrayList<Integer> datasArray = new ArrayList(datas);
			return datasArray.get(i);
		} else {
			System.out.println("Init not has been used. Plz use it first.");
			return 0;
		}
	}

	@Override
	public void deleteItemsByRange(int i, int k) {
		if (initTrue) {
			// TODO Auto-generated method stub
			ArrayList<Integer> datasArray = new ArrayList(datas);
			if (datas.size() >= k) {
				for (; i <= k; k--) {
					datasArray.remove(k);
				}
			}
			datas = new TreeSet(datasArray);
		} else {
			System.out.println("Init not has been used. Plz use it first.");
		}
	}

	@Override
	public void duplicationClear() {
		// TODO Auto-generated method stub
		if (initTrue) {
			// System.out.println("This method is worthless here...");
		} else {
			System.out.println("Init not has been used. Plz use it first.");
		}
	}

	public TreeSet getDatas() {
		return datas;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return datas.size();
	}

}
