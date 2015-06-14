package algocraft;

import static org.junit.Assert.assertEquals;
import juego.Juego;
import jugador.Jugador;
import jugador.TipoColor;
import model.CampoBatalla;
import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import razas.Protoss;
import razas.Terran;
import common.Posicion;
import common.Vitalidad;
import exceptions.ElementoInvalidoException;
import exceptions.FinDePartidaException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;

@RunWith(JUnit4.class)
public class JuegoControllerTest {

	Jugador jugadorActual;
	Jugador jugadorEnemigo;
	ElementoArtificial unidadMuerta;
	ElementoArtificial unidadNoMuerta;
	CampoBatalla campoDeBatalla;
	
	@Before
	public void setUp() throws Exception {
		
		UnidadFactory unidadFactory = new UnidadFactory();
		
		unidadMuerta = unidadFactory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(2,2));
		unidadMuerta.setVitalidad(new Vitalidad(0,0));
		
		unidadNoMuerta = unidadFactory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(2,3));
		unidadNoMuerta.setVitalidad(new Vitalidad(10,0));
		
		jugadorActual = new Jugador("jugador1",TipoColor.COLOR_ROJO,new Terran());
		jugadorEnemigo = new Jugador("jugador2",TipoColor.COLOR_AZUL,new Protoss());
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadMuerta);
		
	}

	@Test
	public void testObtenerNombreJugadorActualEsJugador1yJugadorEnemigoEsJugador2() {
		assertEquals("jugador1",Juego.getInstancia().obtenerNombreJugadorActual());
		assertEquals("jugador2",Juego.getInstancia().obtenerNombreJugadorEnemigo());
		assertEquals(TipoColor.COLOR_ROJO,Juego.getInstancia().obtenerColorJugadorActual());
		assertEquals(TipoColor.COLOR_AZUL,Juego.getInstancia().obtenerColorJugadorEnemigo());
	}
	
	@Test
	public void testIntercambiarJugadoresJugadorActualEsJugador2yJugadorEnemigoEsJugador1() throws NombreJugadorRepetidoException {	
		Juego.getInstancia().intercambiarJugadores();
		assertEquals("jugador2",Juego.getInstancia().obtenerNombreJugadorActual());
		assertEquals("jugador1",Juego.getInstancia().obtenerNombreJugadorEnemigo());	
		assertEquals(TipoColor.COLOR_AZUL,Juego.getInstancia().obtenerColorJugadorActual());
		assertEquals(TipoColor.COLOR_ROJO,Juego.getInstancia().obtenerColorJugadorEnemigo());
	}
	
	@Test(expected = FinDePartidaException.class)
	public void testVerificarPartidaFinalizadaJugadorEnemigoTieneUnaUnidadSolaUnidadConVida0() 
	throws FinDePartidaException {
		Juego.getInstancia().verificarFinDePartida();	
	}
	
	//Este test no tiene assert, pues el exito es que no tire excepcion
	@Test
	public void testVerificarPartidaSinFinalizarJugadoEnemigoTieneUnaUnidadVivayOtraMuerta() 
	throws FinDePartidaException, ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException {
			
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadNoMuerta);
			Juego.getInstancia().verificarFinDePartida();

	}

}
