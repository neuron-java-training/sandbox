package app;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import app.collection_element.CollectionElement;
import app.collection_element.CollectionElementFactory;

public class CollectionElementTest {

	
	@Test
	public void equalsWithItself(){
		CollectionElement ce = new CollectionElement();
		assert(ce.equals(ce));
	}
	

	@Test
	public void equalsWithNull(){
		CollectionElement ce = new CollectionElement();
		assertFalse(ce.equals(null));
	}
	
	@Test
	public void equalsWithOtherClass(){
		CollectionElement ce = new CollectionElement();
		CollectionElementFactory cef = new CollectionElementFactory();
		assertFalse(ce.equals(cef));
	}
	
	@Test
	public void equalsWithNullValue(){
		CollectionElement ce = new CollectionElement();
		CollectionElement ce2 = new CollectionElementFactory().getRandomCollectionElement();
		ce2.setId(ce.getId());
		assertFalse(ce.equals(ce2));
	}
	
	@Test
	public void equalsWithNullValue2(){
		CollectionElement ce = new CollectionElementFactory().getRandomCollectionElement();
		CollectionElement ce2 =new CollectionElement();
		ce.setValue(null);
		ce2.setId(ce.getId());
		ce2.setValue("test");
		assertFalse(ce.equals(ce2));
	}
	
	@Test
	public void equalsWithValue(){
		CollectionElement ce = new CollectionElementFactory().getRandomCollectionElement();
		CollectionElement ce2 =new CollectionElement();
		ce2.setId(ce.getId());
		ce2.setValue("test");
		assertFalse(ce.equals(ce2));
	}
}
