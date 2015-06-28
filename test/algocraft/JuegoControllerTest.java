package algocraft;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;
import model.CampoBatalla;
import model.Elemento;
import model.ElementoArtificial;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import vista.VentanaMock;

import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import factory.AbstractFactory;
import factory.EdificioFactory;
import factory.UnidadFactory;
import factory.construcciones.TipoEdificio;
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
		
		Juego.crearInstancia(new VentanaMock());
		UnidadFactory unidadFactory = new UnidadFactory();
		
		unidadActual = unidadFactory.getUnidad(TipoUnidad.PROTOSS_DRAGON, new Posicion(500,5));
		
		unidadMuerta = unidadFactory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(2,200));
		unidadMuerta.setVitalidad(new Vitalidad(0,0));
		
		unidadNoMuerta = unidadFactory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(2,300));
		unidadNoMuerta.setVitalidad(new Vitalidad(10,0));
		
		jugadorActual = new Jugador("jugador1","terran","rojo");
		jugadorEnemigo = new Jugador("jugador2","protoss","azul");
		
		jugadorActual.setPoblacionDisponible(20000);
		jugadorEnemigo.setPoblacionDisponible(200000);


		
		jugadorActual.setGas(1000);
		jugadorActual.setMinerales(1000);
		
		jugadorEnemigo.setGas(1000);
		jugadorActual.setMinerales(1000);

		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		Juego.getInstancia().agregarUnidadAJugadorActual(unidadActual);
		Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadMuerta);
		
	}
	
	@After
	public void destroy(){
		CampoBatalla.DestruirInstancia();
		Juego.destruirInstancia();
	}

	//@Test
	public void testObtenerNombreJugadorActualEsJugador1yJugadorEnemigoEsJugador2() {
		assertEquals("jugador1",Juego.getInstancia().obtenerNombreJugadorActual());
		assertEquals("jugador2",Juego.getInstancia().obtenerNombreJugadorEnemigo());
		assertEquals(TipoColor.COLOR_ROJO,Juego.getInstancia().obtenerColorJugadorActual());
		assertEquals(TipoColor.COLOR_AZUL,Juego.getInstancia().obtenerColorJugadorEnemigo());
	}
	
	//@Test
	public void testIntercambiarJugadoresJugadorActualEsJugador2yJugadorEnemigoEsJugador1() throws NombreJugadorRepetidoException {	
		Juego.getInstancia().cambiarTurno();
		assertEquals("jugador2",Juego.getInstancia().obtenerNombreJugadorActual());
		assertEquals("jugador1",Juego.getInstancia().obtenerNombreJugadorEnemigo());	
		assertEquals(TipoColor.COLOR_AZUL,Juego.getInstancia().obtenerColorJugadorActual());
		assertEquals(TipoColor.COLOR_ROJO,Juego.getInstancia().obtenerColorJugadorEnemigo());
	}
	
	//@Test(expected = PartidaGanadaException.class)
	public void testVerificarPartidaFinalizadaJugadorEnemigoTieneUnaUnidadSolaUnidadConVida0() 
	throws FinDePartidaException, PartidaGanadaException, PartidaPerdidaException {
			Juego.getInstancia().verificarFinDePartida();	
	}
	
	//Este test no tiene assert, pues el exito es que no tire excepcion
	//@Test
	public void testVerificarPartidaSinFinalizarJugadoEnemigoTieneUnaUnidadVivayOtraMuerta() 
	throws FinDePartidaException, ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, PartidaGanadaException, PartidaPerdidaException, FueraDeRangoException {
			
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadNoMuerta);
			Juego.getInstancia().verificarFinDePartida();

	}
	
	@Test
	public void testCambioDeTurnoYAUmentoDeMineralesYGas() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, ElementoInvalidoException, RecursosInsuficientesException, PoblacionFaltanteException, NombreJugadorRepetidoException {
		
		AbstractFactory edificioFactory = new EdificioFactory();
		
		Elemento refineria = edificioFactory.getEdificio(TipoEdificio.TERRAN_REFINERIA, new Posicion(100,100));
		
		Juego.getInstancia().agregarUnidadAJugadorActual(refineria);
		
		assertEquals(950,Juego.getInstancia().getJugadorActual().getCantidadDeGas());
		
		Juego.getInstancia().cambiarTurno();
		
		assertEquals(1000,Juego.getInstancia().getJugadorActual().getCantidadDeGas());
		assertEquals(960,Juego.getInstancia().getJugadorEnemigo().getCantidadDeGas());
		
		Juego.getInstancia().cambiarTurno();
		
		assertEquals(960,Juego.getInstancia().getJugadorActual().getCantidadDeGas());
		assertEquals(1000,Juego.getInstancia().getJugadorEnemigo().getCantidadDeGas());
		
		
		
	}

}
