package kollekcioteszter;

public abstract class Tester {

	protected final int NUMBER = 10000;
	protected final TestObject[] testData;
	
	public Tester(){
		
		int tenth = (int) (NUMBER / 10);
		
		testData = new TestObject[NUMBER];
		
		for(int i = 0; i < tenth * 9; i++){
			testData[i]= new TestObject();
		}
		
		for(int i = (tenth * 9); i <NUMBER; i++){
			testData[i]= new TestObject(testData[i - (tenth * 9)]);
		}	
	}

}
