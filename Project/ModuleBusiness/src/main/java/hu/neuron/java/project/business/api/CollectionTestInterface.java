package hu.neuron.java.project.business.api;

import java.util.Collection;

public interface CollectionTestInterface<T extends Collection> {
	
	void init();

	void sorting();

	int findItem(int i);

	void deleteItemsByRange(int i, int k);

	void duplicationClear();

}
