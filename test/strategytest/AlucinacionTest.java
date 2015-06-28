package strategytest;

import java.io.IOException;

import jugador.Jugador;
import model.CampoBatalla;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import strategy.Alucinacion;
import strategy.ContextoStrategy;
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
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class AlucinacionTest {

	ContextoStrategy contexto;
	UnidadFactory factory;
	Unidad unidadAtacante;
	Unidad unidadAmigaEnRango;
	Unidad unidadAmigaFueraDeRango;
	Jugador jugadorActual;
	Jugador jugadorEnemigo;
	Posicion posicionUnidadAtacante;
	Posicion posicionUnidadAmigaEnRango;
	Posicion posicionUnidadAmigaFueraDeRango;
	
	
	@Before
	public void setUp() throws Exception {
		
		Juego.crearInstancia(new VentanaMock());
		factory = new UnidadFactory();
		contexto=new ContextoStrategy(new Alucinacion());
		
		jugadorActual = new Jugador("jugador1","terran","rojo");
		jugadorEnemigo = new Jugador("jugador2","protoss","azul");
		jugadorActual.setPoblacionDisponible(2000);
		posicionUnidadAtacante = new Posicion(200,20);
		unidadAtacante=factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, posicionUnidadAtacante);
		jugadorActual.agregarElemento(unidadAtacante);
		Juego.getInstancia().setJugadorActual(jugadorActual);

		posicionUnidadAmigaEnRango = new Posicion(150,200);//El rango de vision del alto templario es 7
		unidadAmigaEnRango=factory.getUnidad(TipoUnidad.TERRAN_MARINE,posicionUnidadAmigaEnRango);
		jugadorActual.agregarElemento(unidadAmigaEnRango);
		
		posicionUnidadAmigaFueraDeRango = new Posicion(800,200);//El rango de vision del alto templario es 7
		unidadAmigaFueraDeRango=factory.getUnidad(TipoUnidad.TERRAN_MARINE,posicionUnidadAmigaFueraDeRango);
		jugadorActual.agregarElemento(unidadAmigaFueraDeRango);
		
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
	
	}
	
	@After
	public void destroy(){
		CampoBatalla.DestruirInstancia();
		Juego.destruirInstancia();
	}

	/**
	 * La posicion de la unidad del jugador actual es (2,2), por lo tanto deberian crearse una en (3,2) y otra en (1,2)
	 * Si tira excepcion, el test falla
	 */
	@Test
	public void testAlucinacionCreaUnidadesGemelasYEnemigoEstaEnRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		
		try {
			unidadAtacante.setEnergia(100);
			unidadAtacante.realizarAccion(contexto, posicionUnidadAmigaEnRango);
			
			
			
		} catch (PartidaGanadaException e) {
			
			Juego.getInstancia()
			   .getJugadorActual()
			   .obtenerArmada()
			   .obtenerElementoEnPosicion(new Posicion(231,20));

			Juego.getInstancia()
			   .getJugadorActual()
			   .obtenerArmada()
			   .obtenerElementoEnPosicion(new Posicion(169,20));

		}
		
	}
	
	
	/**
	 * Test "negativo" debería tirar excepcion si el jugador está fuera de rango de vision de la unidad que ataca
	 */
	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testAlucinacionCreaUnidadesEnemigoNoEstaEnRango() 
	throws ElementoNoEncontradoException, FueraDeRangoException, FactoryInvalidaException, UnidadInvalidaException, ElementoInvalidoException, PosicionInvalidaException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		unidadAtacante.setEnergia(100);
		unidadAtacante.realizarAccion(contexto, posicionUnidadAmigaFueraDeRango);
	}
	
	/**
	 * Test "negativo", tiene 50 de vida y se requiere 100 para poder  hacer el ataque
	 */
	@Test(expected = EnergiaInsuficienteException.class)
	public void testAlucinacionUnidadConEnergiaInsuficiente() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		unidadAtacante.realizarAccion(contexto, posicionUnidadAmigaEnRango);
	}
	
}
