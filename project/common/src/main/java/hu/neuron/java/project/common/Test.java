package hu.neuron.java.project.common;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Test<E extends Collection<?>> {

	void init(E e);

	void order();

	void getElement(String a);

	void delete(int a, int b);

	void TimeCounter();

}
