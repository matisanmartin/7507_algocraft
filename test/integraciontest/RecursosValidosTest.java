package integraciontest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jugador.Jugador;
import model.CampoBatalla;
import model.ElementoArtificial;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import strategy.ContextoStrategy;
import strategy.CrearAltoTemplario;
import strategy.CrearDragon;
import strategy.CrearEspectro;
import strategy.CrearGolliat;
import strategy.CrearMarine;
import strategy.CrearNaveCiencia;
import strategy.CrearNaveTransporteProtoss;
import strategy.CrearNaveTransporteTerran;
import strategy.CrearScout;
import strategy.CrearZealot;
import vista.VentanaMock;

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
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.construcciones.TipoEdificio;

@RunWith(JUnit4.class)

public class RecursosValidosTest {
	
	Jugador jugadorTerran;
	Jugador jugadorProtoss;
	AbstractFactory factoryUnidad;
	AbstractFactory factoryConstruccion;
	
	@Before
	public void setUp() throws Exception {
		Juego.crearInstancia(new VentanaMock());
		factoryUnidad = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		factoryConstruccion = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);
		
		jugadorTerran = new Jugador("jugador1","terran","rojo");
		jugadorProtoss = new Jugador("jugador2","protoss","azul");
	
	}
	
	@After
	public void destroy() {
		Juego.destruirInstancia();
		CampoBatalla.DestruirInstancia();
	}
	
	@Test
	public void testRecursosSuficientesMarine() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(50);
		jugadorTerran.setGas(0);
		
		//Creo un Marine
		ContextoStrategy contexto = new ContextoStrategy(new CrearMarine());
		Posicion posBarraca = new Posicion(1,1);
		ElementoArtificial barraca = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_BARRACA, posBarraca);
		Posicion posMarine = new Posicion(100,30);
		barraca.realizarAccion(contexto, posMarine);
		int minerales = jugadorTerran.getCantidadDeCristal();
		int gas = jugadorTerran.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesMarine() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(49);	
		jugadorTerran.setGas(0);
		
		//Creo un Marine
		ContextoStrategy contexto = new ContextoStrategy(new CrearMarine());
		Posicion posBarraca = new Posicion(1,1);
		ElementoArtificial barraca = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_BARRACA, posBarraca);
		Posicion posMarine = new Posicion(100,30);
		barraca.realizarAccion(contexto, posMarine);
	}
	
	@Test
	public void testRecursosSuficientesGolliat() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(100);
		jugadorTerran.setGas(50);
		
		//Creo un Golliat
		ContextoStrategy contexto = new ContextoStrategy(new CrearGolliat());
		Posicion posFabrica = new Posicion(1,1);
		ElementoArtificial fabrica = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_FABRICA, posFabrica);
		Posicion posGolliat = new Posicion(100,30);
		fabrica.realizarAccion(contexto, posGolliat);
		int minerales = jugadorTerran.getCantidadDeCristal();
		int gas = jugadorTerran.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesGolliat() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(99);
		jugadorTerran.setGas(49);
		
		//Creo un Golliat
		ContextoStrategy contexto = new ContextoStrategy(new CrearGolliat());
		Posicion posFabrica = new Posicion(1,1);
		ElementoArtificial fabrica = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_FABRICA, posFabrica);
		Posicion posGolliat = new Posicion(100,30);
		fabrica.realizarAccion(contexto, posGolliat);
	}
	
	@Test
	public void testRecursosSuficientesEspectro() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(150);
		jugadorTerran.setGas(100);
		
		//Creo un Espectro
		ContextoStrategy contexto = new ContextoStrategy(new CrearEspectro());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posEspectro = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posEspectro);
		int minerales = jugadorTerran.getCantidadDeCristal();
		int gas = jugadorTerran.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesEspectro() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(149);
		jugadorTerran.setGas(99);
		
		//Creo un Espectro
		ContextoStrategy contexto = new ContextoStrategy(new CrearEspectro());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posEspectro = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posEspectro);
	}
	@Test
	public void testRecursosSuficientesNaveCiencia() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(100);
		jugadorTerran.setGas(225);
		
		//Creo un NaveCiencia
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveCiencia());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveCiencia = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posNaveCiencia);
		int minerales = jugadorTerran.getCantidadDeCristal();
		int gas = jugadorTerran.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesNaveCiencia() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(99);
		jugadorTerran.setGas(224);
		
		//Creo un NaveCiencia
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveCiencia());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveCiencia = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posNaveCiencia);
	}
	@Test
	public void testRecursosSuficientesNaveDeTransporteTerran() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(100);
		jugadorTerran.setGas(100);
		
		//Creo un NaveCiencia
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteTerran());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveDeTransporte = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posNaveDeTransporte);
		int minerales = jugadorTerran.getCantidadDeCristal();
		int gas = jugadorTerran.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesNaveDeTransporteTerran() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.setMinerales(99);
		jugadorTerran.setGas(99);
		
		//Creo un NaveCiencia
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteTerran());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveDeTransporte = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posNaveDeTransporte);
	}
	
	
	@Test
	public void testRecursosSuficientesZealot() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(100);
		jugadorProtoss.setGas(0);
		
		//Creo un Zealot
		ContextoStrategy contexto = new ContextoStrategy(new CrearZealot());
		Posicion posAcceso = new Posicion(1,1);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Posicion posZealot = new Posicion(100,30);
		acceso.realizarAccion(contexto, posZealot);
		int minerales = jugadorProtoss.getCantidadDeCristal();
		int gas = jugadorProtoss.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesZealot() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(150);
		jugadorProtoss.setGas(0);
		
		//Creo un Zealot
		ContextoStrategy contexto = new ContextoStrategy(new CrearZealot());
		Posicion posAcceso = new Posicion(1,1);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Juego.getInstancia().agregarUnidadAJugadorActual(acceso);
		Posicion posZealot = new Posicion(100,30);
		acceso.realizarAccion(contexto, posZealot);
	}
	
	
	@Test
	public void testRecursosSuficientesDragon() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(125);
		jugadorProtoss.setGas(50);
		
		//Creo un Dragon
		ContextoStrategy contexto = new ContextoStrategy(new CrearDragon());
		Posicion posAcceso = new Posicion(1,1);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Posicion posDragon = new Posicion(100,30);
		acceso.realizarAccion(contexto, posDragon);
		int minerales = jugadorProtoss.getCantidadDeCristal();
		int gas = jugadorProtoss.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesDragon() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(124);
		jugadorProtoss.setGas(49);
		
		//Creo un Dragon
		ContextoStrategy contexto = new ContextoStrategy(new CrearDragon());
		Posicion posAcceso = new Posicion(1,1);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Posicion posDragon = new Posicion(100,30);
		acceso.realizarAccion(contexto, posDragon);
	}
	@Test 
	public void testRecursosSuficientesNaveDeTransporteProtoss() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(200);
		jugadorProtoss.setGas(0);
		
		//Creo una NaveDeTransporte
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteProtoss());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveDeTransporte = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posNaveDeTransporte);
		int minerales = jugadorProtoss.getCantidadDeCristal();
		int gas = jugadorProtoss.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesNaveDeTransporteProtoss() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(199);
		jugadorProtoss.setGas(0);
		
		//Creo una NaveDeTransporte
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteProtoss());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posPuertoEstelar);
		Juego.getInstancia().agregarUnidadAJugadorActual(puertoEstelar);;
		Posicion posNaveDeTransporte = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posNaveDeTransporte);
	}
	
	@Test 
	public void testRecursosSuficientesScout() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(300);
		jugadorProtoss.setGas(150);
		
		//Creo un Scout
		ContextoStrategy contexto = new ContextoStrategy(new CrearScout());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posScout = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posScout);
		int minerales = jugadorProtoss.getCantidadDeCristal();
		int gas = jugadorProtoss.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesScout() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(299);
		jugadorProtoss.setGas(149);
		
		//Creo un Scout
		ContextoStrategy contexto = new ContextoStrategy(new CrearScout());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posScout = new Posicion(100,30);
		puertoEstelar.realizarAccion(contexto, posScout);
	}
	
	@Test
	public void testRecursosSuficientesAltoTemplario() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(50);
		jugadorProtoss.setGas(150);
		
		//Creo un AltoTemplario
		ContextoStrategy contexto = new ContextoStrategy(new CrearAltoTemplario());
		Posicion posArchivosTemplarios = new Posicion(1,1);
		ElementoArtificial archivosTemplarios = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ARCHIVO_TEMPLARIO, posArchivosTemplarios);
		Posicion posAltoTemplario = new Posicion(100,30);
		archivosTemplarios.realizarAccion(contexto, posAltoTemplario);
		int minerales = jugadorProtoss.getCantidadDeCristal();
		int gas = jugadorProtoss.getCantidadDeGas();
		
		//Verifico que la cantidad de minerales y gas del jugador sea cero.
		assertEquals(0, minerales);
		assertEquals(0, gas);
	}
	
	
	@Test (expected = RecursosInsuficientesException.class)
	public void testRecursosInsuficientesAltoTemplario() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.setMinerales(49);
		jugadorProtoss.setGas(149);
		
		//Creo un AltoTemplario
		ContextoStrategy contexto = new ContextoStrategy(new CrearAltoTemplario());
		Posicion posArchivosTemplarios = new Posicion(1,1);
		ElementoArtificial archivosTemplarios = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ARCHIVO_TEMPLARIO, posArchivosTemplarios);
		Posicion posAltoTemplario = new Posicion(100,30);
		archivosTemplarios.realizarAccion(contexto, posAltoTemplario);
	}


}
