package strategytest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;
import model.Juego;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import razas.Protoss;
import razas.Terran;
import strategy.Ataque;
import strategy.ContextoStrategy;
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
		
		jugadorActual = new Jugador("jugador1",TipoColor.COLOR_ROJO,new Terran());
		jugadorEnemigo = new Jugador("jugador2",TipoColor.COLOR_AZUL,new Protoss());
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
	
		contexto = new ContextoStrategy(new Ataque());
		factory = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionEnRango = new Posicion(1,2);
		unidadDefensoraEnRango=factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, posicionEnRango);
		
		posicionFueraDeRango = new Posicion(10,10);
		unidadDefensoraFueraDeRango=factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, posicionFueraDeRango);	
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
	 */
	@Test
	public void testMarineAtacaUnidadEnemigaEnRango() 
	throws UnidadInvalidaException, FactoryInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException {	
		
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
	 */
	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testMarineAtacaUnidadEnemigaFueraDeRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException {
		Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraFueraDeRango);
		unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
		
		assertEquals("60",Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getVida());
	}

}
