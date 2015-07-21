package hu.neuron.java.project.business.impl;

import hu.neuron.java.project.business.api.CollectionTestInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CollectionTestImplArrayList implements CollectionTestInterface<ArrayList<Integer>> {
	private ArrayList<Integer> datas = new ArrayList<>();
	private boolean initTrue = false;

	public CollectionTestImplArrayList() {
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
			Collections.sort(datas);
		} else {
			System.out.println("Init not has been used. Plz use it first.");
		}
	}

	@Override
	public int findItem(int i) {
		// TODO Auto-generated method stub
		if (initTrue) {
			return datas.get(i);
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
			HashSet datasHash = new HashSet(datas);
			datas = new ArrayList(datasHash);
		} else {
			System.out.println("Init not has been used. Plz use it first.");
		}
	}

}
