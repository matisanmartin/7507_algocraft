package algocraft;

import static org.junit.Assert.*;
import model.Parte;

import org.junit.Test;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class ParteTest {

	@Test
	public void deberiaCrearseNoNull() throws FueraDeRangoException {
		Parte parte = new Parte(new Posicion(1, 1));
		assertNotNull(parte);
	}
	
	@Test
	public void deberiaTenerUnaPosicion() throws FueraDeRangoException{
		Parte parte = new Parte(new Posicion(3, 2));
		assertEquals(new Posicion(3, 2),parte.getPosicion());
	}

	@Test
	public void noDeberiaTenerUnaPosicionDistintaALaCreada() throws FueraDeRangoException{
		
		Parte parte = new Parte(new Posicion(2, 3));
		assertNotEquals(new Posicion(1, 1), parte.getPosicion());
	}
}
