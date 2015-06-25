package algocraft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Base;
import model.CampoBatalla;
import model.Elemento;
import model.Parte;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import common.Constantes;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

@RunWith(JUnit4.class)
public class CampoBatallaTest {

	UnidadFactory factory;
	Unidad	unidad;
	
	@Before
	public void setUp() {
		
		factory = new UnidadFactory();
	}
	
	@After
	public void destroy(){
		CampoBatalla.DestruirInstancia();
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
	public void noEsPosiblePosicionarUnaUnidadDelMismoTipoSiLaPosicionEstaOcupadaPorOtra() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException, UnidadLlenaException, DanioInvalidoException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,10));
		assertEquals(0,CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		assertEquals(1,CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
		Unidad marine2 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,10));
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
	}
	
	
	@Test
	public void alCrearseDebeTenerCuatroBases() throws PosicionInvalidaException, FueraDeRangoException, ElementoInvalidoException, RecursosInsuficientesException, PoblacionFaltanteException, CostoInvalidoException{
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
	
	@Test
	public void encuentraUnMarineEnElEspacioTerrestre() throws UnidadLlenaException, UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, DanioInvalidoException, PosicionInvalidaException{
		Unidad unidad1,unidad2,unidad3 = null;
		UnidadFactory factory = new UnidadFactory();
		unidad1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10, 10));
		unidad2 = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(35, 35));
		unidad3 = factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, new Posicion(50, 50));
		Parte partedeZealot = unidad3.getPartes().get(1);
		assertEquals(new Posicion(50, 51), partedeZealot.getPosicion() );
		assertEquals(0,CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
		
		
		CampoBatalla.getInstancia().getEspacioTerrestre().agregarElemento(unidad1);
		assertEquals(1,CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
		CampoBatalla.getInstancia().getEspacioTerrestre().agregarElemento(unidad2);
		CampoBatalla.getInstancia().getEspacioTerrestre().agregarElemento(unidad3);
		
		
//		Elemento elemento = CampoBatalla.getInstancia().getElementoDeParte(unidad3.getPartes().get(3).getPosicion());
		
	}
	


	
	
	

}

