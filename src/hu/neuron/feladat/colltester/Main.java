package hu.neuron.feladat.colltester;




public class Main {
	
	public static void main(String[] args){
		
	
		ArrayTester arraytester = new ArrayTester(100000);
		
		
		arraytester.init();
		arraytester.sort();
		arraytester.getRand(5000);
		arraytester.delete(10, 10000);
		
		
		LinkedTester linkedtester = new LinkedTester(100000);
		
		
		linkedtester.init();
		linkedtester.sort();
		linkedtester.getRand(5000);
		linkedtester.delete(10, 10000);
	
	
	
		setTester set = new setTester();
		
		set.init();
		set.delete(10, 10000);
	
		
	}
}
