package listenertest;

import java.io.IOException;

import jugador.Jugador;
import jugador.TipoColor;
import model.ElementoArtificial;
import model.Juego;

import org.junit.Before;
import org.junit.Test;

import razas.Protoss;
import razas.Terran;
import strategy.ContextoStrategy;
import strategy.CrearZealot;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
import factory.EdificioFactory;
import factory.construcciones.TipoEdificio;

public class ListenerCrearZealotTest {
	
	Jugador jugadorActual;
	Jugador jugadorEnemigo;
	
	
	@Before
	public void setUp() throws Exception {
		Jugador jugadorActual = new Jugador("pepeItaka", TipoColor.COLOR_AMARILLO, new Protoss());
		Jugador jugadorEnemigo = new Jugador("asd123",TipoColor.COLOR_ROJO,new Terran());
		jugadorActual.setMinerales(10000);
		jugadorActual.setGas(10000);
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
	}

	@Test
	public void test() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, ElementoInvalidoException, RecursosInsuficientesException, PoblacionFaltanteException, FactoryInvalidaException, UnidadInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, DanioInvalidoException, IOException {
		
		ContextoStrategy contexto = new ContextoStrategy(new CrearZealot());
		
		EdificioFactory edificioFactory = new EdificioFactory();
		
		Posicion posEdificio = new Posicion(10,10);
		ElementoArtificial elem=edificioFactory.getEdificio(TipoEdificio.PROTOSS_ACCESO, posEdificio);
		
		Juego.getInstancia().agregarUnidadAJugadorActual(elem);
		
		 ElementoArtificial elemObtenido = Juego.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(posEdificio);
		 
		 Posicion posicionDestino = new Posicion(12,12);
		 elemObtenido.realizarAccion(contexto, posicionDestino);
		
	}

}
