package strategytest;

import static org.junit.Assert.assertEquals;
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
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import controller.JuegoController;
import exceptions.ColorInvalidoException;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.NombreCortoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.construcciones.Acceso;
import factory.construcciones.ArchivoTemplario;
import factory.construcciones.Barraca;
import factory.construcciones.Edificio;
import factory.construcciones.Fabrica;
import factory.construcciones.PuertoEstelarProtoss;
import factory.construcciones.PuertoEstelarTerran;
import factory.unidades.Unidad;

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
		//TODO descomentar luego
		jugadorActualTerran.agregarCantidadDeCristal(2000);
		jugadorActualTerran.agregarCantidadDeGas(2000);
//		jugadorActualProtoss = new Jugador("jugadorProtoss",TipoColor.COLOR_ROJO,new Protoss());

		JuegoController.getInstancia().setJugadorActual(jugadorActualTerran);

	}
	
	/*
	 * Jugador pide a Acceso crear Zealot
	 */
	@Test
	public void testJugadorConAccesoCreaZealot() throws FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {

		Edificio edificio = new Acceso(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(edificio);
		contexto = new ContextoStrategy(new CrearZealot());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		ElementoArtificial accesoObtenido = armada.obtenerElementoEnPosicion(posicionOrigen);
		accesoObtenido.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad) JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(2,unidad.getTransporte());
		assertEquals(7, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("100M")));
		assertEquals(4, unidad.getTiempoConstruccion());	
		assertEquals("0A8T", unidad.getDaño());
		assertEquals("0A1T", unidad.getRangoAtaque());
		assertEquals(true, unidad.getVitalidad().equals(new Vitalidad(100,60)));
	}
	
	/*
	 * Jugador pide Archivo templario crea alto templario
	 */
	@Test
	public void testJugadorConArchivoTemplarioCreaAltoTemplario() throws ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		Edificio acceso = new ArchivoTemplario(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(acceso);
		contexto = new ContextoStrategy(new CrearAltoTemplario());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		Edificio accesoObtenido = (Edificio) armada.obtenerElementoEnPosicion(posicionOrigen);
		accesoObtenido.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad)JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(2,unidad.getTransporte());
		assertEquals(7, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("50M150G")));
		assertEquals(7, unidad.getTiempoConstruccion());	
		assertEquals("0A0T", unidad.getDaño());
		assertEquals("0A0T", unidad.getRangoAtaque());
		assertEquals(true, unidad.getVitalidad().equals(new Vitalidad(40,40)));	
		
		
	}
	
	/*
	 * Jugador pide a barraca crear marine
	 */
	@Test
	public void testJugadorConBarracaCreaMarine() throws ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		Edificio barraca = new Barraca(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(barraca);
		contexto = new ContextoStrategy(new CrearMarine());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		Edificio barracaObtenida = (Edificio) armada.obtenerElementoEnPosicion(posicionOrigen);
		barracaObtenida.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad) JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(1,unidad.getTransporte());
		assertEquals(7, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("50M")));
		assertEquals(3, unidad.getTiempoConstruccion());	
		assertEquals("6A6T", unidad.getDaño());
		assertEquals("0A4T", unidad.getRangoAtaque());
		assertEquals(40, unidad.getVida());	

	}
	
	/*
	 * Jugador pide a fabrica crear golliat
	 */
	@Test
	public void testJugadorConFabricaCreaGolliat() throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		Edificio fabrica = new Fabrica(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(fabrica);
		contexto = new ContextoStrategy(new CrearGolliat());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		Edificio fabricaObtenida = (Edificio) armada.obtenerElementoEnPosicion(posicionOrigen);
		fabricaObtenida.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad) JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(2,unidad.getTransporte());
		assertEquals(8, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("100M50G")));
		assertEquals(6, unidad.getTiempoConstruccion());	
		assertEquals("10A12T", unidad.getDaño());
		assertEquals("5A6T", unidad.getRangoAtaque());
		assertEquals(125, unidad.getVida());	
	}
	
	/*
	 * Jugador pide a puerto estelar protoss crear scout
	 */
	@Test
	public void testJugadorConPuertoEstelarProtossCreaScout() throws FueraDeRangoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		Edificio puertoEstelarProtoss = new PuertoEstelarProtoss(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarProtoss);
		contexto = new ContextoStrategy(new CrearScout());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		Edificio puertoEstelarProtossObtenido = (Edificio) armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarProtossObtenido.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad) JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(0,unidad.getTransporte());
		assertEquals(7, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("300M150G")));
		assertEquals(9, unidad.getTiempoConstruccion());	
		assertEquals("14A8T", unidad.getDaño());
		assertEquals("4A0T", unidad.getRangoAtaque());
		assertEquals(true, unidad.getVitalidad().equals(new Vitalidad(150,100)));	

		
	}
	
	/*
	 * Jugador pide a puerto estelar protoss crear nave de transporte
	 */
	@Test
	public void testJugadorConPuertoEstelarProtossCreaNaveTransporteProtoss() throws ElementoNoEncontradoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		Edificio puertoEstelarProtoss = new PuertoEstelarProtoss(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarProtoss);
		contexto = new ContextoStrategy(new CrearNaveTransporteProtoss());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		Edificio puertoEstelarProtossObtenido = (Edificio) armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarProtossObtenido.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad) JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(8,unidad.getTransporte());
		assertEquals(8, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("200M")));
		assertEquals(8, unidad.getTiempoConstruccion());	
		assertEquals("0A0T", unidad.getDaño());
		assertEquals("0A0T", unidad.getRangoAtaque());
		assertEquals(true, unidad.getVitalidad().equals(new Vitalidad(80,60)));	
		
	}
	
	/*
	 * Jugador pide a puerto estelar terran crear espectro
	 */
	@Test
	public void testJugadorConPuertoEstelarTerranCreaEspectro() throws FueraDeRangoException, ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		Edificio puertoEstelarTerran = new PuertoEstelarTerran(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarTerran);
		contexto = new ContextoStrategy(new CrearEspectro());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		Edificio puertoEstelarTerranObtenido = (Edificio) armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarTerranObtenido.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad) JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(0,unidad.getTransporte());
		assertEquals(7, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("150M100G")));
		assertEquals(8, unidad.getTiempoConstruccion());	
		assertEquals("20A8T", unidad.getDaño());
		assertEquals("5A0T", unidad.getRangoAtaque());
		assertEquals(120, unidad.getVida());	
		
	}
	
	/*
	 * Jugador pide a puerto estelar terran crear nave de transporte
	 */
	@Test
	public void testJugadorConPuertoEstelarTerranCreaNaveTransporteTerran() throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		Edificio puertoEstelarTerran = new PuertoEstelarTerran(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarTerran);
		contexto = new ContextoStrategy(new CrearNaveTransporteTerran());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		Edificio puertoEstelarTerranObtenido = (Edificio) armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarTerranObtenido.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad) JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(8,unidad.getTransporte());
		assertEquals(8, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("100M100G")));
		assertEquals(7, unidad.getTiempoConstruccion());	
		assertEquals("0A0T", unidad.getDaño());
		assertEquals("0A0T", unidad.getRangoAtaque());
		assertEquals(150, unidad.getVida());	
	}
	
	@Test
	public void testJugadorConPuertoEstelarTerranCreaNaveCiencia() throws ElementoNoEncontradoException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		Edificio puertoEstelarTerran = new PuertoEstelarTerran(2, 2, posicionOrigen);
		JuegoController.getInstancia().agregarUnidadAJugadorActual(puertoEstelarTerran);
		contexto = new ContextoStrategy(new CrearNaveCiencia());
		armada = JuegoController.getInstancia().getJugadorActual().obtenerArmada();
		Edificio puertoEstelarTerranObtenido = (Edificio) armada.obtenerElementoEnPosicion(posicionOrigen);
		puertoEstelarTerranObtenido.realizarAccion(contexto, posicionDestino);
		Unidad unidad = (Unidad) JuegoController.getInstancia().getJugadorActual().obtenerArmada().obtenerElementoEnPosicion(posicionDestino);
		assertEquals(0,unidad.getTransporte());
		assertEquals(10, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo("100M225G")));
		assertEquals(10, unidad.getTiempoConstruccion());	
		assertEquals("0A0T", unidad.getDaño());
		assertEquals("0A0T", unidad.getRangoAtaque());
		assertEquals(200, unidad.getVida());	

		
	}

}
