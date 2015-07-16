package hu.neuron.java.project.business.impl;

import hu.neuron.java.project.business.DataBVO;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class BusinessOImplTest
{
	@Autowired
	BusinessOImpl businessOImpl;
	
	@Autowired
	DataBVO dataBVO;

	@Autowired
	Long id;

	@Test
	public void testSave()
	{
		businessOImpl.save(dataBVO);
	}

	@Test
	public void testUpdate()
	{
		businessOImpl.update(dataBVO);
	}

	@Test
	public void testDelete()
	{
		businessOImpl.delete(id);
	}

	@Test
	public void testFindById()
	{
		businessOImpl.findById(id);
	}

	@Test
	public void testFindAll()
	{
		businessOImpl.findAll();
	}

}
