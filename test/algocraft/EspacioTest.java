package algocraft;

import static org.junit.Assert.*;
import model.CampoBatalla;
import model.Espacio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class EspacioTest {
	
	UnidadFactory factory;
	@Before
	public void setUp(){
		factory = new UnidadFactory();
	}
	
	@After
	public void tearDown(){
		CampoBatalla.DestruirInstancia();
	}
	
	@Test
	public void alCrearseNoDeberiaSerNull() {
		Espacio espacio = new Espacio();
		assertNotNull(espacio);
	}
	
	@Test
	public void alCrearElEspacioNoDeberiaTenerElementos(){
		assertEquals(0, CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
	}
	
	@Test
	public void siEstaElEspacioVacioDeberiaAgregarUnaUnidad() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(5, 5));
		assertEquals(0,CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		assertEquals(1, CampoBatalla.getInstancia().getEspacioTerrestre().getCantidadDeElementos());
	}
	

	@Test (expected = PosicionInvalidaException.class)
	public void alQuererPosicionUnElementoEnUnaPosicionOcupadaDeberiaSerUnaPosicionInvalida() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10, 10));
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		Unidad marine2  = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(9, 8));
		CampoBatalla.getInstancia().posicionarElemento(marine2, CampoBatalla.getInstancia().getEspacioTerrestre());
		
	}
	


	@Test (expected = PosicionInvalidaException.class)
	public void siDosUnidadesEstanAMenosDeUnaPosicionDeDistanciaDeberiaSerUnaPosicionInvalida() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,11));
		Unidad marine2 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(7,7));
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		CampoBatalla.getInstancia().posicionarElemento(marine2, CampoBatalla.getInstancia().getEspacioTerrestre());
	}
	
	@Test (expected = PosicionInvalidaException.class)
	public void siEstaAUnaPosicionDeDistanciaDeberiaSerPosicionValida() throws UnidadInvalidaException, FueraDeRangoException, PosicionInvalidaException{
		Unidad marine1 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,11));
		Unidad marine2 = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(10,14));
		CampoBatalla.getInstancia().posicionarElemento(marine1, CampoBatalla.getInstancia().getEspacioTerrestre());
		CampoBatalla.getInstancia().posicionarElemento(marine2, CampoBatalla.getInstancia().getEspacioTerrestre());
	}
	
	
	

	
}
