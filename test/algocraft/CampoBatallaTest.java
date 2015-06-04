package algocraft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.CampoBatalla;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import common.Constantes;

import factory.unidades.UnidadFactory;

@RunWith(JUnit4.class)
public class CampoBatallaTest {

	UnidadFactory factory;
	
	@Before
	public void setUp() {
	
	}
	
	@Test
	public void getInstanciaDeberiaRetornarNoNulo() {
		assertNotNull(CampoBatalla.getInstancia());
	}
	
	@Test
	public void testInstanciaDefecto(){
		assertEquals(Constantes.ANCHO_DEFECTO,CampoBatalla.getInstancia().getAncho());
		assertEquals(Constantes.ALTO_DEFECTO,CampoBatalla.getInstancia().getAlto());
	}
	
	@Test
	public void testSettersAltoYAncho() {
		
		CampoBatalla.getInstancia().setAlto(20);
		CampoBatalla.getInstancia().setAncho(25);
		
		assertEquals(25,CampoBatalla.getInstancia().getAncho());
		assertEquals(20,CampoBatalla.getInstancia().getAlto());
	}
	
	//TODO msma: Comente este test temporalmente
//	@Test
//	public void testPosicionarMarine() {
//		
//		CampoBatalla.getInstancia().agregarElemento(factory.getUnidad(TipoUnidad.TERRAN_MARINE));
//		
//		List<Elemento> elementos = CampoBatalla.getInstancia().getElementos();
//		
//		Marine marine = (Marine) elementos.get(0);
//		
//		assertEquals(Constantes.UNIDAD_MARINE_VIDA, marine.getVida());
//
//	}
	
	
	
	

}

