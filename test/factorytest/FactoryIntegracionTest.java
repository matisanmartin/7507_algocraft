package factorytest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import common.Costo;
import common.Danio;
import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
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
	public void setUp() throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, DanioInvalidoException, UnidadLlenaException {
		factoryUnidad = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		factoryConstruccion = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);	
		unidadObtenida = factoryUnidad.getUnidad(TipoUnidad.TERRAN_MARINE,new Posicion(1, 1));
	}
	
	@Test
	public void testObtengoMarine() throws CostoInvalidoException, DanioInvalidoException {	
		assertEquals(Unidad.class,unidadObtenida.getClass());
		assertEquals(UnidadFactory.UNIDAD_MARINE_TRANSPORTE, unidadObtenida.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_MARINE_VISION, unidadObtenida.getVision());
		assertEquals(true, unidadObtenida.getCosto().equals(new Costo(UnidadFactory.UNIDAD_MARINE_COSTO)));
		assertEquals(true, unidadObtenida.getDanio().equals(new Danio(UnidadFactory.UNIDAD_MARINE_DAÑO)));
		assertEquals(UnidadFactory.UNIDAD_MARINE_RANGO_ATAQUE, unidadObtenida.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_MARINE_SUMINISTRO, unidadObtenida.getSuministro());
		assertEquals(40, unidadObtenida.getVida());
		assertEquals(UnidadFactory.UNIDAD_MARINE_TIEMPO_CONSTRUCCION, unidadObtenida.getTiempoConstruccion());
	}

}
