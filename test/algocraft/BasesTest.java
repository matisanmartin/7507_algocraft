package algocraft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import jugador.Jugador;
import model.BaseSupIzq;
import model.CampoBatalla;
import model.Elemento;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import recursos.Cristal;
import recursos.Volcan;
import vista.VentanaMock;
import common.Constantes;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.NombreCortoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;

public class BasesTest {
	
	@Before
	public void setUp() throws FueraDeRangoException, PosicionInvalidaException, NombreCortoException, NombreJugadorRepetidoException{
		Juego.crearInstancia(new VentanaMock());
		Juego.getInstancia().setJugadorActual(new Jugador("pepe","rojo","terran"));
		Juego.getInstancia().setJugadorEnemigo(new Jugador("pepito","azul","protoss"));
		
	}
	@After
	public void destroy(){
		CampoBatalla.DestruirInstancia();
		Juego.destruirInstancia();
	}

	@Test
	public void crearCristalYVolcanDeberianSerNoNull() throws FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException {
		Cristal cristal = new Cristal(2,2,new Posicion(2, 2));
		Volcan volcan = new Volcan(5,5,new Posicion(3, 3));
		assertNotNull(cristal);
		assertNotNull(volcan);
	}
	
	@Test
	public void unaBaseTieneUnVolcanYSeisCristales() throws FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException{
		BaseSupIzq base = new BaseSupIzq(new Posicion(2,2));
		assertEquals(1,base.getVolcan().size());
		assertEquals(6,base.getCristales().size());
	}

	
	@Test
	public void crearBaseSuperiorIzquierdaEn31() throws FueraDeRangoException, PosicionInvalidaException, ElementoInvalidoException, RecursosInsuficientesException, PoblacionFaltanteException, CostoInvalidoException{

		CampoBatalla.getInstancia().setUpBases();
		List<Elemento> base = CampoBatalla.getInstancia().getEspacioTerrestre().getEspacio();
		assertEquals(26, base.size());//se pone 26 ya que el setup crea todas las bases
		
		assertEquals(new Posicion(1,41), base.get(1).getPosicion());
		assertEquals(new Posicion(41,1), base.get(2).getPosicion());
		assertEquals(new Posicion(1,81), base.get(3).getPosicion());
	
		assertEquals(new Posicion(81,1), base.get(4).getPosicion());
		assertEquals(new Posicion(1,121), base.get(5).getPosicion());
		assertEquals(new Posicion(121,1), base.get(6).getPosicion());
		
	}
	
	/*
	 * al crear una base superior derecha en (1, max columnas) deberia estar el volcan en (1,max columna)
	 * y los cristatales en :
	 * (1, max col - 3) (1,max col - 2), (1, max col -1) / (max col, 2) (max col, 3) (max col, 4)
	 */
	@Test
	public void crearBaseSuperiorDerechaEnX1Y800() throws FueraDeRangoException, PosicionInvalidaException, ElementoInvalidoException, RecursosInsuficientesException, PoblacionFaltanteException, CostoInvalidoException, NombreCortoException{
		
		
		CampoBatalla.getInstancia().setUpBases();
		List<Elemento> base = CampoBatalla.getInstancia().getEspacioTerrestre().getEspacio();
		assertEquals(26, base.size());
		assertEquals(new Posicion(920,1), base.get(7).getPosicion());
		assertEquals(new Posicion(880,1), base.get(8).getPosicion());
		assertEquals(new Posicion(840,1), base.get(9).getPosicion());
		assertEquals(new Posicion(960,41), base.get(10).getPosicion());
		assertEquals(new Posicion(960,81), base.get(11).getPosicion());
		assertEquals(new Posicion(960,121), base.get(12).getPosicion());
		assertEquals(new Posicion(1,520), base.get(13).getPosicion());
		
	}

	@Test 
	public void creaVolcanEnBordeInferiorIzquierdoDelCampoBatalla() throws FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException{
		Volcan volcan = new Volcan(1, 1, new Posicion(Constantes.ALTO_DEFECTO, 0));
		assertEquals(new Posicion(Constantes.ALTO_DEFECTO, 0), volcan.getPosicion());
	}
	
	@Test
	public void volcanTieneAltoPorAnchoDePartes() throws FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException{
		Volcan volcan = new Volcan(65, 65, new Posicion(50, 50));
		assertEquals(4225, volcan.getPartes().size());
		
	}
	
}
