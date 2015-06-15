package algocraft;

import static org.junit.Assert.*;
import model.Base;
import model.BaseInfDer;
import model.BaseInfIzq;
import model.BaseSupDer;
import model.BaseSupIzq;

import org.junit.Test;

import recursos.Cristal;
import recursos.Volcan;
import common.Constantes;
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
		BaseSupIzq base = new BaseSupIzq(new Posicion(2,2));
		assertEquals(1,base.getVolcan().size());
		assertEquals(6,base.getCristales().size());
	}

	/*
	 * al crear una base superior izquierda en (1,1), deberia haber un volcan en (1,1) y los cristales en 
	 * (1,2)(1,3),(1,4) / (2,1)(3,1),(4,1)
	 */
	@Test
	public void crearBaseSuperiorIzquierda() throws FueraDeRangoException{
		BaseSupIzq base = new BaseSupIzq(new Posicion(1,1));
		assertEquals(new Posicion(1,1),base.getVolcan().get(0).getPosicion());
		assertEquals(new Posicion(1,2), base.getCristales().get(0).getPosicion());
		assertEquals(new Posicion(1,3), base.getCristales().get(1).getPosicion());
		assertEquals(new Posicion(1,4), base.getCristales().get(2).getPosicion());
		
		assertEquals(new Posicion(2,1), base.getCristales().get(3).getPosicion());
		assertEquals(new Posicion(3,1), base.getCristales().get(4).getPosicion());
		assertEquals(new Posicion(4,1), base.getCristales().get(5).getPosicion());
		
	}
	
	@Test
	public void crearBaseSuperiorIzquierdaEn31() throws FueraDeRangoException{
		BaseSupIzq base = new BaseSupIzq(new Posicion(3,1));
		assertEquals(new Posicion(3,1),base.getVolcan().get(0).getPosicion());
		
		assertEquals(new Posicion(3,2), base.getCristales().get(0).getPosicion());
		assertEquals(new Posicion(3,3), base.getCristales().get(1).getPosicion());
		assertEquals(new Posicion(3,4), base.getCristales().get(2).getPosicion());
		
		assertEquals(new Posicion(4,1), base.getCristales().get(3).getPosicion());
		assertEquals(new Posicion(5,1), base.getCristales().get(4).getPosicion());
		assertEquals(new Posicion(6,1), base.getCristales().get(5).getPosicion());
		
	}
	
	/*
	 * al crear una base superior derecha en (1, max columnas) deberia estar el volcan en (1,max columna)
	 * y los cristatales en :
	 * (1, max col - 3) (1,max col - 2), (1, max col -1) / (max col, 2) (max col, 3) (max col, 4)
	 */
	@Test
	public void crearBaseSuperiorDerecha() throws FueraDeRangoException{
		BaseSupDer base = new BaseSupDer(new Posicion(3, 5));
		
		//volcan
		assertEquals(new Posicion(3, 5), base.getVolcan().get(0).getPosicion());
		
		//cristales
		assertEquals(new Posicion(3, 2), base.getCristales().get(0).getPosicion());
		assertEquals(new Posicion(3, 3), base.getCristales().get(1).getPosicion());
		assertEquals(new Posicion(3, 4), base.getCristales().get(2).getPosicion());
		
		assertEquals(new Posicion(4, 5), base.getCristales().get(3).getPosicion());
		assertEquals(new Posicion(5, 5), base.getCristales().get(4).getPosicion());
		assertEquals(new Posicion(6, 5), base.getCristales().get(5).getPosicion());
	}
	
	@Test
	public void crearBaseInfIzq() throws FueraDeRangoException{
		BaseInfIzq base = new BaseInfIzq(new Posicion(6, 3));
		
		//volcan
		assertEquals(new Posicion(6, 3), base.getVolcan().get(0).getPosicion());
		
		//cristales
		assertEquals(new Posicion(3, 3), base.getCristales().get(0).getPosicion());
		assertEquals(new Posicion(4, 3), base.getCristales().get(1).getPosicion());
		assertEquals(new Posicion(5, 3), base.getCristales().get(2).getPosicion());
		
		assertEquals(new Posicion(6, 4), base.getCristales().get(3).getPosicion());
		assertEquals(new Posicion(6, 5), base.getCristales().get(4).getPosicion());
		assertEquals(new Posicion(6, 6), base.getCristales().get(5).getPosicion());
	}
	
	@Test
	public void crearBaseInferiorDerecha() throws FueraDeRangoException{
		BaseInfDer base = new BaseInfDer(new Posicion(6, 7));
		
		//volcan 
		assertEquals(new Posicion(6, 7), base.getVolcan().get(0).getPosicion());
		
		//cristales 
		assertEquals(new Posicion(3, 7), base.getCristales().get(0).getPosicion());
		assertEquals(new Posicion(4, 7), base.getCristales().get(1).getPosicion());
		assertEquals(new Posicion(5, 7), base.getCristales().get(2).getPosicion());
		
		assertEquals(new Posicion(6, 4), base.getCristales().get(3).getPosicion());
		assertEquals(new Posicion(6, 5), base.getCristales().get(4).getPosicion());
		assertEquals(new Posicion(6, 6), base.getCristales().get(5).getPosicion());
		
		
		
	}
}
