package algocraft;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;
import model.CampoBatalla;
import model.ElementoArtificial;
import model.Juego;

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
import exceptions.FueraDeRangoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
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
	ElementoArtificial unidadActual;
	CampoBatalla campoDeBatalla;
	
	@Before
	public void setUp() throws Exception {
		
		UnidadFactory unidadFactory = new UnidadFactory();
		
		unidadActual = unidadFactory.getUnidad(TipoUnidad.PROTOSS_DRAGON, new Posicion(5,5));
		
		unidadMuerta = unidadFactory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(2,2));
		unidadMuerta.setVitalidad(new Vitalidad(0,0));
		
		unidadNoMuerta = unidadFactory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(2,3));
		unidadNoMuerta.setVitalidad(new Vitalidad(10,0));
		
		jugadorActual = new Jugador("jugador1",TipoColor.COLOR_ROJO,new Terran());
		jugadorEnemigo = new Jugador("jugador2",TipoColor.COLOR_AZUL,new Protoss());
		
		jugadorActual.setGas(1000);
		jugadorActual.setMinerales(1000);
		
		jugadorEnemigo.setGas(1000);
		jugadorActual.setMinerales(1000);

		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		Juego.getInstancia().agregarUnidadAJugadorActual(unidadActual);
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
		Juego.getInstancia().cambiarTurno();
		assertEquals("jugador2",Juego.getInstancia().obtenerNombreJugadorActual());
		assertEquals("jugador1",Juego.getInstancia().obtenerNombreJugadorEnemigo());	
		assertEquals(TipoColor.COLOR_AZUL,Juego.getInstancia().obtenerColorJugadorActual());
		assertEquals(TipoColor.COLOR_ROJO,Juego.getInstancia().obtenerColorJugadorEnemigo());
	}
	
	@Test(expected = PartidaGanadaException.class)
	public void testVerificarPartidaFinalizadaJugadorEnemigoTieneUnaUnidadSolaUnidadConVida0() 
	throws FinDePartidaException, PartidaGanadaException, PartidaPerdidaException {
			Juego.getInstancia().verificarFinDePartida();	
	}
	
	//Este test no tiene assert, pues el exito es que no tire excepcion
	@Test
	public void testVerificarPartidaSinFinalizarJugadoEnemigoTieneUnaUnidadVivayOtraMuerta() 
	throws FinDePartidaException, ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, PartidaGanadaException, PartidaPerdidaException, FueraDeRangoException {
			
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadNoMuerta);
			Juego.getInstancia().verificarFinDePartida();

	}

}
