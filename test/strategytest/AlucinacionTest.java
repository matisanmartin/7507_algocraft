package strategytest;

import jugador.Jugador;
import jugador.TipoColor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import razas.Protoss;
import razas.Terran;
import strategy.Alucinacion;
import strategy.ContextoStrategy;
import common.Posicion;
import controller.JuegoController;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

@RunWith(JUnit4.class)
public class AlucinacionTest {

	ContextoStrategy contexto;
	UnidadFactory factory;
	Unidad unidadAtacante;
	Unidad unidadAtacadaEnRango;
	Unidad unidadAtacadaFueraDeRango;
	Jugador jugadorActual;
	Jugador jugadorEnemigo;
	Posicion posicionUnidadAtacante;
	Posicion posicionUnidadAtacadaEnRango;
	Posicion posicionUnidadAtacadaFueraDeRango;
	
	
	@Before
	public void setUp() throws Exception {
		
		factory = new UnidadFactory();
		contexto=new ContextoStrategy(new Alucinacion());
		
		jugadorActual = new Jugador("jugador1",TipoColor.COLOR_ROJO,new Terran());
		posicionUnidadAtacante = new Posicion(2,2);
		unidadAtacante=factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, posicionUnidadAtacante);
		jugadorActual.agregarElemento(unidadAtacante);
		JuegoController.getInstancia().setJugadorActual(jugadorActual);

		jugadorEnemigo = new Jugador("jugador2",TipoColor.COLOR_AZUL,new Protoss());
		posicionUnidadAtacadaEnRango = new Posicion(2,4);//El rango de vision del alto templario es 7
		unidadAtacadaEnRango=factory.getUnidad(TipoUnidad.TERRAN_MARINE,posicionUnidadAtacadaEnRango);
		jugadorEnemigo.agregarElemento(unidadAtacadaEnRango);
		
		posicionUnidadAtacadaFueraDeRango = new Posicion(15,20);//El rango de vision del alto templario es 7
		unidadAtacadaFueraDeRango=factory.getUnidad(TipoUnidad.TERRAN_MARINE,posicionUnidadAtacadaFueraDeRango);
		jugadorEnemigo.agregarElemento(unidadAtacadaFueraDeRango);
		
		JuegoController.getInstancia().setJugadorEnemigo(jugadorEnemigo);
	
	}

	/**
	 * La posicion de la unidad del jugador actual es (2,2), por lo tanto deberian crearse una en (3,2) y otra en (1,2)
	 * Si tira excepcion, el test falla
	 * @throws CostoInvalidoException 
	 * @throws RecursosInsuficientesException 
	 */
	@Test
	public void testAlucinacionCreaUnidadesGemelasYEnemigoEstaEnRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		
		unidadAtacante.setEnergia(100);
		unidadAtacante.realizarAccion(contexto, posicionUnidadAtacadaEnRango);
		
		
		JuegoController.getInstancia()
					   .getJugadorActual()
					   .obtenerArmada()
					   .obtenerElementoEnPosicion(new Posicion(3,2));
		
		JuegoController.getInstancia()
					   .getJugadorActual()
					   .obtenerArmada()
					   .obtenerElementoEnPosicion(new Posicion(1,2));
		
	}
	
	
	/**
	 * Test "negativo" debería tirar excepcion si el jugador está fuera de rango de vision de la unidad que ataca
	 * @throws CostoInvalidoException 
	 * @throws RecursosInsuficientesException 
	 */
	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testAlucinacionCreaUnidadesEnemigoNoEstaEnRango() 
	throws ElementoNoEncontradoException, FueraDeRangoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		unidadAtacante.setEnergia(100);
		unidadAtacante.realizarAccion(contexto, posicionUnidadAtacadaFueraDeRango);
	}
	
	/**
	 * Test "negativo", tiene 50 de vida y se requiere 100 para poder  hacer el ataque
	 * @throws CostoInvalidoException 
	 * @throws RecursosInsuficientesException 
	 */
	@Test(expected = EnergiaInsuficienteException.class)
	public void testAlucinacionUnidadConEnergiaInsuficiente() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
//		unidadAtacante.setVitalidad(new Vitalidad(150,0));
		unidadAtacante.realizarAccion(contexto, posicionUnidadAtacadaEnRango);
	}
	
}
