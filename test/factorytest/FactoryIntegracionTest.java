package factorytest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import common.Posicion;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

@RunWith(JUnit4.class)
public class FactoryIntegracionTest {

	AbstractFactory factory;
	AbstractFactory factoryUnidad;
	AbstractFactory factoryConstruccion;
	
	Unidad unidadObtenida;
	
	@Before
	public void setUp() throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException {
		factoryUnidad = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		factoryConstruccion = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);	
		unidadObtenida = factoryUnidad.getUnidad(TipoUnidad.TERRAN_MARINE,new Posicion(1, 1));
	}
	
	@Test
	public void testObtengoMarine() {	
		assertEquals(Unidad.class,unidadObtenida.getClass());
		assertEquals(UnidadFactory.UNIDAD_MARINE_TRANSPORTE, unidadObtenida.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_MARINE_VISION, unidadObtenida.getVision());
		assertEquals(UnidadFactory.UNIDAD_MARINE_COSTO, unidadObtenida.getCosto());
		assertEquals(UnidadFactory.UNIDAD_MARINE_DAÑO, unidadObtenida.getDaño());
		assertEquals(UnidadFactory.UNIDAD_MARINE_RANGO_ATAQUE, unidadObtenida.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_MARINE_SUMINISTRO, unidadObtenida.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_MARINE_VIDA, unidadObtenida.getVida());
		assertEquals(UnidadFactory.UNIDAD_MARINE_TIEMPO_CONSTRUCCION, unidadObtenida.getTiempoConstruccion());
	}

}
