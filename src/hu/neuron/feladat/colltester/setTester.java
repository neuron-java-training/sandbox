package hu.neuron.feladat.colltester;




import java.util.Set;
import java.util.TreeSet;

public class setTester implements SetTest {

	Set<Item> list =  new TreeSet<Item>();
	int size;
	long time1;
	long time2;
	long dif;
	
	
	public setTester(int size){
		
		this.size = size;
		System.out.println("TreeSet : ");
		
	}
	public setTester() {
		super();
		System.out.println("TreeSet : ");
	}

	
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}




	@Override
	public void init() {
		
		
		time1 = System.currentTimeMillis();
		
		for(int i = 0;i<size;++i){
			
			list.add(new Item(i));
			
		}
		
		time2 = System.currentTimeMillis();
		
		dif = time2-time1;
		
		System.out.println("Fill time : " + dif);

		
		
	}

	@Override
	public void delete(int s, int e) {
		
		time1 = System.currentTimeMillis();
		for (int i = s; i < e; i++) {
			
			list.remove(i);	
			
		}
		
		time2 = System.currentTimeMillis();
		
		dif = time2-time1;
		
		System.out.println("Remove time : "+dif);
	}
	
}
