package integraciontest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;
import model.CampoBatalla;
import model.ElementoArtificial;
import model.Juego;

import org.junit.After;
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

		jugadorActual = new Jugador("jugador1","terran","rojo");
		jugadorEnemigo = new Jugador("jugador2","protoss","azul");

	
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		
		Juego.getInstancia().getJugadorActual().agregarElemento(protoss);
		
	}
	
	
	@After
	public void destroy(){
		CampoBatalla.DestruirInstancia();
	}
		

	@Test
	public void testRecuperacionEscudoCambioDeTurno() throws NombreJugadorRepetidoException, ElementoNoEncontradoException {
		
		//Escudo inicial 10
		assertEquals(10,Juego.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionProtoss).getEscudo());

		//Pasa un turno, deberia ser 20
		Juego.getInstancia().cambiarTurno();
		assertEquals(20,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().obtenerElementoEnPosicion(posicionProtoss).getEscudo());
		
		//Pasa otro turno, deberia ser 30
		Juego.getInstancia().cambiarTurno();
		assertEquals(30,Juego.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionProtoss).getEscudo());
		
	}

}
