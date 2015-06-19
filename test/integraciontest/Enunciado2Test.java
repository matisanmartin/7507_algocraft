package integraciontest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;
import model.ElementoArtificial;
import model.Juego;

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
	public void testNumero2aEnunciado() throws ElementoNoEncontradoException, NombreJugadorRepetidoException, UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException {
		
		//El templario debe lanzar tormenta psionica que requiere energia 75
		//Con pasar 2 turnos, deberia llegar a 80, la energía necesaria
		
		Juego.getInstancia().cambiarTurno();
		assertEquals(65,Juego.getInstancia().getJugadorEnemigo()
														.obtenerArmada()
														.obtenerElementoEnPosicion(posicionAltoTemplario)
														.getEnergia());
		
		Juego.getInstancia().cambiarTurno();
		assertEquals(80,Juego.getInstancia().getJugadorActual()
														.obtenerArmada()
														.obtenerElementoEnPosicion(posicionAltoTemplario)
														.getEnergia());
		

		ContextoStrategy contexto = new ContextoStrategy(new TormentaPsionica());
		
		ElementoArtificial altoTemplarioObt = Juego.getInstancia().getJugadorActual()
																			.obtenerArmada()
																			.obtenerElementoEnPosicion(posicionAltoTemplario);
		
		altoTemplarioObt.realizarAccion(contexto, posicionMarine);
		
		
		//marine: Vida inicial:100 -> resultado: 0
		assertEquals(0,Juego.getInstancia()
										.obtenerArmadaJugadorEnemigo()
										.obtenerElementoEnPosicion(posicionMarine)
										.getVida());
		
		//golliat: vida inicial: 125 -> resultado: 25
		assertEquals(25,Juego.getInstancia()
										.obtenerArmadaJugadorEnemigo()
										.obtenerElementoEnPosicion(posicionGolliat)
										.getVida());
		
		//naveCiencia: vida inicial: 200 -> resultado: 100
		assertEquals(100,Juego.getInstancia()
										.obtenerArmadaJugadorEnemigo()
										.obtenerElementoEnPosicion(posicionNaveCiencia)
										.getVida());	
	}
	
	@Test
	public void testNumero2bEnunciado() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, ElementoInvalidoException, RecursosInsuficientesException, ElementoNoEncontradoException, FactoryInvalidaException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, NombreJugadorRepetidoException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException{
		
		//Dejo pasar los turnos para que alcance la energia	
		Juego.getInstancia().cambiarTurno();//enemigo
		Juego.getInstancia().cambiarTurno();//actual
		Juego.getInstancia().cambiarTurno();//enemigo
		Juego.getInstancia().cambiarTurno();//actual
		
		//situo una unidad propia
		Posicion posicionZealot= new Posicion(5,5);
		Unidad zealot = factoryUnidad.getUnidad(TipoUnidad.PROTOSS_ZEALOT, posicionZealot);
		zealot.setVision(4);//TODO msma: modificar leugo cuando se agregue Vision
		
		Juego.getInstancia().getJugadorActual().agregarElemento(zealot);
		
		ElementoArtificial altoTemplarioObt = Juego.getInstancia().getJugadorActual()
				.obtenerArmada()
				.obtenerElementoEnPosicion(posicionAltoTemplario);
		
		ContextoStrategy contexto = new ContextoStrategy(new Alucinacion());
		
		altoTemplarioObt.realizarAccion(contexto, posicionZealot);
		
		
		ElementoArtificial zealotFicticio1 = Juego.getInstancia()
															.getJugadorActual()
															.obtenerArmada()
															.obtenerElementoEnPosicion(new Posicion(3,2));
		
		
		//verifico que solo tiene escudo y no vida
		assertEquals(0,zealotFicticio1.getVida());
		assertEquals(60,zealotFicticio1.getEscudo());
		
		ElementoArtificial zealotFicticio2 = Juego.getInstancia()
															.getJugadorActual()
															.obtenerArmada()
															.obtenerElementoEnPosicion(new Posicion(1,2));
		
		//verifico que solo tiene escudo y no vida
		assertEquals(0,zealotFicticio2.getVida());
		assertEquals(60,zealotFicticio2.getEscudo());
		
		ContextoStrategy contextoZealot = new ContextoStrategy(new Ataque());
		
		zealotFicticio1.realizarAccion(contextoZealot, posicionMarine);
		zealotFicticio2.realizarAccion(contextoZealot, posicionMarine);
		
		ElementoArtificial marineObt = Juego.getInstancia()
														.getJugadorEnemigo()
														.obtenerArmada()
														.obtenerElementoEnPosicion(posicionMarine);
														
		//vida marine = 40
		assertEquals(40,marineObt.getVida());
		
		ContextoStrategy contextoAtaqueEmp = new ContextoStrategy(new Emp());
		
		//por las posiciones deberia afectar a ambos, ya que están muy cercanos
		altoTemplario.realizarAccion(contextoAtaqueEmp, zealotFicticio1.getPosicion());
			
		//verifico que se le destuye el escudo
		assertEquals(0,zealotFicticio1.getEscudo());
		assertEquals(0,zealotFicticio2.getEscudo());
		
	}

}
