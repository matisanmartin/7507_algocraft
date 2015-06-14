package integraciontest;

import static org.junit.Assert.assertEquals;
import juego.Juego;
import jugador.Jugador;
import jugador.TipoColor;
import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;

import razas.Protoss;
import common.Posicion;
import exceptions.ElementoNoEncontradoException;
import exceptions.NombreJugadorRepetidoException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.unidades.TipoUnidad;

public class Enunciado9Test {

	private Jugador jugadorActual;
	private Jugador jugadorEnemigo;
	AbstractFactory factoryUnidad;
	ElementoArtificial protoss;
	Posicion posicionProtoss;
	
	@Before
	public void setUp() throws Exception {
		
		factoryUnidad=GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		posicionProtoss=new Posicion(2,2);
		protoss=factoryUnidad.getUnidad(TipoUnidad.PROTOSS_ZEALOT,posicionProtoss);
		protoss.setEscudo(10);//Se le setea en 10 para ir recuperandose

		jugadorActual = new Jugador("Jugador1",TipoColor.COLOR_ROJO,new Protoss());

		jugadorEnemigo = new Jugador("Jugador2",TipoColor.COLOR_AZUL,new Protoss());
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		
		Juego.getInstancia().getJugadorActual().agregarElemento(protoss);
		
	}
		

	@Test
	public void testRecuperacionEscudoCambioDeTurno() throws NombreJugadorRepetidoException, ElementoNoEncontradoException {
		
		//Escudo inicial 10
		assertEquals(10,Juego.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionProtoss).getEscudo());

		//Pasa un turno, deberia ser 20
		Juego.getInstancia().intercambiarJugadores();
		assertEquals(20,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().obtenerElementoEnPosicion(posicionProtoss).getEscudo());
		
		//Pasa otro turno, deberia ser 30
		Juego.getInstancia().intercambiarJugadores();
		assertEquals(30,Juego.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionProtoss).getEscudo());
		
	}

}
