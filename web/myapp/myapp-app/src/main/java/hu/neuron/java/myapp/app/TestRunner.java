package hu.neuron.java.myapp.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TestRunner implements Test<Collection<Items>> {
	protected static final int TESTSNUMBER = 5;
	protected static final long INITNUMBER = 3000000;
	private static List<TestResults> testresults = new ArrayList<>();

	@Override
	public void order() {
		Collections.sort(getTestresults(), new Comparator<TestResults>() {

			@Override
			public int compare(TestResults o1, TestResults o2) {

				int cmp = o1.getInitTime() - o2.getInitTime();
				return cmp;
			}
		});

	}

	@Override
	public void getElement(String index) {
		for (int i = 0; i < getTestresults().size(); i++) {
			if (getTestresults().get(i).getClazzName().equals(index)) {
				System.out.println(getTestresults().get(i));
			}
		}
	}

	@Override
	public void delete(int a, int b) {
		for (int i = a; i <= b; i++) {
			getTestresults().remove(i);
		}
	}

	@Override
	public void init(Collection<Items> t) {
		Random rand = new Random();
		for (int i = 0; i < INITNUMBER; i++) {
			int values = rand.nextInt();
			Items item = new Items(values);
			t.add(item);
		}
	}

	public void isBest() {
		order();
		System.out.println(getTestresults().get(0));

	}

	public static List<TestResults> getTestresults() {
		return testresults;
	}

	public static void setTestresults(List<TestResults> testresults) {
		TestRunner.testresults = testresults;
	}

}
