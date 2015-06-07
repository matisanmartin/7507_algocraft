package jugadortest;

import static org.junit.Assert.assertEquals;
import model.Armada;
import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import controller.Posicion;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

@RunWith(JUnit4.class)
public class ArmadaTest {
	
	Armada armada;
	AbstractFactory factory;
	Unidad unidadMuerta,unidadMuertaNueva;
	Posicion pos;

	@Before
	public void setUp() throws Exception {
		pos=new Posicion(1,2);
		armada=new Armada();
		factory = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		
		unidadMuerta = factory.getUnidad(TipoUnidad.TERRAN_MARINE);
		unidadMuerta.posicionar(pos);
		unidadMuerta.setVida("0");
		
		unidadMuertaNueva = factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT);
		unidadMuertaNueva.setVida("0");
		unidadMuertaNueva.posicionar(new Posicion(2,3));
	}

	@Test
	public void testArmadaVaciaDimension0() {
		assertEquals(0,armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaConUnElementoDimension1() {
		armada.agregarElemento(unidadMuerta);
		assertEquals(1,armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaEliminarElementoEnPosicion() {
		armada.agregarElemento(unidadMuerta);
		Posicion posicion = unidadMuerta.getPosicion();
		armada.eliminarElementoMuertoEnPosicion(posicion);
		assertEquals(0, armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaConVariosElementosEliminarElementoEnPosicion() throws FueraDeRangoException, ElementoNoEncontradoException {
		
		armada.agregarElemento(unidadMuerta);
		armada.agregarElemento(unidadMuertaNueva);
		
		armada.eliminarElementoMuertoEnPosicion(new Posicion(2,3));
		assertEquals(1,armada.getDimensionArmada());
		
		ElementoArtificial ElementoUnico = armada.obtenerElementoEnPosicion(pos);
		assertEquals(true,pos.equals(ElementoUnico.getPosicion()));	
	}

}
