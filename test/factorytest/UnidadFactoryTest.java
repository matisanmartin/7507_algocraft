package factorytest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.AltoTemplario;
import factory.unidades.Dragon;
import factory.unidades.Espectro;
import factory.unidades.Golliat;
import factory.unidades.Marine;
import factory.unidades.NaveCiencia;
import factory.unidades.NaveTransporteProtoss;
import factory.unidades.NaveTransporteTerran;
import factory.unidades.Scout;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;
import factory.unidades.Zealot;


@RunWith(JUnit4.class)
public class UnidadFactoryTest {

	Unidad unidad;
	UnidadFactory factory;
	
	@Before
	public void setUp(){
		factory = new UnidadFactory();
	}

	
	@Test
	public void testInstanciasCorrectasTerran() throws UnidadInvalidaException {
		assertEquals(Marine.class,factory.getUnidad(TipoUnidad.TERRAN_MARINE).getClass());
		assertEquals(Golliat.class,factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT).getClass());
		assertEquals(Espectro.class,factory.getUnidad(TipoUnidad.TERRAN_ESPECTRO).getClass());
		assertEquals(NaveCiencia.class,factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA).getClass());
		assertEquals(NaveTransporteTerran.class,factory.getUnidad(TipoUnidad.TERRAN_NAVE_TRANSPORTE).getClass());
	}
	
	@Test
	public void testInstanciasCorrectaProtoss() throws UnidadInvalidaException {
		assertEquals(Zealot.class,factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT).getClass());
		assertEquals(Dragon.class,factory.getUnidad(TipoUnidad.PROTOSS_DRAGON).getClass());
		assertEquals(Scout.class,factory.getUnidad(TipoUnidad.PROTOSS_SCOUT).getClass());
		assertEquals(AltoTemplario.class,factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO).getClass());
		assertEquals(NaveTransporteProtoss.class,factory.getUnidad(TipoUnidad.PROTOSS_NAVE_TRANSPORTE).getClass());
	}


	@Test
	public void testAtributosMarine() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_MARINE);
		assertEquals(UnidadFactory.UNIDAD_MARINE_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_MARINE_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_MARINE_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_MARINE_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_MARINE_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_MARINE_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_MARINE_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_MARINE_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosGolliat() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT);
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosEspectro() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_ESPECTRO);
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosNaveCiencia() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA);
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosNaveTransporteTerran() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_NAVE_TRANSPORTE);
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosZealot() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT);
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosDragon() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_DRAGON);
		assertEquals(UnidadFactory.UNIDAD_DRAGON_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosScout() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_SCOUT);
		assertEquals(UnidadFactory.UNIDAD_SCOUT_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosAltoTemplario() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO);
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosNaveTransporteProtoss() throws UnidadInvalidaException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_NAVE_TRANSPORTE);
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_VISION, unidad.getVision());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_COSTO, unidad.getCosto());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_DA�O, unidad.getDa�o());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_SUMINISTRO, unidad.getSuministro());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_VIDA, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test(expected = UnidadInvalidaException.class)
	public void testUnidadInvalidaException() throws UnidadInvalidaException {	
		unidad = factory.getUnidad(TipoUnidad.ERROR);
	}
}
