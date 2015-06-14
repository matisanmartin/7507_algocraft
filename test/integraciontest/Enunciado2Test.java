package integraciontest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;
import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;

import razas.Protoss;
import razas.Terran;
import strategy.Alucinacion;
import strategy.Ataque;
import strategy.ContextoStrategy;
import strategy.Emp;
import strategy.TormentaPsionica;
import common.Posicion;
import controller.JuegoController;
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
import factory.unidades.Unidad;

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
		
		JuegoController.getInstancia().setJugadorActual(jugadorActual);
		JuegoController.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		
		JuegoController.getInstancia().getJugadorActual().agregarElemento(altoTemplario);
		
		posicionMarine = new Posicion(4,4);
		marine = factoryUnidad.getUnidad(TipoUnidad.TERRAN_MARINE,posicionMarine);
		
		posicionGolliat = new Posicion(4,6);
		golliat = factoryUnidad.getUnidad(TipoUnidad.TERRAN_GOLLIAT,posicionGolliat);
		
		posicionNaveCiencia = new Posicion(5,5);
		naveCiencia = factoryUnidad.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA,posicionNaveCiencia); 
		
		JuegoController.getInstancia().getJugadorEnemigo().agregarElemento(marine);
		JuegoController.getInstancia().getJugadorEnemigo().agregarElemento(naveCiencia);
		JuegoController.getInstancia().getJugadorEnemigo().agregarElemento(golliat);
		
	}
	
	@Test
	public void testNumero2aEnunciado() throws ElementoNoEncontradoException, NombreJugadorRepetidoException, UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException {
		
		//El templario debe lanzar tormenta psionica que requiere energia 75
		//Con pasar 2 turnos, deberia llegar a 80, la energía necesaria
		
		JuegoController.getInstancia().intercambiarJugadores();
		assertEquals(65,JuegoController.getInstancia().getJugadorEnemigo()
														.obtenerArmada()
														.obtenerElementoEnPosicion(posicionAltoTemplario)
														.getEnergia());
		
		JuegoController.getInstancia().intercambiarJugadores();
		assertEquals(80,JuegoController.getInstancia().getJugadorActual()
														.obtenerArmada()
														.obtenerElementoEnPosicion(posicionAltoTemplario)
														.getEnergia());
		

		ContextoStrategy contexto = new ContextoStrategy(new TormentaPsionica());
		
		ElementoArtificial altoTemplarioObt = JuegoController.getInstancia().getJugadorActual()
																			.obtenerArmada()
																			.obtenerElementoEnPosicion(posicionAltoTemplario);
		
		altoTemplarioObt.realizarAccion(contexto, posicionMarine);
		
		
		//marine: Vida inicial:100 -> resultado: 0
		assertEquals(0,JuegoController.getInstancia()
										.obtenerArmadaJugadorEnemigo()
										.obtenerElementoEnPosicion(posicionMarine)
										.getVida());
		
		//golliat: vida inicial: 125 -> resultado: 25
		assertEquals(25,JuegoController.getInstancia()
										.obtenerArmadaJugadorEnemigo()
										.obtenerElementoEnPosicion(posicionGolliat)
										.getVida());
		
		//naveCiencia: vida inicial: 200 -> resultado: 100
		assertEquals(100,JuegoController.getInstancia()
										.obtenerArmadaJugadorEnemigo()
										.obtenerElementoEnPosicion(posicionNaveCiencia)
										.getVida());	
	}
	
	@Test
	public void testNumero2bEnunciado() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, ElementoInvalidoException, RecursosInsuficientesException, ElementoNoEncontradoException, FactoryInvalidaException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, NombreJugadorRepetidoException{
		
		//Dejo pasar los turnos para que alcance la energia	
		JuegoController.getInstancia().intercambiarJugadores();//enemigo
		JuegoController.getInstancia().intercambiarJugadores();//actual
		JuegoController.getInstancia().intercambiarJugadores();//enemigo
		JuegoController.getInstancia().intercambiarJugadores();//actual
		
		//situo una unidad propia
		Posicion posicionZealot= new Posicion(5,5);
		Unidad zealot = factoryUnidad.getUnidad(TipoUnidad.PROTOSS_ZEALOT, posicionZealot);
		zealot.setRangoAtaque("2");//TODO msma: borrar luego y cambiarlo
		zealot.setVision(4);//TODO modificar leugo
		
		JuegoController.getInstancia().getJugadorActual().agregarElemento(zealot);
		
		ElementoArtificial altoTemplarioObt = JuegoController.getInstancia().getJugadorActual()
				.obtenerArmada()
				.obtenerElementoEnPosicion(posicionAltoTemplario);
		
		ContextoStrategy contexto = new ContextoStrategy(new Alucinacion());
		
		altoTemplarioObt.realizarAccion(contexto, posicionZealot);
		
		
		ElementoArtificial zealotFicticio1 = JuegoController.getInstancia()
															.getJugadorActual()
															.obtenerArmada()
															.obtenerElementoEnPosicion(new Posicion(3,2));
		
		
		//verifico que solo tiene escudo y no vida
		assertEquals(0,zealotFicticio1.getVida());
		assertEquals(60,zealotFicticio1.getEscudo());
		
		ElementoArtificial zealotFicticio2 = JuegoController.getInstancia()
															.getJugadorActual()
															.obtenerArmada()
															.obtenerElementoEnPosicion(new Posicion(1,2));
		
		//verifico que solo tiene escudo y no vida
		assertEquals(0,zealotFicticio2.getVida());
		assertEquals(60,zealotFicticio2.getEscudo());
		
		
		
		ContextoStrategy contextoZealot = new ContextoStrategy(new Ataque());
		
		zealotFicticio1.realizarAccion(contextoZealot, posicionMarine);
		zealotFicticio2.realizarAccion(contextoZealot, posicionMarine);
		
		ElementoArtificial marineObt = JuegoController.getInstancia()
														.getJugadorEnemigo()
														.obtenerArmada()
														.obtenerElementoEnPosicion(posicionMarine);
														
		
		//vida marine = 40
		assertEquals(40,marineObt.getVida());
		
		ContextoStrategy contextoAtaqueEmp = new ContextoStrategy(new Emp());
		
		//por las posiciones deberia afectar a ambos
		altoTemplario.realizarAccion(contextoAtaqueEmp, zealotFicticio1.getPosicion());
		
		
		//verifico que se le destuye el escudo
		assertEquals(0,zealotFicticio1.getEscudo());
		assertEquals(0,zealotFicticio2.getEscudo());
		
	}

}
