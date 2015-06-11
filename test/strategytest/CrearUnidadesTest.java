package strategytest;

import jugador.Jugador;
import jugador.TipoColor;
import model.Armada;
import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;

import razas.Terran;
import strategy.ContextoStrategy;
import strategy.CrearAltoTemplario;
import strategy.CrearEspectro;
import strategy.CrearGolliat;
import strategy.CrearMarine;
import strategy.CrearNaveCiencia;
import strategy.CrearNaveTransporteProtoss;
import strategy.CrearNaveTransporteTerran;
import strategy.CrearScout;
import strategy.CrearZealot;

import common.Posicion;

import controller.JuegoController;
import exceptions.ColorInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.NombreCortoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.Acceso;
import factory.construcciones.ArchivoTemplario;
import factory.construcciones.Barraca;
import factory.construcciones.Fabrica;
import factory.construcciones.PuertoEstelarProtoss;
import factory.construcciones.PuertoEstelarTerran;

public class CrearUnidadesTest {
	
	Jugador jugadorActualTerran;
	Jugador jugadorActualProtoss;
	ContextoStrategy contexto;
	private Armada armada;
	Posicion posicionOrigen;
	Posicion posicionDestino;
	
	@Before
	public void setUp() throws NombreCortoException, ColorInvalidoException, FueraDeRangoException {
		
		posicionOrigen=new Posicion(10,10);
		posicionDestino = new Posicion(15,15);
		jugadorActualTerran = new Jugador("jugadorTerran",TipoColor.COLOR_ROJO,new Terran());
//		jugadorActualProtoss = new Jugador("jugadorProtoss",TipoColor.COLOR_ROJO,new Protoss());

		JuegoController.getInstancia().setJugadorActual(jugadorActualTerran);

	}
	
	@Test
	public void testJugadorConAccesoCreaZealot() throws FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial acceso = new Acceso(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(acceso);
		contexto = new ContextoStrategy(new CrearZealot());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial accesoObtenido = armada.obtenerElementoEnPosicion(posicionOrigen);
		accesoObtenido.realizarAccion(contexto, posicionDestino);
		ElementoArtificial zealot = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);		
	}
	
	@Test
	public void testJugadorConArchivoTemplarioCreaAltoTemplario() throws ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial acceso = new ArchivoTemplario(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(acceso);
		contexto = new ContextoStrategy(new CrearAltoTemplario());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial accesoObtenido = armada.obtenerElementoEnPosicion(posicionOrigen);
		accesoObtenido.realizarAccion(contexto, posicionDestino);
		ElementoArtificial altoTemplario = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		
	}
	@Test
	public void testJugadorConBarracaCreaMarine() throws ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial barraca = new Barraca(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(barraca);
		contexto = new ContextoStrategy(new CrearMarine());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial barracaObtenida = armada.obtenerElementoEnPosicion(posicionOrigen);
		barracaObtenida.realizarAccion(contexto, posicionDestino);
		ElementoArtificial marine = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);

	}
	
	@Test
	public void testJugadorConFabricaCreaGolliat() throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial fabrica = new Fabrica(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(fabrica);
		contexto = new ContextoStrategy(new CrearGolliat());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial fabricaObtenida = armada.obtenerElementoEnPosicion(posicionOrigen);
		fabricaObtenida.realizarAccion(contexto, posicionDestino);
		ElementoArtificial golliat = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
	}
	
	@Test
	public void testJugadorConPuertoEstelarProtossCreaScout() throws FueraDeRangoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial puertoEstelarProtoss = new PuertoEstelarProtoss(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarProtoss);
		contexto = new ContextoStrategy(new CrearScout());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial puertoEstelarProtossObtenido = armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarProtossObtenido.realizarAccion(contexto, posicionDestino);
		ElementoArtificial zealot = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);

		
	}
	
	@Test
	public void testJugadorConPuertoEstelarProtossCreaNaveTransporteProtoss() throws ElementoNoEncontradoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial puertoEstelarProtoss = new PuertoEstelarProtoss(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarProtoss);
		contexto = new ContextoStrategy(new CrearNaveTransporteProtoss());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial puertoEstelarProtossObtenido = armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarProtossObtenido.realizarAccion(contexto, posicionDestino);
		ElementoArtificial zealot = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);

		
	}
	
	@Test
	public void testJugadorConPuertoEstelarTerranCreaEspectro() throws FueraDeRangoException, ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial puertoEstelarTerran = new PuertoEstelarTerran(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarTerran);
		contexto = new ContextoStrategy(new CrearEspectro());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial puertoEstelarTerranObtenido = armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarTerranObtenido.realizarAccion(contexto, posicionDestino);
		ElementoArtificial espectro = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);

		
	}
	
	@Test
	public void testJugadorConPuertoEstelarTerranCreaNaveTransporteTerran() throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial puertoEstelarTerran = new PuertoEstelarTerran(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarTerran);
		contexto = new ContextoStrategy(new CrearNaveTransporteTerran());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial puertoEstelarTerranObtenido = armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarTerranObtenido.realizarAccion(contexto, posicionDestino);
		ElementoArtificial naveTransporteTerran = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		
	}
	
	@Test
	public void testJugadorConPuertoEstelarTerranCreaNaveCiencia() throws ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		ElementoArtificial puertoEstelarTerran = new PuertoEstelarTerran(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarTerran);
		contexto = new ContextoStrategy(new CrearNaveCiencia());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial puertoEstelarTerranObtenido = armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarTerranObtenido.realizarAccion(contexto, posicionDestino);
		ElementoArtificial naveCiencia = JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);

		
	}

}
