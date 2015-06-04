package algocraft;

import static org.junit.Assert.*;
import model.Cristal;
import model.Volcan;

import org.junit.Test;

import controller.Posicion;
import exceptions.FueraDeRangoException;
import factory.construcciones.CentroDeMineral;
import factory.construcciones.Refineria;

public class ConstruccionesDeRecursosTest {

	@Test
	public void seCreaNoNull() throws FueraDeRangoException {
		Cristal cristal = new Cristal(new Posicion(1, 1));
		CentroDeMineral centro = new CentroDeMineral(cristal);
		assertNotNull(centro);
	}
	
	@Test
	public void siSeCreaSobreUnCristalDeberiaTenerLaMismaPosicion() throws FueraDeRangoException{
		Cristal cristal = new Cristal(new Posicion(1, 1));
		CentroDeMineral centro = new CentroDeMineral(cristal);
		assertEquals(new Posicion(1,1), centro.getPosicion());
	}
	
	@Test
	public void seCreaUnaRefineriaSobreUnVolcan() throws FueraDeRangoException{
		Volcan volcan = new Volcan(new Posicion(1, 1));
		Refineria ref = new Refineria(volcan);
		assertEquals(ref.getPosicion(), volcan.getPosicion());
	}
	
	

}
