package factorytest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import exceptions.FactoryInvalidaException;
import factory.AbstractFactory;
import factory.ConstruccionFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.UnidadFactory;

@RunWith(JUnit4.class)
public class AbstractFactoryTest {

	AbstractFactory factory;
	AbstractFactory factoryUnidad;
	AbstractFactory factoryConstruccion;
	
	@Before
	public void setUp() throws FactoryInvalidaException {
		factoryUnidad = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		factoryConstruccion = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);
	}
	@Test
	public void testInstanciacionFactories() {
		assertEquals(UnidadFactory.class,factoryUnidad.getClass());
		assertEquals(ConstruccionFactory.class,factoryConstruccion.getClass());
	}

}
