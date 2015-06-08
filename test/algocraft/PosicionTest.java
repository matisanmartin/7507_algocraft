package algocraft;

import static org.junit.Assert.*;

import org.junit.Test;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class PosicionTest {

	@Test
	public void dosPosicionesSonIgualesSiTieneLaMismaCoordenaXeY() throws FueraDeRangoException {
		Posicion pos1 = new Posicion(1, 1);
		Posicion pos2 = new Posicion(1,1);
		assertEquals(pos1,pos2);
	}

	@Test
	public void dosPosicionNoSonIgualesSiNoTienenLaMismaCoordenada() throws FueraDeRangoException{
		Posicion pos1 = new Posicion(1, 1);
		Posicion pos2 = new Posicion(1,2);
		assertNotEquals(pos1, pos2);
	}
}
