package edificiotest;

import static org.junit.Assert.assertEquals;

import java.util.Hashtable;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import command.Accion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import factory.construcciones.Acceso;
import factory.construcciones.ArchivoTemplario;
import factory.construcciones.Asimilador;
import factory.construcciones.Barraca;
import factory.construcciones.CentroMineral;
import factory.construcciones.Edificio;
import factory.construcciones.EdificioGas;
import factory.construcciones.EdificioMineral;
import factory.construcciones.Fabrica;
import factory.construcciones.NexoMineral;
import factory.construcciones.PuertoEstelarProtoss;
import factory.construcciones.PuertoEstelarTerran;
import factory.construcciones.Refineria;

public class EdificioTest {
	
	Map<String,Accion> mapaPrueba;
	Edificio edificio;
	
	@Before
	public void setUp() {
		mapaPrueba= new Hashtable<String,Accion>();
	}
	
	@Test
	public void creaUnaBarraca() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new Barraca(2, 2, new Posicion(10, 10));
		assertEquals(true, edificio.getCosto().equals(new Costo("150M")));
		assertEquals(12, edificio.getTiempoDeConstruccion());
		assertEquals(1000, edificio.getVida());
		
	}
	
	@Test
	public void creaUnaFabrica() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = new Fabrica(2,2, new Posicion(10, 10));
		assertEquals(true, edificio.getCosto().equals(new Costo("200M100G")));
		assertEquals(12, edificio.getTiempoDeConstruccion());
		assertEquals(1250, edificio.getVida());
	}
	
	@Test
	public void creaUnAcceso() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = new Acceso(2,2, new Posicion(10, 10));
		assertEquals(true, edificio.getCosto().equals(new Costo("150M")));
		assertEquals(8, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(500,500)));
	}
	
	@Test
	public void creaUnPuertoEstelarTerran() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = new PuertoEstelarTerran(2,2, new Posicion(10, 10));
		assertEquals(true, edificio.getCosto().equals(new Costo("150M100G")));
		assertEquals(10, edificio.getTiempoDeConstruccion());
		assertEquals(1300, edificio.getVida());
	}
	
	
	@Test
	public void creaUnPuertoEstelarProtoss() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = new PuertoEstelarProtoss(2,2, new Posicion(10, 10));
		assertEquals(true, edificio.getCosto().equals(new Costo("150M150G")));
		assertEquals(10, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(600,600)));
	}
	
	@Test
	public void creaUnArchivoTemplario() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = new ArchivoTemplario(2,2, new Posicion(2, 2));
		assertEquals(true, edificio.getCosto().equals(new Costo("150M200G")));
		assertEquals(9, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(500,500)));
	}
	

	@Test
	public void crearUnEdificioMineral() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		EdificioMineral centro = new CentroMineral(2,2, new Posicion(2, 2));
		EdificioMineral nexo = new NexoMineral(2,2, new Posicion(2, 2));
		assertEquals(true, centro.getCosto().equals(new Costo("50M")));
		assertEquals(4, centro.getTiempoDeConstruccion());
		assertEquals(500, centro.getVida());
		assertEquals(true, nexo.getVitalidad().equals(new Vitalidad(250,250)));
		assertEquals(5, centro.getMineral());
		assertEquals(5, nexo.getMineral());
	}
	
	@Test
	public void crearEdificioDeGas() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		EdificioGas refineria = new Refineria(2, 2, new Posicion(10, 10));
		EdificioGas asimilador = new Asimilador(2,2, new Posicion(10, 10));
		assertEquals(true, refineria.getCosto().equals(new Costo("100M")));
		assertEquals(6, refineria.getTiempoDeConstruccion());
		assertEquals(750, refineria.getVida());
		assertEquals(true, asimilador.getVitalidad().equals(new Vitalidad(450,450)));
		assertEquals(5, refineria.getGas());
		assertEquals(5, asimilador.getGas());
	}
	
	@Test
	public void testBarracaPuedeCrearMarine() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new Barraca(2, 2, new Posicion(10, 10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true,mapaPrueba.containsKey("Crear Marine"));
	}
	
	@Test
	public void testBarracaNoPuedeCrearZealot() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new Barraca(2, 2, new Posicion(10, 10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Crear Zealot"));	
	}
	
	@Test
	public void testAccesoPuedeCrearZealot() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new Acceso(2,2, new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true,mapaPrueba.containsKey("Crear Zealot"));
	}
	
	@Test
	public void testAccesoNoPuedeCrearMarine() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new Acceso(2,2, new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Crear Marine"));	
	}
	
	@Test
	public void testArchivoTemplarioCreaAltoTemplario() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new ArchivoTemplario(2, 2, new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true,mapaPrueba.containsKey("Crear Alto Templario"));
		
	}
	
	@Test
	public void testArchivoTemplarioNoPuedeCrearMarine() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new ArchivoTemplario(2, 2, new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Crear Marine"));
		
	}
	
	@Test
	public void testFabricaPuedeCrearGolliat() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new Fabrica(2, 2, new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true, mapaPrueba.containsKey("Crear Golliat"));
		
	}
	
	@Test
	public void testFabricaNoPuedeCrearMarine() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new Fabrica(2,2,new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Crear Marine"));
	}
	
	@Test
	public void testPuertoEstelarProtossCreaScout() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new PuertoEstelarProtoss(2, 2, new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true, mapaPrueba.containsKey("Crear Scout"));
	}
	
	@Test
	public void testPuertoEstelarProtossCreaNaveTransporteProtoss() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new PuertoEstelarProtoss(2,2,new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true, mapaPrueba.containsKey("Crear Nave Transporte Protoss"));
	}
	
	@Test
	public void testPuertoEstelarProtossNoPuedeCrearMarine() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new PuertoEstelarProtoss(2,2,new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Crear Marine"));
		
	}
	
	@Test
	public void testPuertoEstelarTerranPuedeCrearEspectro() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new PuertoEstelarTerran(2,2, new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true,mapaPrueba.containsKey("Crear Espectro"));
	}
	
	@Test
	public void testPuertoEstelarTerranPuedeCrearNaveTransporteTerran () throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new PuertoEstelarTerran(2,2, new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true, mapaPrueba.containsKey("Crear Nave Transporte Terran"));
	}
	
	@Test
	public void testPuertoEstelarTerranPuedeCrearNaveCiencia() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new PuertoEstelarTerran(2,2,new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(true,mapaPrueba.containsKey("Crear Nave Ciencia"));
	}
	
	@Test
	public void testPuertoEstelarTerranNoPuedeCrearMarine() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = new PuertoEstelarTerran(2,2,new Posicion(10,10));
		mapaPrueba = edificio.getAccionesDisponibles();
		assertEquals(false,mapaPrueba.containsKey("Crear Marine"));
		
	}
	
	
}


