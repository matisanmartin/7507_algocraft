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
	
	public void deberiaTenerUnaPosicion() throws FueraDeRangoException{
		Parte parte = new Parte(new Posicion(1, 1));
		assertEquals(new Posicion(1, 1),parte.getPosicion());
	}

}
