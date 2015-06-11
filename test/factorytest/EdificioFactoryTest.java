package factorytest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import common.Posicion;

import exceptions.FueraDeRangoException;
import factory.EdificioFactory;
import factory.construcciones.Edificio;
import factory.construcciones.TipoEdificio;

public class EdificioFactoryTest {
	
	EdificioFactory factory;
	Edificio edificio;
	Posicion posicion;
	
	@Before
	public void setUp() throws FueraDeRangoException{
		factory = new EdificioFactory();
		posicion = new Posicion(10, 10);
	}

	@Test
	public void crearUnCentroMineral() throws FueraDeRangoException {
		edificio = factory.getEdificio(TipoEdificio.TERRAN_CENTRO_MINERAL,posicion);
		assertEquals("50M", edificio.getCosto());
		assertEquals(4, edificio.getTiempoDeConstruccion());
		assertEquals("500", edificio.getVida());
	}
	
	@Test
	public void crearUnaRefineria() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_REFINERIA, posicion);
		assertEquals("100M", edificio.getCosto());
		assertEquals(6, edificio.getTiempoDeConstruccion());
		assertEquals("750", edificio.getVida());
	}
	
	@Test
	public void crearUnaBarraca() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_BARRACA, posicion);
		assertEquals("150M", edificio.getCosto());
		assertEquals(12, edificio.getTiempoDeConstruccion());
		assertEquals("1000", edificio.getVida());
	}
	
	@Test
	public void crearUnaFabrica() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_FABRICA, posicion);
		assertEquals("200M100G", edificio.getCosto());
		assertEquals(12, edificio.getTiempoDeConstruccion());
		assertEquals("1250", edificio.getVida());
	}
	
	@Test
	public void crearUnPuertoEstelar() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posicion);
		assertEquals("150M100G", edificio.getCosto());
		assertEquals(10, edificio.getTiempoDeConstruccion());
		assertEquals("1300", edificio.getVida());
		
	}
	
	@Test
	public void creaUnNexoMineral() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_NEXO_MINERAL, posicion);
		assertEquals("50M", edificio.getCosto());
		assertEquals(4, edificio.getTiempoDeConstruccion());
		assertEquals("250/250", edificio.getVida());
		
	}
	
	@Test
	public void creaUnAsimilador() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_ASIMILADOR, posicion);
		assertEquals("100M", edificio.getCosto());
		assertEquals(6, edificio.getTiempoDeConstruccion());
		assertEquals("450/450", edificio.getVida());
	}	
		
	@Test
	public void creaUnAcceso() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_ACCESO, posicion);
		assertEquals("150M", edificio.getCosto());
		assertEquals(8, edificio.getTiempoDeConstruccion());
		assertEquals("500/500", edificio.getVida());
			
	}
	
	@Test
	public void creaUnPuertoEstelar() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posicion);
		assertEquals("150M150G", edificio.getCosto());
		assertEquals(10, edificio.getTiempoDeConstruccion());
		assertEquals("600/600", edificio.getVida());
	}
	
	@Test
	public void creaUnArchivoTemplario() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_ARCHIVO_TEMPLARIO, posicion);
		assertEquals("150M200G", edificio.getCosto());
		assertEquals(9, edificio.getTiempoDeConstruccion());
		assertEquals("500/500", edificio.getVida());
		
	}
	
	@Test
	public void creaDepositoDeSuministros() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_DEPOSITO_SUMINISTROS, posicion);
		assertEquals("100M", edificio.getCosto());
		assertEquals(6, edificio.getTiempoDeConstruccion());
		assertEquals("500", edificio.getVida());
	}
	
	@Test
	public void creaPilon() throws FueraDeRangoException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_PILON, posicion);
		assertEquals("100M", edificio.getCosto());
		assertEquals(5, edificio.getTiempoDeConstruccion());
		assertEquals("300/300", edificio.getVida());
	}
	
	
	
}
