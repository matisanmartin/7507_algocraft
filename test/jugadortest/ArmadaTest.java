package jugadortest;

import static org.junit.Assert.assertEquals;
import model.Armada;
import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import common.Posicion;
import common.Vitalidad;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
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
		
		unidadMuerta = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		unidadMuerta.posicionar(pos);
		unidadMuerta.setVitalidad(new Vitalidad(0,0));
		
		unidadMuertaNueva = factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, new Posicion(1, 1));
		unidadMuertaNueva.setVitalidad(new Vitalidad(0,0));
		unidadMuertaNueva.posicionar(new Posicion(2,3));
	}

	@Test
	public void testArmadaVaciaDimension0() {
		assertEquals(0,armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaConUnElementoDimension1() throws PosicionInvalidaException {
		armada.agregarElemento(unidadMuerta);
		assertEquals(1,armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaEliminarElementoEnPosicion() throws PosicionInvalidaException {
		armada.agregarElemento(unidadMuerta);
		Posicion posicion = unidadMuerta.getPosicion();
		armada.eliminarElementoMuertoEnPosicion(posicion);
		assertEquals(0, armada.getDimensionArmada());
	}
	
	@Test
	public void testArmadaConVariosElementosEliminarElementoEnPosicion() throws FueraDeRangoException, ElementoNoEncontradoException, PosicionInvalidaException {
		
		armada.agregarElemento(unidadMuerta);
		armada.agregarElemento(unidadMuertaNueva);
		
		armada.eliminarElementoMuertoEnPosicion(new Posicion(2,3));
		assertEquals(1,armada.getDimensionArmada());
		
		ElementoArtificial ElementoUnico = armada.obtenerElementoEnPosicion(pos);
		assertEquals(true,pos.equals(ElementoUnico.getPosicion()));	
	}

}
