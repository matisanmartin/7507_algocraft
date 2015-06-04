package algocraft;

import static org.junit.Assert.*;
import model.Base;
import model.BaseInferior;
import model.BaseSuperior;

import org.junit.Test;

import controller.Posicion;
import exceptions.FueraDeRangoException;

public class BaseTest {

	@Test
	public void unaBaseSuperiorEInferiorNoDeberianSerNullAlCrearse() throws FueraDeRangoException{
		Posicion pos = new Posicion(1, 1);
		Base baseSup = new BaseSuperior(pos);
		Base baseInf = new BaseInferior(pos);
		assertNotNull(baseSup);
		assertNotNull(baseInf);
	}
	
//	@Test
//	public void deberiaTenerPosX1Y1() throws FueraDeRangoException{
//		Posicion pos = new Posicion(1, 1);
//		Base base = new BaseSuperior(pos);
//		assertEquals(new Posicion(1,1),base.getPosicion());
//	}
//	
//	@Test
//	public void deberiaEstarCompuestaPor5Recursos() throws FueraDeRangoException{
//		Posicion pos = new Posicion(1, 1);
//		BaseSuperior base = new BaseSuperior(pos);
//		assertEquals(5, base.getRecursos().size());
//	}
	
	@Test
	public void deberiaTenerPosX1Y1() throws FueraDeRangoException{
		Posicion pos = new Posicion(1, 1);
		Base base = new Base(pos);
		assertEquals(new Posicion(1,1),base.getPosicion());
	}
	
	@Test
	public void deberiaEstarCompuestaPor5Recursos() throws FueraDeRangoException{
		Posicion pos = new Posicion(1, 1);
		Base base = new Base(pos);
		assertEquals(5, base.getRecursos().size());
	}

}
