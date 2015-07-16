package hu.neuron.java.project.persistent.impl;

import hu.neuron.java.project.persistens.DataVO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DataDaoImplTest
{
	
	@Autowired
	DataDaoImpl dataDaoImpl;
	
	@Autowired
	DataVO dataVO;
	
	@Autowired
	Long id;

	@Test
	public void testSave()
	{
		dataDaoImpl.save(dataVO);
	}

	@Test
	public void testUpdate()
	{
		dataDaoImpl.update(dataVO);
	}

	@Test
	public void testDelete()
	{
		dataDaoImpl.delete(id);
	}

	@Test
	public void testFindById()
	{
		dataDaoImpl.findById(id);
	}

	@Test
	public void testFindAll()
	{
		dataDaoImpl.findAll();
	}

}
