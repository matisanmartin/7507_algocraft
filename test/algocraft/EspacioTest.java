package algocraft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.CampoBatalla;
import model.Espacio;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vista.VentanaMock;

import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class EspacioTest {
	
	UnidadFactory factory;
	@Before
	public void setUp() throws FueraDeRangoException, PosicionInvalidaException{
		factory = new UnidadFactory();
		Juego.crearInstancia(new VentanaMock());
	}
	
	@After
	public void tearDown(){
		CampoBatalla.DestruirInstancia();
		Juego.destruirInstancia();
	}
	
	@Test
	public void alCrearseNoDeberiaSerNull() {
		Espacio espacio = new Espacio();
		assertNotNull(espacio);
	}
	
	@Test
	public void alCrearElEspacioNoDeberiaTenerElementos() throws PosicionInvalidaException, FueraDeRangoException{
		assertEquals(0, CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
	}
	
	@Test
	public void siEstaElEspacioVacioDeberiaAgregarUnaUnidad() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException, UnidadLlenaException, DanioInvalidoException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(5, 5));
		assertEquals(0,CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		assertEquals(1, CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
	}
	

	@Test (expected = PosicionInvalidaException.class)
	public void alQuererPosicionUnElementoEnUnaPosicionOcupadaDeberiaSerUnaPosicionInvalida() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException, UnidadLlenaException, DanioInvalidoException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10, 10));
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		Unidad marine2  = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10, 8));
		CampoBatalla.getInstancia().posicionarElemento(marine2, CampoBatalla.getInstancia().getEspacioTerrestre());
		
	}
	


	@Test (expected = PosicionInvalidaException.class)
	public void siDosUnidadesEstanAMenosDeUnaPosicionDeDistanciaDeberiaSerUnaPosicionInvalida() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException, UnidadLlenaException, DanioInvalidoException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,11));
		Unidad marine2 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(7,7));
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		CampoBatalla.getInstancia().posicionarElemento(marine2, CampoBatalla.getInstancia().getEspacioTerrestre());
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void siEstaAUnaPosicionDeDistanciaDeberiaSerPosicionValida() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException, UnidadLlenaException, DanioInvalidoException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,11));
		Unidad marine2 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,14));
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		CampoBatalla.getInstancia().posicionarElemento(marine2, CampoBatalla.getInstancia().getEspacioTerrestre());
	}
	
	@Test
	public void dosUnidadesTerrestresPertenecenAlMismoEspacio() throws PosicionInvalidaException, FueraDeRangoException, UnidadLlenaException, UnidadInvalidaException, CostoInvalidoException, DanioInvalidoException{
		Unidad unidad1, unidad2 = null;
		UnidadFactory factory = new UnidadFactory();
		unidad1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(30,30));
		unidad2 = factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, new Posicion(100, 100));
		assertEquals(unidad1.getEspacio(), unidad2.getEspacio());
		
	}

	
	@Test
	public void unaUnidadTerrestreYUnaUnidadAereaNoPertencenAlMismoEspacio() throws UnidadLlenaException, UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, DanioInvalidoException, PosicionInvalidaException{
		Unidad unidad1, unidad2 = null;
		UnidadFactory factory = new UnidadFactory();
		unidad1 = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(10, 10));
		unidad2 = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, new Posicion(4, 4));
		assertEquals(false,unidad1.getEspacio().equals(unidad2.getEspacio()));
		
		
	}
	
	@Test
	public void dosUnidadesAereasPertenecenAlMismoEspacio() throws UnidadLlenaException, UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, DanioInvalidoException, PosicionInvalidaException{
		Unidad unidad1, unidad2 = null;
		UnidadFactory factory = new UnidadFactory();
		unidad1 = factory.getUnidad(TipoUnidad.PROTOSS_NAVE_TRANSPORTE, new Posicion(10, 10));
		unidad2 = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, new Posicion(40, 40));
		assertEquals(unidad1.getEspacio(), unidad2.getEspacio());
	}
	
	
	

	
}
