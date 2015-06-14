package integraciontest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;

import org.junit.Before;
import org.junit.Test;

import razas.Protoss;
import razas.Terran;
import strategy.Ataque;
import strategy.ContextoStrategy;

import common.Posicion;

import controller.JuegoController;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

/**
 * 
 * Unidades de tierra no pueden atacar unidades de aire y viceversa en todas las combinaciones,
 * cuando se corresponda
 *
 */
public class Enunciado3Test {

	Unidad unidadTerrestre;//marine
	Unidad unidadAerea;//scout
	UnidadFactory factory;
	Posicion posUnidadTerrestre;
	Posicion posUnidadAerea;
	ContextoStrategy contexto;
	Jugador jugadorActual;
	Jugador jugadorEnemigo;
	
	
	@Before
	public void setUp() throws Exception {
		
		jugadorActual = new Jugador("Jugador1",TipoColor.COLOR_ROJO,new Terran());
		jugadorEnemigo = new Jugador("Jugador2",TipoColor.COLOR_AZUL,new Protoss());
		
		contexto=new ContextoStrategy(new Ataque());
		factory=new UnidadFactory();
		
		posUnidadAerea = new Posicion(2,2);
		posUnidadTerrestre = new Posicion(3,3); 
		
		unidadTerrestre = factory.getUnidad(TipoUnidad.TERRAN_MARINE,posUnidadTerrestre);
		unidadTerrestre.setDaño("6");//TODO arreglar luego
		unidadTerrestre.setRangoAtaque("4");
		jugadorActual.agregarElemento(unidadTerrestre);
		
		unidadAerea = factory.getUnidad(TipoUnidad.PROTOSS_SCOUT,posUnidadAerea);
		unidadAerea.setDaño("14");//TODO arreglar luego
		unidadAerea.setRangoAtaque("4");
		jugadorEnemigo.agregarElemento(unidadAerea);
		
		JuegoController.getInstancia().setJugadorActual(jugadorActual);
		JuegoController.getInstancia().setJugadorEnemigo(jugadorEnemigo);
	}

	@Test
	public void testUnidadTerrestreNoPuedeAtacarUnidadAerea() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException {
		
		unidadTerrestre.realizarAccion(contexto, posUnidadAerea);
		assertEquals(150,unidadAerea.getVida());
	}
	
	@Test
	public void testUnidadAereaNoPuedeAtacarUnidadTerrestre() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, NombreJugadorRepetidoException {
		
		//intercambio el turno
		JuegoController.getInstancia().intercambiarJugadores();
		
		unidadAerea.realizarAccion(contexto, posUnidadTerrestre);
		assertEquals(40,unidadTerrestre.getVida());
		
	}

}
