package jugadortest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jugador.Jugador;
import model.Armada;
import model.CampoBatalla;
import model.Elemento;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import strategy.ContextoStrategy;
import strategy.Mover;
import vista.VentanaMock;

import common.Posicion;
import common.Vitalidad;

import exceptions.ColorInvalidoException;
import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.NombreCortoException;
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

@RunWith(JUnit4.class)
public class ArmadaTest {
	
	Armada armada;
	AbstractFactory factory;
	Unidad unidadMuerta,unidadMuertaNueva;
	Posicion pos;

	@Before
	public void setUp() throws Exception {
		
		Juego.crearInstancia(new VentanaMock());
		pos=new Posicion(1,2);
		armada=new Armada();
		factory = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		
		unidadMuerta = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 100));
		unidadMuerta.posicionar(pos);
		unidadMuerta.setVitalidad(new Vitalidad(0,0));
		
		unidadMuertaNueva = factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, new Posicion(200, 1));
		unidadMuertaNueva.setVitalidad(new Vitalidad(0,0));
	}
	
	@After
	public void destroy(){
		Juego.destruirInstancia();
		CampoBatalla.DestruirInstancia();
	}

	@Test
	public void testArmadaVaciaDimension0() {
		assertEquals(0,armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaConUnElementoDimension1() throws PosicionInvalidaException, FueraDeRangoException {
		armada.agregarElemento(unidadMuerta);
		assertEquals(1,armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaEliminarElementoEnPosicion() throws PosicionInvalidaException, FueraDeRangoException {
		armada.agregarElemento(unidadMuerta);
		Posicion posicion = unidadMuerta.getPosicion();
		armada.eliminarElementoMuertoEnPosicion(posicion);
		assertEquals(0, armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaConVariosElementosEliminarElementoEnPosicion() throws FueraDeRangoException, ElementoNoEncontradoException, PosicionInvalidaException {
		
		armada.agregarElemento(unidadMuerta);
		armada.agregarElemento(unidadMuertaNueva);
		
		armada.eliminarElementoMuertoEnPosicion(new Posicion(200,1));
		assertEquals(1,armada.getDimensionArmada());
		
		Elemento ElementoUnico = armada.obtenerElementoEnPosicion(pos);
		assertEquals(true,pos.equals(ElementoUnico.getPosicion()));	
	}
	
	
	@Test (expected = ElementoNoEncontradoException.class)
	public void noDeberiaRetornarElementoQueContieneLaParte() throws PosicionInvalidaException, FueraDeRangoException, UnidadInvalidaException, CostoInvalidoException, DanioInvalidoException, UnidadLlenaException, ElementoNoEncontradoException{
		Unidad unidad1 = factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, new Posicion(50, 50));
		Unidad unidad2 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(200, 3));
		armada.agregarElemento(unidad1);
		armada.agregarElemento(unidad2);
		Elemento unidadObtenida = armada.obtenerElementoEnPosicion(new Posicion(100, 100));
		assertEquals(new Posicion(200, 3), unidadObtenida.getPosicion());
		assertEquals(new Posicion(3,3), unidadObtenida.getPartes().get(2).getPosicion());
		
	}
	
	@Test
	public void siMuevoUnaUnidadTambienSeCambiaEnElCampoDeBatalla() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, DanioInvalidoException, PosicionInvalidaException, UnidadLlenaException, NombreCortoException, ColorInvalidoException, NombreJugadorRepetidoException, ElementoInvalidoException, RecursosInsuficientesException, PoblacionFaltanteException, ElementoNoEncontradoException, FactoryInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, RecursosFaltantesException, IOException{
		Jugador jugadorActual;
		Jugador jugadorEnemigo;
		jugadorActual = new Jugador("jugador1","terran","rojo");
		jugadorEnemigo = new Jugador("jugador2","protoss","azul");
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
		
		jugadorActual.setPoblacionDisponible(20000);
		
		Unidad unidad1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(50, 50));
		Unidad unidad2 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(200, 3));
		Juego.getInstancia().agregarUnidadAJugadorActual(unidad1);
		Juego.getInstancia().agregarUnidadAJugadorActual(unidad2);
		
		Elemento unidadObtenida = Juego.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(unidad2.getPartes().get(2).getPosicion());
		ContextoStrategy contextoStrategy = new ContextoStrategy(new Mover());
		unidadObtenida.realizarAccion(contextoStrategy, new Posicion(400, 400));
		Elemento unidadDeCampo = CampoBatalla.getInstancia().getEspacioTerrestre().getEspacio().get(1);
		assertEquals(new Posicion(400, 400), unidadDeCampo.getPosicion());
		assertEquals(unidadObtenida.getPosicion(), unidadDeCampo.getPosicion());
		
	}

}
