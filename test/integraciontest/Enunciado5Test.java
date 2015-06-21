package integraciontest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jugador.Jugador;
import jugador.TipoColor;
import model.CampoBatalla;
import model.ElementoArtificial;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import razas.Terran;
import strategy.ContextoStrategy;
import strategy.SubirUnidad;
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
import factory.AbstractFactory;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;

/**
 * Naves de transporte soportan su capacidad. 
 * Se debe probar que se sube unidades, desde un punto A , se pasa por espacio y se bajan del otro lado tierra B.
 *
 */
public class Enunciado5Test {
	
	AbstractFactory factory;
	ElementoArtificial naveTransporte;
	Posicion posNaveTransporte;
	ContextoStrategy contexto;
	Jugador jugadorActual;
	

	@Before
	public void setUp() throws Exception {
		factory = new UnidadFactory();
		jugadorActual = new Jugador("pepito",TipoColor.COLOR_AMARILLO,new Terran());
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		
		//Se los setea para que no haya problemas de recursos que estorben con el fin de la prueba
		Juego.getInstancia().getJugadorActual().setGas(100000);
		Juego.getInstancia().getJugadorActual().setMinerales(100000);
	}

	
	@After
	public void destroy(){
		CampoBatalla.DestruirInstancia();
	}
	
	@Test(expected = UnidadLlenaException.class)
	public void testNaveDeTransporteLlena() 
	throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {

		//Creo una nave de transporte
			posNaveTransporte = new Posicion(2,3);
			naveTransporte=factory.getUnidad(TipoUnidad.TERRAN_NAVE_TRANSPORTE, posNaveTransporte);
			Juego.getInstancia().agregarUnidadAJugadorActual(naveTransporte);
	
			//Creo 8 unidades
			Posicion posMarine1= new Posicion(2,2);
			ElementoArtificial unidadMarine1= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine1);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine1);
			
			Posicion posMarine2= new Posicion(3,3);
			ElementoArtificial unidadMarine2= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine2);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine2);
			
			Posicion posMarine3;
			Posicion posMarine4;
			Posicion posMarine5;
			Posicion posMarine6;
			Posicion posMarine7;
			Posicion posMarine8;

			posMarine3 = new Posicion(4,4);
			ElementoArtificial unidadMarine3= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine3);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine3);
			
			posMarine4 = new Posicion(5,5);
			ElementoArtificial unidadMarine4= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine4);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine4);
			
			posMarine5 = new Posicion(6,6);
			ElementoArtificial unidadMarine5= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine5);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine5);
			
			posMarine6 = new Posicion(7,7);
			ElementoArtificial unidadMarine6= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine6);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine6);
			
			posMarine7 = new Posicion(8,8);
			ElementoArtificial unidadMarine7= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine7);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine7);
			
			posMarine8 = new Posicion(9,9);
			ElementoArtificial unidadMarine8= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine8);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine8);
			
			//Las subo
			contexto = new ContextoStrategy(new SubirUnidad());
			naveTransporte.realizarAccion(contexto,posMarine1);
			naveTransporte.realizarAccion(contexto,posMarine2);
			naveTransporte.realizarAccion(contexto,posMarine3);
			naveTransporte.realizarAccion(contexto,posMarine4);
			naveTransporte.realizarAccion(contexto,posMarine5);
			naveTransporte.realizarAccion(contexto,posMarine6);
			naveTransporte.realizarAccion(contexto,posMarine7);
			naveTransporte.realizarAccion(contexto,posMarine8);
			
			//verifico que esten las 8
			assertEquals(8, naveTransporte.getCantidadDeUnidadesTransportadas());
			
			//creo una mas
			Posicion posMarine9= new Posicion(9,9);
			ElementoArtificial unidadMarine9= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine9);
			Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine9);
			
			//intento subirla, deberia tirar excepcion
			naveTransporte.realizarAccion(contexto,posMarine9);


		

	}
	
	@Test
	public void testMoverUnidadesEnNaveDeTransporte() 
	throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		
		//Creo una nave de transporte
		posNaveTransporte = new Posicion(2,3);
		naveTransporte=factory.getUnidad(TipoUnidad.TERRAN_NAVE_TRANSPORTE, posNaveTransporte);
		Juego.getInstancia().agregarUnidadAJugadorActual(naveTransporte);

		//Creo 1 unidad
		Posicion posMarine1= new Posicion(2,2);
		ElementoArtificial unidadMarine1= factory.getUnidad(TipoUnidad.TERRAN_MARINE, posMarine1);
		Juego.getInstancia().agregarUnidadAJugadorActual(unidadMarine1);
		
		contexto = new ContextoStrategy(new SubirUnidad());
		unidadMarine1.realizarAccion(contexto,posNaveTransporte);
		
	}

}
