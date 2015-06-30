package collectionsComparation;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListTest <T extends List<ListItems>> implements Test {
	List<ListItems> list;

	@Override
	public void init(List<ListItems> t) {
		Random rand = new Random();
		for (int i = 0; i < TestRunner.db; i++) {
			int value = rand.nextInt();
			t.add(new ListItems(value));
		}
		list = t;
	}

	@Override
	public void order() {
		Collections.sort(list);
	}

	@Override
	public void getElement(int a) {
		for (int i = 0; i < a; i++) {
			list.get(a);
		}
	}

	@Override
	public void delete(int a, int b) {
		for(int i = a; i <= b; i++){
			list.remove(i);
		}	
	}
}
