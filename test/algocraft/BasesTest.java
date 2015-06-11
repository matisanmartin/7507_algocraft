package algocraft;

import static org.junit.Assert.*;
import model.Base;
import model.Volcan;

import org.junit.Test;

import common.Posicion;
import exceptions.FueraDeRangoException;

public class BasesTest {

	@Test
	public void crearCristalYVolcanDeberianSerNoNull() throws FueraDeRangoException {
		Cristal cristal = new Cristal(2,2,new Posicion(2, 2));
		Volcan volcan = new Volcan(5,5,new Posicion(3, 3));
		assertNotNull(cristal);
		assertNotNull(volcan);
	}
	
	@Test
	public void unaBaseTieneUnVolcanYSeisCristales() throws FueraDeRangoException{
		Base base = new Base(new Posicion(2,2));
		assertEquals(1,base.getVolcan().size());
		assertEquals(6,base.getCristales().size());
	}

}
