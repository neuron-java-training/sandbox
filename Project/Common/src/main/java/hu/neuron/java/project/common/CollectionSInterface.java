package hu.neuron.java.project.common;

import java.util.Collection;

public interface CollectionSInterface<T extends Collection> {
	void init();

	void sorting();

	int getItem(int i);

	void deleteItemsByRange(int i, int k);

	void duplicationClear();

	T getDatas();

	int getSize();
}
