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
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import strategy.ContextoStrategy;
import strategy.CrearAltoTemplario;
import strategy.CrearDragon;
import strategy.CrearEspectro;
import strategy.CrearGolliat;
import strategy.CrearMarine;
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
import factory.construcciones.TipoEdificio;
import factory.unidades.Unidad;

@RunWith(JUnit4.class)
public class Enunciado6Test {
	
	private Jugador jugadorTerran;
	private Jugador jugadorProtoss;
	AbstractFactory factoryUnidad;
	AbstractFactory factoryConstruccion;

	
	@Before
	public void setUp() throws Exception {
		
		Juego.crearInstancia(new VentanaMock());
		factoryUnidad = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		factoryConstruccion = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);
		
		jugadorTerran = new Jugador("jugador1","terran","rojo");
		jugadorProtoss = new Jugador("jugador2","protoss","azul");
		
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		Juego.getInstancia().setJugadorEnemigo(jugadorProtoss);
		jugadorTerran.setPoblacionDisponible(100);
		jugadorTerran.agregarCantidadDeCristal(100000);
		jugadorTerran.agregarCantidadDeGas(100000);
		jugadorProtoss.setPoblacionDisponible(100);
		jugadorProtoss.agregarCantidadDeCristal(100000);
		jugadorProtoss.agregarCantidadDeGas(100000);
	
	}
	
	
	@After
	public void destroy(){
		CampoBatalla.DestruirInstancia();
		Juego.destruirInstancia();
	}
	
	/* A continuacion se prueba que la construccion de unidades sume poblacion
	 * y que la destruccion de las mismas reste */
	@Test
	public void testAumentoDePoblacionActualMarineOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, NombreJugadorRepetidoException, IOException {

		
		//Creo un Marine
		ContextoStrategy contexto = new ContextoStrategy(new CrearMarine());
		Posicion posBarraca = new Posicion(1,1);
		ElementoArtificial barraca = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_BARRACA, posBarraca);
		Juego.getInstancia().getJugadorActual().agregarElemento(barraca);
		Posicion posMarine = new Posicion(100,2);
		barraca.realizarAccion(contexto, posMarine);
		int poblacionActual = Juego.getInstancia().getJugadorActual().getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Elemento marine = Juego.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(posMarine);
		assertEquals(marine.getSuministro(), poblacionActual);
		
		Juego.getInstancia().cambiarTurno();
		
		poblacionActual = Juego.getInstancia().getJugadorEnemigo().getPoblacionActual();
		int suministro = marine.getSuministro();
		Juego.getInstancia().eliminarElementoDeJugadorEnemigo(marine);
		assertEquals(poblacionActual - suministro, jugadorTerran.getPoblacionActual());
	}
	
	@Test
	public void testAumentoDePoblacionActualGolliatOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, NombreJugadorRepetidoException, IOException {
		
		//Creo un Golliat
		ContextoStrategy contexto = new ContextoStrategy(new CrearGolliat());
		Posicion posFabrica = new Posicion(1,1);
		ElementoArtificial fabrica = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_FABRICA, posFabrica);
		Juego.getInstancia().getJugadorActual().agregarElemento(fabrica);
		Posicion posGolliat = new Posicion(100,2);
		fabrica.realizarAccion(contexto, posGolliat);
		int poblacionActual = Juego.getInstancia().getJugadorActual().getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Elemento golliat = Juego.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(posGolliat);
		assertEquals(golliat.getSuministro(), poblacionActual);
		
		Juego.getInstancia().cambiarTurno();
		
		poblacionActual = Juego.getInstancia().getJugadorEnemigo().getPoblacionActual();
		int suministro = golliat.getSuministro();
		Juego.getInstancia().eliminarElementoDeJugadorEnemigo(golliat);
		assertEquals(poblacionActual - suministro, jugadorTerran.getPoblacionActual());
	}
	
	@Test
	public void testAumentoDePoblacionActualEspectroOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, NombreJugadorRepetidoException, IOException {

		
		//Creo un Especto
		ContextoStrategy contexto = new ContextoStrategy(new CrearEspectro());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Juego.getInstancia().getJugadorActual().agregarElemento(puertoEstelar);
		Posicion posEspectro = new Posicion(100,2);
		puertoEstelar.realizarAccion(contexto, posEspectro);
		int poblacionActual = Juego.getInstancia().getJugadorActual().getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Elemento espectro = Juego.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(posEspectro);
		assertEquals(espectro.getSuministro(), poblacionActual);
		
		Juego.getInstancia().cambiarTurno();
		
		poblacionActual = Juego.getInstancia().getJugadorEnemigo().getPoblacionActual();
		int suministro = espectro.getSuministro();
		Juego.getInstancia().eliminarElementoDeJugadorEnemigo(espectro);
		assertEquals(poblacionActual - suministro, jugadorTerran.getPoblacionActual());
	}
	@Test
	public void testAumentoDePoblacionActualNaveDeTransporteTerranOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, NombreJugadorRepetidoException, IOException {

		//Creo una NaveTransporte
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteTerran());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Juego.getInstancia().getJugadorActual().agregarElemento(puertoEstelar);
		Posicion posNaveTransporte = new Posicion(100,2);
		puertoEstelar.realizarAccion(contexto, posNaveTransporte);
		int poblacionActual = Juego.getInstancia().getJugadorActual().getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Elemento naveTransporte = Juego.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(posNaveTransporte);
		assertEquals(naveTransporte.getSuministro(), poblacionActual);
		
		Juego.getInstancia().cambiarTurno();
		
		poblacionActual = Juego.getInstancia().getJugadorEnemigo().getPoblacionActual();
		int suministro = naveTransporte.getSuministro();
		Juego.getInstancia().eliminarElementoDeJugadorEnemigo(naveTransporte);
		assertEquals(poblacionActual - suministro, jugadorTerran.getPoblacionActual());
	}
	
	@Test
	public void testAumentoDePoblacionActualNaveDeCienciaOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, NombreJugadorRepetidoException, IOException {
		
		//Creo una NaveCiencia
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteTerran());
		Posicion posPuertoEstelar = new Posicion(1,1);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posPuertoEstelar);
		Juego.getInstancia().getJugadorActual().agregarElemento(puertoEstelar);
		Posicion posNaveCiencia = new Posicion(100,2);
		puertoEstelar.realizarAccion(contexto, posNaveCiencia);
		int poblacionActual = Juego.getInstancia().getJugadorActual().getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Elemento naveCiencia = Juego.getInstancia().obtenerArmadaJugadorActual().obtenerElementoEnPosicion(posNaveCiencia);
		assertEquals(naveCiencia.getSuministro(), poblacionActual);
		
		Juego.getInstancia().cambiarTurno();
		
		poblacionActual = Juego.getInstancia().getJugadorEnemigo().getPoblacionActual();
		int suministro = naveCiencia.getSuministro();
		Juego.getInstancia().eliminarElementoDeJugadorEnemigo(naveCiencia);
		assertEquals(poblacionActual - suministro, jugadorTerran.getPoblacionActual());
	}
	
	@Test
	public void testAumentoDePoblacionActualTerranOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorTerran);
		
		//Creo un Marine
		ContextoStrategy contexto = new ContextoStrategy(new CrearMarine());
		Posicion posBarraca = new Posicion(1,1);
		ElementoArtificial barraca = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_BARRACA, posBarraca);
		Posicion posMarine = new Posicion(100,2);
		barraca.realizarAccion(contexto, posMarine);
		int poblacionActual = jugadorTerran.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad marine = (Unidad) jugadorTerran.obtenerArmada().obtenerElementoEnPosicion(posMarine);
		assertEquals(marine.getSuministro(), poblacionActual);
		
		//Creo un Golliat
		contexto = new ContextoStrategy(new CrearGolliat());
		Posicion posFabrica = new Posicion(2,2);
		ElementoArtificial fabrica = factoryConstruccion.getEdificio(TipoEdificio.TERRAN_FABRICA, posFabrica);
		Posicion posGolliat = new Posicion(2,3);
		fabrica.realizarAccion(contexto, posGolliat);
		poblacionActual = jugadorTerran.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad golliat = (Unidad) jugadorTerran.obtenerArmada().obtenerElementoEnPosicion(posGolliat);
		assertEquals(golliat.getSuministro() + marine.getSuministro(), poblacionActual);	
		
	}
	
	@Test
	public void testAumentoDePoblacionActualProtossOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);		
		//Creo un Zealot
		ContextoStrategy contexto = new ContextoStrategy(new CrearZealot());
		Posicion posAcceso = new Posicion(3,3);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Posicion posZealot = new Posicion(3,2);
		acceso.realizarAccion(contexto, posZealot);
		int poblacionActual = jugadorProtoss.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad zealot = (Unidad) jugadorProtoss.obtenerArmada().obtenerElementoEnPosicion(posZealot);
		assertEquals(zealot.getSuministro(), poblacionActual);
		
		//Creo un Dragon
		contexto = new ContextoStrategy(new CrearDragon());
		Posicion posDragon = new Posicion(300,4);
		acceso.realizarAccion(contexto, posDragon);
		poblacionActual = jugadorProtoss.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad dragon = (Unidad) jugadorProtoss.obtenerArmada().obtenerElementoEnPosicion(posDragon);
		assertEquals(dragon.getSuministro() + zealot.getSuministro(), poblacionActual);
			
	}
	
	@Test
	public void testAumentoDePoblacionActualZealotOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		
		//Creo un Zealot
		ContextoStrategy contexto = new ContextoStrategy(new CrearZealot());
		Posicion posAcceso = new Posicion(3,3);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Posicion posZealot = new Posicion(3,2);
		acceso.realizarAccion(contexto, posZealot);
		int poblacionActual = jugadorProtoss.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad zealot = (Unidad) jugadorProtoss.obtenerArmada().obtenerElementoEnPosicion(posZealot);
		assertEquals(zealot.getSuministro(), poblacionActual);
	}
	
	@Test
	public void testAumentoDePoblacionActualDragonOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		
		//Creo un Dragon
		ContextoStrategy contexto = new ContextoStrategy(new CrearDragon());
		Posicion posAcceso = new Posicion(3,3);
		ElementoArtificial acceso = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ACCESO, posAcceso);
		Posicion posDragon = new Posicion(3,2);
		acceso.realizarAccion(contexto, posDragon);
		int poblacionActual = jugadorProtoss.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad dragon = (Unidad) jugadorProtoss.obtenerArmada().obtenerElementoEnPosicion(posDragon);
		assertEquals(dragon.getSuministro(), poblacionActual);
	}
	@Test
	public void testAumentoDePoblacionActualScoutOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		
		//Creo un Scout
		ContextoStrategy contexto = new ContextoStrategy(new CrearScout());
		Posicion posPuertoEstelar = new Posicion(3,3);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posScout = new Posicion(3,2);
		puertoEstelar.realizarAccion(contexto, posScout);
		int poblacionActual = jugadorProtoss.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad scout = (Unidad) jugadorProtoss.obtenerArmada().obtenerElementoEnPosicion(posScout);
		assertEquals(scout.getSuministro(), poblacionActual);
	}
	
	@Test
	public void testAumentoDePoblacionActualNaveDeTransporteProtossOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);
		
		//Creo una nave de transporte
		ContextoStrategy contexto = new ContextoStrategy(new CrearNaveTransporteProtoss());
		Posicion posPuertoEstelar = new Posicion(3,3);
		ElementoArtificial puertoEstelar = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posPuertoEstelar);
		Posicion posNaveDeTransporte = new Posicion(3,2);
		puertoEstelar.realizarAccion(contexto, posNaveDeTransporte);
		int poblacionActual = jugadorProtoss.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad naveDeTransporte = (Unidad) jugadorProtoss.obtenerArmada().obtenerElementoEnPosicion(posNaveDeTransporte);
		assertEquals(naveDeTransporte.getSuministro(), poblacionActual);
	}
	
	@Test
	public void testAumentoDePoblacionActualAltoTemplariosOk() throws FueraDeRangoException, CostoInvalidoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		Juego.getInstancia().setJugadorActual(jugadorProtoss);

		
		//Creo una nave de transporte
		ContextoStrategy contexto = new ContextoStrategy(new CrearAltoTemplario());
		Posicion posArchivosTemplarios = new Posicion(3,3);
		ElementoArtificial archivosTemplarios = factoryConstruccion.getEdificio(TipoEdificio.PROTOSS_ARCHIVO_TEMPLARIO, posArchivosTemplarios);
		Posicion posAltoTemplario = new Posicion(3,2);
		archivosTemplarios.realizarAccion(contexto, posAltoTemplario);
		int poblacionActual = jugadorProtoss.getPoblacionActual();
		
		//Verifico que la poblacion actual aumento
		Unidad altoTemplario = (Unidad) jugadorProtoss.obtenerArmada().obtenerElementoEnPosicion(posAltoTemplario);
		assertEquals(altoTemplario.getSuministro(), poblacionActual);
	}	
	
}