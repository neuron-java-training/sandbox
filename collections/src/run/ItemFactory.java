package run;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import item.ComparableItem;
import item.Item;

public class ItemFactory {
    //1_011_111
    //11111
	private static final int MAX_ITEMS = 500_00;
	public static Collection<ComparableItem> getItems() {
		List<ComparableItem> comparableItem = new ArrayList<>();
		for (int i = 0; i < MAX_ITEMS; i++) {
			Random rand = new Random();
			String tmp = String.valueOf(rand.nextInt());
			comparableItem.add(new ComparableItem(tmp, tmp));
		}
		return comparableItem;

	}
}
