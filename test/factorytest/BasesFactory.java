package factorytest;

import static org.junit.Assert.*;
import model.Base;

import org.junit.Before;
import org.junit.Test;

import common.Posicion;
import exceptions.FueraDeRangoException;
import factory.BaseFactory;

public class BasesFactory {
	
	BaseFactory factory;
	Base base;
	
	@Before
	public void setUp(){
		factory = new BaseFactory();
	}

	@Test
	public void creaUnaBase() throws FueraDeRangoException {
		base = factory.getBase(new Posicion(1, 1));
		assertEquals(1, base.getVolcan().size());
		assertEquals(6,base.getCristales().size());
		
	}

}
