package integraciontest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jugador.Jugador;
import jugador.TipoColor;
import model.ElementoArtificial;
import model.Juego;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import razas.Protoss;
import razas.Terran;
import strategy.ContextoStrategy;
import strategy.CrearAltoTemplario;
import strategy.CrearDepositoSuministro;
import strategy.CrearDragon;
import strategy.CrearEspectro;
import strategy.CrearGolliat;
import strategy.CrearMarine;
import strategy.CrearNaveCiencia;
import strategy.CrearNaveTransporteProtoss;
import strategy.CrearNaveTransporteTerran;
import strategy.CrearPilon;
import strategy.CrearScout;
import strategy.CrearZealot;
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
import factory.construcciones.CentroComandoProtoss;
import factory.construcciones.CentroComandoTerran;
import factory.construcciones.TipoEdificio;

@RunWith(JUnit4.class)
public class Enunciado7Test {
	private Jugador jugadorTerran;
	private Jugador jugadorProtoss;
	AbstractFactory factoryUnidad;
	AbstractFactory factoryConstruccion;

	
	@Before
	public void setUp() throws Exception {
		factoryUnidad = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		factoryConstruccion = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);
		
		jugadorTerran = new Jugador("jugador1","terran","rojo");
		jugadorProtoss = new Jugador("jugador2","protoss","azul");
	
	}
	
	@Test
	public void testAumentoDePoblacionDisponibleDepositoSuministroOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(0);
		jugadorTerran.setGas(10000);
		jugadorTerran.setMinerales(10000);
		
		CentroComandoTerran centro = new CentroComandoTerran(0, 0, null);
		
		//Creo un deposito de suministros
		ContextoStrategy contexto = new ContextoStrategy(new CrearDepositoSuministro());
		Posicion posDepositoSuministro = new Posicion(1,1);
		centro.realizarAccion(contexto, posDepositoSuministro);
		int poblacionDisponible = jugadorTerran.getPoblacionDisponible();
		//Debe aumentar en 5 la poblacion disponible
		assertEquals(poblacionDisponible,5);
		
		//Creo otro deposito de suministros
		posDepositoSuministro = new Posicion(2,2);
		centro.realizarAccion(contexto, posDepositoSuministro);
		poblacionDisponible = jugadorTerran.getPoblacionDisponible();
		//Debe aumentar en 5 la poblacion disponible
		assertEquals(poblacionDisponible,10);
	}
	
	@Test
	public void testNoAumentarPoblacionDispoibleConPoblacionMaximaAlcanzadaCreandoDepositoSuministro() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(200);
		jugadorTerran.setGas(10000);
		jugadorTerran.setMinerales(10000);
		
		CentroComandoTerran centro = new CentroComandoTerran(0, 0, null);
		
		//Creo un deposito de suministros
		ContextoStrategy contexto = new ContextoStrategy(new CrearDepositoSuministro());
		Posicion posDepositoSuministro = new Posicion(1,1);
		centro.realizarAccion(contexto, posDepositoSuministro);
		int poblacionDisponible = jugadorTerran.getPoblacionDisponible();
		//No debe aumentar la poblacion disponible
		assertEquals(poblacionDisponible,200);
		//Debe aumentar el exceso en 5
		int exceso = jugadorTerran.getExcesoPoblacion();
		assertEquals(exceso,5);
		
		//Creo otro deposito de suministros
		posDepositoSuministro = new Posicion(2,2);
		centro.realizarAccion(contexto, posDepositoSuministro);
		poblacionDisponible = jugadorTerran.getPoblacionDisponible();
		//No debe aumentar la poblacion disponible
		assertEquals(poblacionDisponible,200);
		//Debe aumentar el exceso en 5
		exceso = jugadorTerran.getExcesoPoblacion();
		assertEquals(exceso,10);
	}
	
	@Test
	public void testAumentoDePoblacionDisponiblePilonOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(0);
		jugadorProtoss.setGas(10000);
		jugadorProtoss.setMinerales(10000);
		
		CentroComandoProtoss centro = new CentroComandoProtoss(0, 0, null);
		
		//Creo un deposito de suministros
		ContextoStrategy contexto = new ContextoStrategy(new CrearPilon());
		Posicion posPilon = new Posicion(1,1);
		centro.realizarAccion(contexto, posPilon);
		int poblacionDisponible = jugadorProtoss.getPoblacionDisponible();
		//Debe aumentar en 5 la poblacion disponible
		assertEquals(poblacionDisponible,5);
		
		//Creo otro deposito de suministros
		posPilon = new Posicion(2,2);
		centro.realizarAccion(contexto, posPilon);
		poblacionDisponible = jugadorProtoss.getPoblacionDisponible();
		//Debe aumentar en 5 la poblacion disponible
		assertEquals(poblacionDisponible,10);
	}
	
	@Test
	public void testNoAumentarPoblacionDispoibleConPoblacionMaximaAlcanzadaCreandoPilon() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(200);
		jugadorProtoss.setGas(10000);
		jugadorProtoss.setMinerales(10000);
		
		CentroComandoProtoss centro = new CentroComandoProtoss(0, 0, null);
		
		//Creo un deposito de suministros
		ContextoStrategy contexto = new ContextoStrategy(new CrearPilon());
		Posicion posPilon = new Posicion(1,1);
		centro.realizarAccion(contexto, posPilon);
		int poblacionDisponible = jugadorProtoss.getPoblacionDisponible();
		//No debe aumentar la poblacion disponible
		assertEquals(poblacionDisponible,200);
		//Debe aumentar el exceso en 5
		int exceso = jugadorProtoss.getExcesoPoblacion();
		assertEquals(exceso,5);
		
		//Creo otro deposito de suministros
		posPilon = new Posicion(2,2);
		centro.realizarAccion(contexto, posPilon);
		poblacionDisponible = jugadorProtoss.getPoblacionDisponible();
		//No debe aumentar la poblacion disponible
		assertEquals(poblacionDisponible,200);
		//Debe aumentar el exceso en 5
		exceso = jugadorProtoss.getExcesoPoblacion();
		assertEquals(exceso,10);
	}
	
	
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearMarinePorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(0);
		jugadorTerran.agregarCantidadDeCristal(100000);
		jugadorTerran.agregarCantidadDeGas(100000);
		
		//Creo un Marine
		ContextoStrategy contexto = new ContextoStrategy(new CrearMarine());
		Posicion posBarraca = new Posicion(1,1);
		ElementoArtificial barraca = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_BARRACA, posBarraca);
		Posicion posMarine = new Posicion(1,2);
		barraca.realizarAccion(contexto, posMarine);
	}
	
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearGolliatPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(0);
		jugadorTerran.agregarCantidadDeCristal(100000);
		jugadorTerran.agregarCantidadDeGas(100000);
		
		//Creo un Golliat
		ContextoStrategy contexto = new ContextoStrategy(new CrearGolliat());
		Posicion posFabrica = new Posicion(1,1);
		ElementoArtificial fabrica = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_FABRICA, posFabrica);
		Posicion posGolliat = new Posicion(1,2);
		fabrica.realizarAccion(contexto, posGolliat);
	}
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearEspectroPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(0);
		jugadorTerran.agregarCantidadDeCristal(100000);
		jugadorTerran.agregarCantidadDeGas(100000);
		
		//Creo un Espectro
		ContextoStrategy contexto = new ContextoStrategy(new CrearEspectro());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posEspectro = new Posicion(1,2);
		puertoEstelar.realizarAccion(contexto, posEspectro);
	}
	
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearNaveTransporteTerranPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(0);
		jugadorTerran.agregarCantidadDeCristal(100000);
		jugadorTerran.agregarCantidadDeGas(100000);
		
		//Creo una Nave de transporte
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteTerran());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveDeTransporte = new Posicion(1,2);
		puertoEstelar.realizarAccion(contexto, posNaveDeTransporte);
	}
	
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearNaveCienciaPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		jugadorTerran.setPoblacionDisponible(0);
		jugadorTerran.agregarCantidadDeCristal(100000);
		jugadorTerran.agregarCantidadDeGas(100000);
		
		//Creo una Nave de ciencia
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveCiencia());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveDeCiencia = new Posicion(1,2);
		puertoEstelar.realizarAccion(contexto, posNaveDeCiencia);
	}
	
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearZealotPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(0);
		jugadorProtoss.agregarCantidadDeCristal(100000);
		jugadorProtoss.agregarCantidadDeGas(100000);
		
		//Creo un Zealot
		ContextoStrategy contexto = new ContextoStrategy(new CrearZealot());
		Posicion posAcceso = new Posicion(3,3);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Posicion posZealot = new Posicion(3,2);
		acceso.realizarAccion(contexto, posZealot);
	}
	
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearDragonPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(0);
		jugadorProtoss.agregarCantidadDeCristal(100000);
		jugadorProtoss.agregarCantidadDeGas(100000);
		
		//Creo un Dragon
		ContextoStrategy contexto = new ContextoStrategy(new CrearDragon());
		Posicion posAcceso = new Posicion(3,3);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Posicion posDragon = new Posicion(3,2);
		acceso.realizarAccion(contexto, posDragon);
	}
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearScoutPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(0);
		jugadorProtoss.agregarCantidadDeCristal(100000);
		jugadorProtoss.agregarCantidadDeGas(100000);
		
		//Creo un Scout
		ContextoStrategy contexto = new ContextoStrategy(new CrearScout());
		Posicion posPuertoEstelar = new Posicion(3,3);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posScout = new Posicion(3,2);
		puertoEstelar.realizarAccion(contexto, posScout);
	}
	
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearNaveTransporteProtossPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(0);
		jugadorProtoss.agregarCantidadDeCristal(100000);
		jugadorProtoss.agregarCantidadDeGas(100000);
		
		//Creo una nave de transporte
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteProtoss());
		Posicion posPuertoEstelar = new Posicion(3,3);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveDeTransporte = new Posicion(3,2);
		puertoEstelar.realizarAccion(contexto, posNaveDeTransporte);
		
	}
	
	@Test (expected = PoblacionFaltanteException.class)
	public void testNoSePuedeCrearAltoTemplarioPorFaltaDePoblacion() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		jugadorProtoss.setPoblacionDisponible(0);
		jugadorProtoss.agregarCantidadDeCristal(100000);
		jugadorProtoss.agregarCantidadDeGas(100000);
		
		//Creo un alto templario
		ContextoStrategy contexto = new ContextoStrategy(new CrearAltoTemplario());
		Posicion posArchivosTemplarios = new Posicion(3,3);
		ElementoArtificial archivosTemplarios = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ARCHIVO_TEMPLARIO, posArchivosTemplarios);
		Posicion posAltoTemplario = new Posicion(3,2);
		archivosTemplarios.realizarAccion(contexto, posAltoTemplario);
	}
		

}
