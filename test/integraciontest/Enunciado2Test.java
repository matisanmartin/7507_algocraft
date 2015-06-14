package integraciontest;

import static org.junit.Assert.assertEquals;
import juego.Juego;
import jugador.Jugador;
import jugador.TipoColor;
import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;

import razas.Protoss;
import razas.Terran;
import strategy.ContextoStrategy;
import strategy.TormentaPsionica;
import common.Posicion;
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
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.unidades.TipoUnidad;

public class Enunciado2Test {

	private Jugador jugadorActual;
	private Jugador jugadorEnemigo;
	AbstractFactory factoryUnidad;
	ElementoArtificial altoTemplario;
	Posicion posicionAltoTemplario;
	ElementoArtificial marine;
	Posicion posicionMarine;
	ElementoArtificial golliat;
	Posicion posicionGolliat;
	ElementoArtificial naveCiencia;
	Posicion posicionNaveCiencia;
	
	@Before
	public void setUp() throws Exception {
		
		factoryUnidad=GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		posicionAltoTemplario=new Posicion(2,2);
		altoTemplario=factoryUnidad.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO,posicionAltoTemplario);

		jugadorActual = new Jugador("Jugador1",TipoColor.COLOR_ROJO,new Protoss());
		jugadorEnemigo = new Jugador("Jugador2",TipoColor.COLOR_AZUL,new Terran());
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		
		Juego.getInstancia().getJugadorActual().agregarElemento(altoTemplario);
		
		posicionMarine = new Posicion(4,4);
		marine = factoryUnidad.getUnidad(TipoUnidad.TERRAN_MARINE,posicionMarine);
		
		posicionGolliat = new Posicion(4,6);
		golliat = factoryUnidad.getUnidad(TipoUnidad.TERRAN_GOLLIAT,posicionGolliat);
		
		posicionNaveCiencia = new Posicion(5,5);
		naveCiencia = factoryUnidad.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA,posicionNaveCiencia); 
		
		Juego.getInstancia().getJugadorEnemigo().agregarElemento(marine);
		Juego.getInstancia().getJugadorEnemigo().agregarElemento(naveCiencia);
		Juego.getInstancia().getJugadorEnemigo().agregarElemento(golliat);
		
	}
	@Test
	public void testNumero2Enunciado() throws ElementoNoEncontradoException, NombreJugadorRepetidoException, UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException {
		
		//El templario debe lanzar tormenta psionica que requiere energia 75
		//Con pasar 2 turnos, deberia llegar a 80, la energía necesaria
		
		Juego.getInstancia().intercambiarJugadores();
		assertEquals(65,Juego.getInstancia().getJugadorEnemigo()
														.obtenerArmada()
														.obtenerElementoEnPosicion(posicionAltoTemplario)
														.getEnergia());
		
		Juego.getInstancia().intercambiarJugadores();
		assertEquals(80,Juego.getInstancia().getJugadorActual()
														.obtenerArmada()
														.obtenerElementoEnPosicion(posicionAltoTemplario)
														.getEnergia());
		

		ContextoStrategy contexto = new ContextoStrategy(new TormentaPsionica());
		
		ElementoArtificial altoTemplarioObt = Juego.getInstancia().getJugadorActual()
																			.obtenerArmada()
																			.obtenerElementoEnPosicion(posicionAltoTemplario);
		
		altoTemplarioObt.realizarAccion(contexto, posicionMarine);
		
		
		
		
		
		
		
	}

}
