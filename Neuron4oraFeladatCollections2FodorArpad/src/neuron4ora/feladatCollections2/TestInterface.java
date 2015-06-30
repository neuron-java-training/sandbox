package neuron4ora.feladatCollections2;

import java.util.Collection;

public interface TestInterface<T extends Collection> {
	void init();
	void sorting();
	int getItem(int i);
	void deleteItemsByRange(int i,int k);
	void duplicationClear();
	T getDatas();
	int getSize();
}
