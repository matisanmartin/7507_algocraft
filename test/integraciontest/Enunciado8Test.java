package integraciontest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;
import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;

import razas.Protoss;
import razas.Terran;
import strategy.Ataque;
import strategy.ContextoStrategy;
import strategy.CrearMarine;
import strategy.CrearNaveCiencia;
import strategy.CrearZealot;
import strategy.Emp;
import strategy.Mover;
import strategy.Radiacion;

import common.Posicion;
import common.Vitalidad;

import controller.JuegoController;
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
		
		jugadorActual = new Jugador("Jugador1",TipoColor.COLOR_ROJO,new Terran());
		jugadorEnemigo = new Jugador("Jugador2",TipoColor.COLOR_AZUL,new Protoss());
		
		jugadorActual.setMinerales(10000);
		jugadorActual.setGas(10000);
		
		JuegoController.getInstancia().setJugadorActual(jugadorActual);
		JuegoController.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		
		
	}

	
	@Test(expected = PartidaGanadaException.class)
	public void testPartidaGanada() throws ElementoNoEncontradoException, ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, NombreJugadorRepetidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException {
		
		factoryEdificio = new EdificioFactory();
		//El jugador crea una barraca
		Posicion posicionBarraca=new Posicion(6,7);
		ElementoArtificial barraca = factoryEdificio.getEdificio(TipoEdificio.TERRAN_BARRACA,posicionBarraca);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(barraca);
		
		
		//Selecciono la barraca para crear un marine
		ElementoArtificial barracaObt = JuegoController.getInstancia()
														.obtenerArmadaJugadorActual()
														.obtenerElementoEnPosicion(posicionBarraca);
		
		//creo el marine
		contexto = new ContextoStrategy(new CrearMarine());
		Posicion posicionNuevoMarine = new Posicion(3,3);
		barracaObt.realizarAccion(contexto, posicionNuevoMarine);
		
		//cambia el turno
		JuegoController.getInstancia().cambiarTurno();
		
		//El jugador crea un Acceso
		Posicion posicionAcceso = new Posicion(10,10);
		ElementoArtificial acceso = factoryEdificio.getEdificio(TipoEdificio.PROTOSS_ACCESO, posicionAcceso);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(acceso);
		
		//Selecciono el acceso para obtener un zealot
		ElementoArtificial accesoObt = JuegoController.getInstancia()
													  .obtenerArmadaJugadorActual()
													  .obtenerElementoEnPosicion(posicionAcceso);
		
		contexto = new ContextoStrategy(new CrearZealot());
		Posicion posicionNuevoZealot = new Posicion(6,3);
		accesoObt.realizarAccion(contexto, posicionNuevoZealot);
		
		//acerco al zealot al marine
		Posicion proximaPosicionZealot = new Posicion(4,3);
		ElementoArtificial zealotObt = JuegoController.getInstancia()
														.obtenerArmadaJugadorActual()
														.obtenerElementoEnPosicion(posicionNuevoZealot);

		contexto = new ContextoStrategy(new Mover());
		zealotObt.realizarAccion(contexto, proximaPosicionZealot);
		
		//ataco al marine
		ElementoArtificial zealotObtDeNuevo = JuegoController.getInstancia()
																.obtenerArmadaJugadorActual()
																.obtenerElementoEnPosicion(proximaPosicionZealot);
		contexto = new ContextoStrategy(new Ataque());
		zealotObtDeNuevo.realizarAccion(contexto, posicionNuevoMarine);
		
		//verifico que le quite vida
		assertEquals(34,JuegoController.getInstancia()
										.obtenerArmadaJugadorEnemigo()
										.obtenerElementoEnPosicion(posicionNuevoMarine)
										.getVida());
		
		//cambia turno
		JuegoController.getInstancia().cambiarTurno();
		
		//jugador actual crea puerto estelar
		Posicion posPuertoEstelar = new Posicion(4,4);
		ElementoArtificial puertoEstelar = factoryEdificio.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelar);
		
			
		//jugador actual crea una nave ciencia seleccionando el puerto estelar
		Posicion posNaveCiencia = new Posicion(5,5);
		ElementoArtificial puertoEstelarObt = JuegoController.getInstancia()
																.obtenerArmadaJugadorActual()
																.obtenerElementoEnPosicion(posPuertoEstelar);
		
		contexto = new ContextoStrategy(new CrearNaveCiencia());
		puertoEstelarObt.realizarAccion(contexto, posNaveCiencia);
		
		
		
		//nave ciencia ataca zealot con misil emp
		ElementoArtificial naveCienciaObt = JuegoController.getInstancia()
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
			naveCienciaObt.setEnergia(100);//TODO cambiar luego
			naveCienciaObt.realizarAccion(contexto, proximaPosicionZealot);
		}
		
		
		//zealot pierde escudo
		assertEquals(0,zealotObtDeNuevo.getEscudo());
		
		//nave ciencia vuelve a atacar zealot con radiacion  y zealot deberia morir, por lo tanto, partida ganada
		ElementoArtificial naveCienciaObtDeNuevo = JuegoController.getInstancia()
																	.obtenerArmadaJugadorActual()
																	.obtenerElementoEnPosicion(posNaveCiencia);
		
		contexto = new ContextoStrategy(new Radiacion());
		
		try
		{
			naveCienciaObtDeNuevo.realizarAccion(contexto, proximaPosicionZealot);
		}
		catch(EnergiaInsuficienteException eie)
		{
			naveCienciaObtDeNuevo.setEnergia(100);//TODO msma cambiar luego
			naveCienciaObtDeNuevo.realizarAccion(contexto, proximaPosicionZealot);
		}
		
	}
	
	@Test(expected = PartidaPerdidaException.class)
	public void testPartidaPerdida() throws ElementoInvalidoException, PosicionInvalidaException, RecursosInsuficientesException, FueraDeRangoException, CostoInvalidoException, ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, NombreJugadorRepetidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException {
		//El test se medio rudimentario pero no se me ocurrio otra forma de simular una partida perdida
		//salvo que la accion sea un """suicidio"""
		
		//Genero una unidad, la agrego al jugador actual y la mato
		factoryEdificio = new EdificioFactory();
		//El jugador crea una barraca
		Posicion posicionBarraca=new Posicion(6,7);
		ElementoArtificial barraca = factoryEdificio.getEdificio(TipoEdificio.TERRAN_BARRACA,posicionBarraca);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(barraca);
		
		
		//Selecciono la barraca para crear un marine
		ElementoArtificial barracaObt = JuegoController.getInstancia()
														.obtenerArmadaJugadorActual()
														.obtenerElementoEnPosicion(posicionBarraca);
		
		//creo el marine
		contexto = new ContextoStrategy(new CrearMarine());
		Posicion posicionNuevoMarine = new Posicion(3,3);
		barracaObt.realizarAccion(contexto, posicionNuevoMarine);
		
		//cambia el turno, se crea una unidad enemiga viva para que no lanze PartidaGanadaException
		JuegoController.getInstancia().cambiarTurno();
		
		//El jugador crea un Acceso
		Posicion posicionAcceso = new Posicion(10,10);
		ElementoArtificial acceso = factoryEdificio.getEdificio(TipoEdificio.PROTOSS_ACCESO, posicionAcceso);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(acceso);
		
		//Selecciono el acceso para obtener un zealot
		ElementoArtificial accesoObt = JuegoController.getInstancia()
													  .obtenerArmadaJugadorActual()
													  .obtenerElementoEnPosicion(posicionAcceso);
		
		contexto = new ContextoStrategy(new CrearZealot());
		Posicion posicionNuevoZealot = new Posicion(6,3);
		accesoObt.realizarAccion(contexto, posicionNuevoZealot);

		//cambia el turno
		JuegoController.getInstancia().cambiarTurno();
		ElementoArtificial marine = JuegoController.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(posicionNuevoMarine);
		
		//suicido al marine
		marine.setVitalidad(new Vitalidad(0,0));
		
		//verifico manualmente porque las excepciones vinculadas con el fin de partida, 
		//por ahora, se lanzan cuando se realiza una accion
		JuegoController.getInstancia().verificarFinDePartida();
		
	}

}
