package integraciontest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jugador.Jugador;
import model.CampoBatalla;
import model.Elemento;
import model.ElementoArtificial;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import strategy.Ataque;
import strategy.ContextoStrategy;
import strategy.CrearMarine;
import strategy.CrearNaveCiencia;
import strategy.CrearZealot;
import strategy.Emp;
import strategy.Mover;
import strategy.Radiacion;
import vista.VentanaMock;

import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.NombreJugadorRepetidoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
import factory.AbstractFactory;
import factory.EdificioFactory;
import factory.construcciones.TipoEdificio;
/**
 * Simular, jugar y ganar/perder una partida
 *
 */
public class Enunciado8Test {

	Jugador jugadorActual;
	Jugador jugadorEnemigo;
	AbstractFactory factoryUnidad;
	AbstractFactory factoryEdificio;
	ContextoStrategy contexto;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		Juego.crearInstancia(new VentanaMock());
		jugadorActual = new Jugador("jugador1","terran","rojo");
		jugadorEnemigo = new Jugador("jugador2","protoss","azul");
		
		jugadorActual.setMinerales(10000);
		jugadorActual.setGas(10000);
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		
		Juego.getInstancia().getJugadorActual().setGas(1000);
		Juego.getInstancia().getJugadorActual().setMinerales(1000);
		
		
	}
	
	@After
	public void destroy(){
		Juego.destruirInstancia();
		CampoBatalla.DestruirInstancia();
	}

	
	@Test
	public void testPartidaGanada() throws ElementoNoEncontradoException, ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, NombreJugadorRepetidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		
		factoryEdificio = new EdificioFactory();
		//El jugador crea una barraca
		Posicion posicionBarraca=new Posicion(6,7);
		ElementoArtificial barraca = factoryEdificio.getEdificio(TipoEdificio.TERRAN_BARRACA,posicionBarraca);
		Juego.getInstancia().agregarUnidadAJugadorActual(barraca);
		
		
		//Selecciono la barraca para crear un marine
		Elemento barracaObt = Juego.getInstancia()
									.obtenerArmadaJugadorActual()
									.obtenerElementoEnPosicion(posicionBarraca);
		
		//creo el marine
		contexto = new ContextoStrategy(new CrearMarine());
		Posicion posicionNuevoMarine = new Posicion(30,3);
		barracaObt.realizarAccion(contexto, posicionNuevoMarine);
		
		//cambia el turno
		Juego.getInstancia().cambiarTurno();
		
		//El jugador crea un Acceso
		Posicion posicionAcceso = new Posicion(200,10);
		ElementoArtificial acceso = factoryEdificio.getEdificio(TipoEdificio.PROTOSS_ACCESO, posicionAcceso);
		Juego.getInstancia().agregarUnidadAJugadorActual(acceso);
		
		//Selecciono el acceso para obtener un zealot
		Elemento accesoObt = Juego.getInstancia()
									.obtenerArmadaJugadorActual()
										.obtenerElementoEnPosicion(posicionAcceso);
		
		contexto = new ContextoStrategy(new CrearZealot());
		Posicion posicionNuevoZealot = new Posicion(19,80);
		Juego.getInstancia().getJugadorActual().setMinerales(100);
		accesoObt.realizarAccion(contexto, posicionNuevoZealot);

		
		
		//acerco al zealot al marine
		Posicion proximaPosicionZealot = new Posicion(2,10);
		Elemento zealotObt = Juego.getInstancia()
									.obtenerArmadaJugadorActual()
									.obtenerElementoEnPosicion(posicionNuevoZealot);

		contexto = new ContextoStrategy(new Mover());
		zealotObt.realizarAccion(contexto, proximaPosicionZealot);
		
		//ataco al marine
		Elemento zealotObtDeNuevo = Juego.getInstancia()
										.obtenerArmadaJugadorActual()
										.obtenerElementoEnPosicion(proximaPosicionZealot);
		
		contexto = new ContextoStrategy(new Ataque());
		zealotObtDeNuevo.realizarAccion(contexto, posicionNuevoMarine);
		
		//verifico que le quite vida
		assertEquals(32,Juego.getInstancia()
								.obtenerArmadaJugadorEnemigo()
								.obtenerElementoEnPosicion(posicionNuevoMarine)
								.getVida());
		
		//cambia turno
		Juego.getInstancia().cambiarTurno();
		
		//jugador actual crea puerto estelar
		Posicion posPuertoEstelar = new Posicion(100,4);
		ElementoArtificial puertoEstelar = factoryEdificio.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Juego.getInstancia().agregarUnidadAJugadorActual(puertoEstelar);
		
			
		//jugador actual crea una nave ciencia seleccionando el puerto estelar
		Posicion posNaveCiencia = new Posicion(200,100);
		Elemento puertoEstelarObt = Juego.getInstancia()
										.obtenerArmadaJugadorActual()
										.obtenerElementoEnPosicion(posPuertoEstelar);

		contexto = new ContextoStrategy(new CrearNaveCiencia());
		puertoEstelarObt.realizarAccion(contexto, posNaveCiencia);
		
		
		
		//nave ciencia ataca zealot con misil emp
		Elemento naveCienciaObt = Juego.getInstancia()
										.obtenerArmadaJugadorActual()
										.obtenerElementoEnPosicion(posNaveCiencia);
		
		contexto = new ContextoStrategy(new Emp());
		try
		{
			naveCienciaObt.realizarAccion(contexto, proximaPosicionZealot);
		}
		catch(EnergiaInsuficienteException eie)
		{
			//No tengo energia suficiente para realizar la accion. Hay que recolectar
			naveCienciaObt.setEnergia(500);//TODO cambiar luego
			naveCienciaObt.realizarAccion(contexto, proximaPosicionZealot);
		}
		
		
		//zealot pierde escudo
		assertEquals(0,zealotObtDeNuevo.getEscudo());
		
		//nave ciencia vuelve a atacar zealot con radiacion  y zealot deberia morir, por lo tanto, partida ganada
		Elemento naveCienciaObtDeNuevo = Juego.getInstancia()
																	.obtenerArmadaJugadorActual()
																	.obtenerElementoEnPosicion(posNaveCiencia);
		
		contexto = new ContextoStrategy(new Mover());
		
		zealotObtDeNuevo.realizarAccion(contexto, new Posicion(150,200));
		
		naveCienciaObtDeNuevo.realizarAccion(contexto, new Posicion(100,100));
		
		contexto = new ContextoStrategy(new Radiacion());
		
		try
		{
			naveCienciaObtDeNuevo.realizarAccion(contexto, new Posicion(150,200));
		}
		catch(EnergiaInsuficienteException eie)
		{
			naveCienciaObtDeNuevo.setEnergia(100);//TODO msma cambiar luego
			naveCienciaObtDeNuevo.realizarAccion(contexto, new Posicion(150,200));
		}
		 assertEquals(true,Juego.getInstancia().seGanoPartida());
		
	}
	
	@Test
	public void testPartidaPerdida() throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException, CostoInvalidoException, ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, NombreJugadorRepetidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		//El test se medio rudimentario pero no se me ocurrio otra forma de simular una partida perdida
		//salvo que la accion sea un """suicidio"""
		
		//Genero una unidad, la agrego al jugador actual y la mato
		factoryEdificio = new EdificioFactory();
		//El jugador crea una barraca
		Posicion posicionBarraca=new Posicion(600,7);
		ElementoArtificial barraca = factoryEdificio.getEdificio(TipoEdificio.TERRAN_BARRACA,posicionBarraca);
		Juego.getInstancia().agregarUnidadAJugadorActual(barraca);
		
		
		//Selecciono la barraca para crear un marine
		Elemento barracaObt = Juego.getInstancia()
														.obtenerArmadaJugadorActual()
														.obtenerElementoEnPosicion(posicionBarraca);
		
		//creo el marine
		contexto = new ContextoStrategy(new CrearMarine());
		Posicion posicionNuevoMarine = new Posicion(3,3);
		try
		{
			barracaObt.realizarAccion(contexto, posicionNuevoMarine);
		}
		catch(PoblacionFaltanteException e)
		{
			jugadorActual.setPoblacionDisponible(20000);
		}
		
		//cambia el turno, se crea una unidad enemiga viva para que no lanze PartidaGanadaException
		Juego.getInstancia().cambiarTurno();
		
		//El jugador crea un Acceso
		Posicion posicionAcceso = new Posicion(100,10);
		ElementoArtificial acceso = factoryEdificio.getEdificio(TipoEdificio.PROTOSS_ACCESO, posicionAcceso);
		Juego.getInstancia().agregarUnidadAJugadorActual(acceso);
		
		//Selecciono el acceso para obtener un zealot
		Elemento accesoObt = Juego.getInstancia()
								  .obtenerArmadaJugadorActual()
								  .obtenerElementoEnPosicion(posicionAcceso);
		
		contexto = new ContextoStrategy(new CrearZealot());
		Posicion posicionNuevoZealot = new Posicion(300,3);
		//recolecto 50 para obtener un zealot
		Juego.getInstancia().getJugadorActual().agregarCantidadDeCristal(50);
		accesoObt.realizarAccion(contexto, posicionNuevoZealot);

		//cambia el turno
		Juego.getInstancia().cambiarTurno();
		Elemento marine = Juego.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(posicionNuevoMarine);
		
		//suicido al marine
		marine.setVitalidad(new Vitalidad(0,0));
		
		//verifico manualmente porque las excepciones vinculadas con el fin de partida, 
		//por ahora, se lanzan cuando se realiza una accion
		 assertEquals(true,Juego.getInstancia().sePerdioPartida());
		
	}

}
