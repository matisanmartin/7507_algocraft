package algocraft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Base;
import model.CampoBatalla;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import common.Constantes;
import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

@RunWith(JUnit4.class)
public class CampoBatallaTest {

	UnidadFactory factory;
	Unidad	unidad;
	
	@Before
	public void setUp() {
		CampoBatalla.DestruirInstancia();
		factory = new UnidadFactory();
	}
	
	@Test
	public void getInstanciaDeberiaRetornarNoNulo() throws PosicionInvalidaException, FueraDeRangoException {
		assertNotNull(CampoBatalla.getInstancia());
	}
	
	@Test
	public void testInstanciaDefecto() throws PosicionInvalidaException, FueraDeRangoException{
		assertEquals(Constantes.ANCHO_DEFECTO,CampoBatalla.getInstancia().getAncho());
		assertEquals(Constantes.ALTO_DEFECTO,CampoBatalla.getInstancia().getAlto());
	}
	
	@Test
	public void testSettersAltoYAncho() throws PosicionInvalidaException, FueraDeRangoException {
		
		CampoBatalla.getInstancia().setAlto(20);
		CampoBatalla.getInstancia().setAncho(25);
		
		assertEquals(25,CampoBatalla.getInstancia().getAncho());
		assertEquals(20,CampoBatalla.getInstancia().getAlto());
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void noEsPosiblePosicionarUnaUnidadDelMismoTipoSiLaPosicionEstaOcupadaPorOtra() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,10));
		assertEquals(0,CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		assertEquals(1,CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
		Unidad marine2 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,10));
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
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
	
	@Test
	public void alCrearseDebeTenerCuatroBases() throws PosicionInvalidaException, FueraDeRangoException{
		CampoBatalla campo = CampoBatalla.getInstancia();
		campo.setUpBases();
		//cantidad de bases
		assertEquals(4,campo.getEspacioTerrestre().getCantidadDeElementos());
		
		//base superior izquierda
		assertEquals(new Posicion(0, 0), ((Base)campo.getEspacioTerrestre().getEspacio().get(0)).getVolcan().get(0).getPosicion());
		assertEquals(new Posicion(0, 1), ((Base)campo.getEspacioTerrestre().getEspacio().get(0)).getCristales().get(0).getPosicion());
		assertEquals(new Posicion(0, 2), ((Base)campo.getEspacioTerrestre().getEspacio().get(0)).getCristales().get(1).getPosicion());
		assertEquals(new Posicion(0, 3), ((Base)campo.getEspacioTerrestre().getEspacio().get(0)).getCristales().get(2).getPosicion());
		assertEquals(new Posicion(1, 0), ((Base)campo.getEspacioTerrestre().getEspacio().get(0)).getCristales().get(3).getPosicion());
		assertEquals(new Posicion(2, 0), ((Base)campo.getEspacioTerrestre().getEspacio().get(0)).getCristales().get(4).getPosicion());
		assertEquals(new Posicion(3, 0), ((Base)campo.getEspacioTerrestre().getEspacio().get(0)).getCristales().get(5).getPosicion());
		
		//base inferior izquierda
		assertEquals(new Posicion(Constantes.ALTO_DEFECTO, Constantes.POS_INICIAL_CAMPO_BATALLA), ((Base)campo.getEspacioTerrestre().getEspacio().get(1)).getVolcan().get(0).getPosicion());
		assertEquals(new Posicion(Constantes.ALTO_DEFECTO-3, Constantes.POS_INICIAL_CAMPO_BATALLA), ((Base)campo.getEspacioTerrestre().getEspacio().get(1)).getCristales().get(0).getPosicion());
		assertEquals(new Posicion(Constantes.ALTO_DEFECTO-2, Constantes.POS_INICIAL_CAMPO_BATALLA), ((Base)campo.getEspacioTerrestre().getEspacio().get(1)).getCristales().get(1).getPosicion());
		assertEquals(new Posicion(Constantes.ALTO_DEFECTO-1, Constantes.POS_INICIAL_CAMPO_BATALLA), ((Base)campo.getEspacioTerrestre().getEspacio().get(1)).getCristales().get(2).getPosicion());
		
		assertEquals(new Posicion(Constantes.ALTO_DEFECTO, Constantes.POS_INICIAL_CAMPO_BATALLA+1), ((Base)campo.getEspacioTerrestre().getEspacio().get(1)).getCristales().get(3).getPosicion());
		assertEquals(new Posicion(Constantes.ALTO_DEFECTO, Constantes.POS_INICIAL_CAMPO_BATALLA+2), ((Base)campo.getEspacioTerrestre().getEspacio().get(1)).getCristales().get(4).getPosicion());
		assertEquals(new Posicion(Constantes.ALTO_DEFECTO, Constantes.POS_INICIAL_CAMPO_BATALLA+3), ((Base)campo.getEspacioTerrestre().getEspacio().get(1)).getCristales().get(5).getPosicion());
				
		
	}
	


	
	
	

}

