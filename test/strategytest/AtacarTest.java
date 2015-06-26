package strategytest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jugador.Jugador;
import model.CampoBatalla;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import strategy.Ataque;
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
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

@RunWith(JUnit4.class)
public class AtacarTest {

	ContextoStrategy contexto;
	AbstractFactory factory;
	Unidad unidadAtacante;
	Unidad unidadDefensoraEnRango;
	Unidad unidadDefensoraFueraDeRango;
	Posicion posicionAtacante;
	Posicion posicionEnRango;
	Posicion posicionFueraDeRango;
	Jugador jugadorActual;
	Jugador jugadorEnemigo;
	
	@Before
	public void setUp() throws Exception {
		
		Juego.crearInstancia(new VentanaMock());
		
		jugadorActual = new Jugador("jugador1","terran","rojo");
		jugadorEnemigo = new Jugador("jugador2","protoss","azul");
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
	
		contexto = new ContextoStrategy(new Ataque());
		factory = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionEnRango = new Posicion(1,2);
		unidadDefensoraEnRango=factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, posicionEnRango);
		
		posicionFueraDeRango = new Posicion(800,10);
		unidadDefensoraFueraDeRango=factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, posicionFueraDeRango);	
	}

	
	@After
	public void destroy(){
		CampoBatalla.DestruirInstancia();
	}
	/**
	 * Un Marine ataca a un zealot en rango, por lo tanto, como el daño del Marine es 6
	 * el escudo del Zealot deberia resultar en 60-6 (ya que daña el escudo y no llega a quitarle vida)
	 * @throws CostoInvalidoException 
	 * @throws RecursosInsuficientesException 
	 * @throws CloneNotSupportedException 
	 * @throws PartidaPerdidaException 
	 * @throws PartidaGanadaException 
	 * @throws FinDePartidaException 
	 * @throws UnidadLlenaException 
	 * @throws PoblacionFaltanteException 
	 * @throws RecursosFaltantesException 
	 * @throws DanioInvalidoException 
	 * @throws IOException 
	 */
	@Test
	public void testMarineAtacaUnidadEnemigaEnRango() 
	throws UnidadInvalidaException, FactoryInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {	
		
		try
		{
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraEnRango);
			unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
			
					
		}
		catch(PartidaPerdidaException ppe)
		{
			assertEquals(52,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getEscudo());
		}
		
	}

	/**
	 * Un marine ataca a un zealot fuera de rango, por lo tanto, debería tirar excepcion
	 * @throws CostoInvalidoException 
	 * @throws RecursosInsuficientesException 
	 * @throws CloneNotSupportedException 
	 * @throws PartidaPerdidaException 
	 * @throws PartidaGanadaException 
	 * @throws FinDePartidaException 
	 * @throws UnidadLlenaException 
	 * @throws PoblacionFaltanteException 
	 * @throws RecursosFaltantesException 
	 * @throws DanioInvalidoException 
	 * @throws IOException 
	 */
	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testMarineAtacaUnidadEnemigaFueraDeRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException {
		try
		{
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraFueraDeRango);
			unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
			
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraFueraDeRango);
			unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
			
		}
		catch(PartidaPerdidaException ppe)
		{
			assertEquals("60",Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getVida());
		}
	
	}

}
