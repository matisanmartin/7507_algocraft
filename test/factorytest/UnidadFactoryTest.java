package factorytest;

import static org.junit.Assert.assertEquals;

import java.util.Hashtable;
import java.util.Map;

import model.Parte;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import command.Accion;
import common.Costo;
import common.Danio;
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


@RunWith(JUnit4.class)
public class UnidadFactoryTest {

	Unidad unidad;
	UnidadFactory factory;
	Map<String,Accion> mapaPrueba;
	
	
	@Before
	public void setUp(){
		factory = new UnidadFactory();
		mapaPrueba= new Hashtable<String,Accion>();
	}

	@Test
	public void testAtributosMarine() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_MARINE_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_MARINE_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_MARINE_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_MARINE_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_MARINE_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_MARINE_SUMINISTRO, unidad.getSuministro());
		assertEquals(40, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_MARINE_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosGolliat() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_GOLLIAT, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_GOLLIAT_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_GOLLIAT_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_SUMINISTRO, unidad.getSuministro());
		assertEquals(125, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_GOLLIAT_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosEspectro() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_ESPECTRO, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_ESPECTRO_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_ESPECTRO_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_SUMINISTRO, unidad.getSuministro());
		assertEquals(120, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_ESPECTRO_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosNaveCiencia() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_NAVE_CIENCIA_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_NAVE_CIENCIA_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_SUMINISTRO, unidad.getSuministro());
		assertEquals(200, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_NAVE_CIENCIA_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosNaveTransporteTerran() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_NAVE_TRANSPORTE, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_SUMINISTRO, unidad.getSuministro());
		assertEquals(150, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_TERRAN_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosZealot() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_ZEALOT_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_ZEALOT_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_SUMINISTRO, unidad.getSuministro());
		assertEquals(100, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_ZEALOT_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosDragon() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_DRAGON, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_DRAGON_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_VISION, unidad.getVision());
		assertEquals(true, (unidad.getCosto()).equals(new Costo(UnidadFactory.UNIDAD_DRAGON_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_DRAGON_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_DRAGON_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_SUMINISTRO, unidad.getSuministro());
		assertEquals(100, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_DRAGON_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosScout() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_SCOUT, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_SCOUT_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_SCOUT_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_SCOUT_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_SCOUT_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_SUMINISTRO, unidad.getSuministro());
		assertEquals(150, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_SCOUT_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosAltoTemplario() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_SUMINISTRO, unidad.getSuministro());
		assertEquals(40, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_ALTO_TEMPLARIO_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	@Test
	public void testAtributosNaveTransporteProtoss() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_NAVE_TRANSPORTE, new Posicion(1, 1));
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_TRANSPORTE, unidad.getTransporte());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_VISION, unidad.getVision());
		assertEquals(true, unidad.getCosto().equals(new Costo(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_COSTO)));
		assertEquals(true, unidad.getDanio().equals(new Danio(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_DA�O)));
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_RANGO_ATAQUE, unidad.getRangoAtaque());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_SUMINISTRO, unidad.getSuministro());
		assertEquals(80, unidad.getVida());
		assertEquals(UnidadFactory.UNIDAD_NAVE_TRANSPORTE_PROTOSS_TIEMPO_CONSTRUCCION, unidad.getTiempoConstruccion());
	}
	
	//arreglar este test
//	@Test(expected = UnidadInvalidaException.class)
//	public void testUnidadInvalidaException() throws UnidadInvalidaException {	
//		unidad = factory.getUnidad(TipoUnidad.ERROR);
//	}
	
	@Test
	public void testUnMarineDe2x2DeberiaTener4Partes() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException{
		unidad = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		assertEquals(4,unidad.getPartes().size());
	}
	
	@Test
	public void testUnMarineDe2x2ConPosX1Y1DeberiaTenerSusPartesEnPosicionesCorrectas() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException{
		unidad = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		assertEquals((new Parte(new Posicion(1, 1)).getPosicion()), unidad.getPartes().get(0).getPosicion() );
		assertEquals((new Parte(new Posicion(1, 2)).getPosicion()), unidad.getPartes().get(1).getPosicion() );
		assertEquals((new Parte(new Posicion(2, 1 )).getPosicion()), unidad.getPartes().get(2).getPosicion() );
		assertEquals((new Parte(new Posicion(2, 2)).getPosicion()), unidad.getPartes().get(3).getPosicion() );
	}
	
	@Test
	public void testUnaUnidadTieneAccionAtacar() 
	throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		mapaPrueba = unidad.getAccionesDisponibles();
		assertEquals(true,mapaPrueba.containsKey("Atacar"));
	}
	
	@Test
	public void testUnaUnidadNoTieneAccionesMagica() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(1, 1));
		mapaPrueba = unidad.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Emp"));
		assertEquals(false,mapaPrueba.containsKey("Radiacion"));
		assertEquals(false,mapaPrueba.containsKey("Alucinacion"));
		assertEquals(false,mapaPrueba.containsKey("Tormenta Psionica"));
		
	}
	
	@Test
	public void testUnaUnidadMagicaNoTienAccionAtacar() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, new Posicion(1, 1));
		mapaPrueba = unidad.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Atacar"));
		
	}
	
	@Test
	public void testUnaUnidadMagicaProtossTieneAccionesAlucinacionYTormentaPsionica() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(1, 1));
		mapaPrueba = unidad.getAccionesDisponibles();
		assertEquals(true,mapaPrueba.containsKey("Alucinacion"));
		assertEquals(true,mapaPrueba.containsKey("TormentaPsionica"));
		
	}
	
	@Test
	public void testUnaUnidadMagicaProtosNoTieneAccionEmpNiRadiacion() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(1, 1));
		mapaPrueba = unidad.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Emp"));
		assertEquals(false,mapaPrueba.containsKey("Radiacion"));
	}
	
	@Test
	public void testUnaUnidadMagicaTerranTieneAccionesEmpYRadiacion() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, new Posicion(1, 1));
		mapaPrueba = unidad.getAccionesDisponibles();
		assertEquals(true,mapaPrueba.containsKey("Emp"));
		assertEquals(true,mapaPrueba.containsKey("Radiacion"));
		
	}
	
	@Test
	public void testUnaUnidadMagicaTerranNoTieneAccionesAlucinacionYTormentaPsionica() throws UnidadInvalidaException, FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException, UnidadLlenaException, DanioInvalidoException {
		unidad = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA, new Posicion(1, 1));
		mapaPrueba = unidad.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Alucinacion"));
		assertEquals(false,mapaPrueba.containsKey("Tormenta Psionica"));
		
	}
}
