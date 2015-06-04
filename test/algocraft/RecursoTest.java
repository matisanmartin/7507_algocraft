package algocraft;

import static org.junit.Assert.*;
import model.Cristal;
import model.Recurso;
import model.Volcan;

import org.junit.Test;

import controller.Posicion;
import exceptions.FueraDeRangoException;

public class RecursoTest {

	@Test
	public void crearUnCristalDeberiaSerNoNull() throws FueraDeRangoException {
		Posicion pos = new Posicion(1, 1);
		Recurso cristal = new Cristal(pos);
		assertNotNull(cristal);
	}
	
	@Test
	public void crearUnVolcanDeberiaSerNoNull() throws FueraDeRangoException{
		Posicion pos = new Posicion(1, 1);
		Recurso volcan = new Volcan(pos);
		assertNotNull(volcan);
	}
	
	@Test
	public void hayUnCristalEnX1Y1YUnVolcanEnX1Y2() throws FueraDeRangoException{
		Posicion posCristal = new Posicion(1, 1);
		Posicion posVolcan = new Posicion(1, 2);
		Volcan volcan = new Volcan(posVolcan);
		Cristal cristal = new Cristal(posCristal);
		assertEquals(posVolcan,volcan.getPosicion());
		assertEquals(posCristal,cristal.getPosicion());
	}
	
	
	
	

}
