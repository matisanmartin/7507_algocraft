package integraciontest;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import jugador.Jugador;
import jugador.TipoColor;
import model.Juego;

import org.junit.Before;
import org.junit.Test;

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

/**
 * 
 * Unidades de tierra no pueden atacar unidades de aire y viceversa en todas las combinaciones,
 * cuando se corresponda
 *
 */
public class Enunciado4Test {

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
		
		jugadorActual = new Jugador("jugador1","terran","rojo");
		jugadorEnemigo = new Jugador("jugador2","protoss","azul");
		
		Juego.getInstancia().setJugadorActual(jugadorActual);
		Juego.getInstancia().setJugadorEnemigo(jugadorEnemigo);
	
		contexto = new ContextoStrategy(new Ataque());
		factory = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);

	}
	
	/**
	 * Un Marine ataca a un golliat en rango, por lo tanto, como el daño del Marine es 6
	 * el escudo del golliat deberia resultar en 60-6 (ya que daña el escudo y no llega a quitarle vida)
	 * @throws CostoInvalidoException 
	 * @throws RecursosInsuficientesException 
	 * @throws CloneNotSupportedException 
	 * @throws PartidaPerdidaException 
	 * @throws PartidaGanadaException 
	 * @throws FinDePartidaException 
	 * @throws DanioInvalidoException 
	 * @throws UnidadLlenaException 
	 * @throws PoblacionFaltanteException 
	 * @throws RecursosFaltantesException 
	 * @throws IOException 
	 */
	@Test
	public void testMarineAtacaGolliatEnRango() 
	throws UnidadInvalidaException, FactoryInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {	
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionEnRango = new Posicion(1,2);
		unidadDefensoraEnRango=factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, posicionEnRango);
		
		try
		{
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraEnRango);
			unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
			
			assertEquals(119,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getEscudo());		
		}
		catch(PartidaPerdidaException pge)
		{}
	//	goliat zealot drag scout espectro
	}
	
	/**
	 * Un marine ataca a un golliat fuera de rango, por lo tanto, debería tirar excepcion
	 * @throws CostoInvalidoException 
	 * @throws RecursosInsuficientesException 
	 * @throws CloneNotSupportedException 
	 * @throws PartidaPerdidaException 
	 * @throws PartidaGanadaException 
	 * @throws FinDePartidaException 
	 * @throws DanioInvalidoException 
	 * @throws UnidadLlenaException 
	 * @throws PoblacionFaltanteException 
	 * @throws RecursosFaltantesException 
	 * @throws IOException 
	 */
	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testMarineAtacaGolliatFueraDeRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionFueraDeRango = new Posicion(10,10);
		unidadDefensoraFueraDeRango=factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, posicionFueraDeRango);	

		Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraFueraDeRango);
		unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
		
		assertEquals(125,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getVida());
	}
	
	@Test
	public void testMarineAtacaMarineEnRango() 
	throws UnidadInvalidaException, FactoryInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {	
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		try 
		{
			posicionEnRango = new Posicion(1,2);
			unidadDefensoraEnRango=factory.getUnidad(TipoUnidad.TERRAN_MARINE, posicionEnRango);
			
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraEnRango);
			unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
				
			assertEquals(34,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getEscudo());		
		}
		catch(PartidaPerdidaException pge)
		{}
	}

	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testMarineAtacaMarineFueraDeRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionFueraDeRango = new Posicion(10,10);
		unidadDefensoraFueraDeRango=factory.getUnidad(TipoUnidad.TERRAN_MARINE, posicionFueraDeRango);	

		Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraFueraDeRango);
		unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
		
		assertEquals(40,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getVida());
	}
	
	@Test
	public void testMarineAtacaEspectroEnRango() 
	throws UnidadInvalidaException, FactoryInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {	
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionEnRango = new Posicion(1,2);
		unidadDefensoraEnRango=factory.getUnidad(TipoUnidad.TERRAN_ESPECTRO, posicionEnRango);
		
		try
		{
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraEnRango);
			unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
						
		}
		catch(PartidaPerdidaException pge)
		{
			assertEquals(120,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getVida());
		}
	}

	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testMarineAtacaEspectroFueraDeRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));

		posicionFueraDeRango = new Posicion(10,10);
		unidadDefensoraFueraDeRango=factory.getUnidad(TipoUnidad.TERRAN_ESPECTRO, posicionFueraDeRango);	

		Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraFueraDeRango);
		unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
	}

	@Test
	public void testMarineAtacaNaveCienciaTerranEnRango() 
	throws UnidadInvalidaException, FactoryInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {	
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionEnRango = new Posicion(1,2);
		unidadDefensoraEnRango=factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, posicionEnRango);
		
		try{
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraEnRango);
			unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());		
		}
		catch(PartidaPerdidaException pge){
			assertEquals(200,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getVida());
		}
	}

	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testMarineAtacaNaveCienciaTerranFueraDeRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionFueraDeRango = new Posicion(10,10);
		unidadDefensoraFueraDeRango=factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, posicionFueraDeRango);	

		Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraFueraDeRango);
		unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
	}
	
	@Test
	public void testMarineAtacaNaveTransporteTerranEnRango() 
	throws UnidadInvalidaException, FactoryInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {	
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionEnRango = new Posicion(1,2);
		unidadDefensoraEnRango=factory.getUnidad(TipoUnidad.TERRAN_NAVE_TRANSPORTE, posicionEnRango);
		
		try{
			Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraEnRango);
			unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());			
		}
		catch(PartidaPerdidaException pge){
			assertEquals(150,Juego.getInstancia().getJugadorEnemigo().obtenerArmada().getArmada().get(0).getVida());
		}
	}

	@Test(expected = FueraDeRangoDeVisionException.class)
	public void testMarineAtacaNaveTransporteTerranFueraDeRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, IOException {
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		
		posicionFueraDeRango = new Posicion(10,10);
		unidadDefensoraFueraDeRango=factory.getUnidad(TipoUnidad.TERRAN_NAVE_TRANSPORTE, posicionFueraDeRango);	

		Juego.getInstancia().agregarUnidadAJugadorEnemigo(unidadDefensoraFueraDeRango);
		unidadAtacante.realizarAccion(contexto,Juego.getInstancia().obtenerArmadaJugadorEnemigo().getArmada().get(0).getPosicion());
	}

}
