package factorytest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import factory.EdificioFactory;
import factory.construcciones.Edificio;
import factory.construcciones.TipoEdificio;

public class EdificioFactoryTest {
	
	EdificioFactory factory;
	Edificio edificio;
	Posicion posicion;
	
	@Before
	public void setUp() throws FueraDeRangoException, PosicionInvalidaException{
		factory = new EdificioFactory();
		posicion = new Posicion(10, 10);
	}

	@Test
	public void crearUnCentroMineral() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		edificio = factory.getEdificio(TipoEdificio.TERRAN_CENTRO_MINERAL,posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("50M")));
		assertEquals(4, edificio.getTiempoDeConstruccion());
		assertEquals(500, edificio.getVida());
	}
	
	@Test
	public void crearUnaRefineria() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_REFINERIA, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("100M")));
		assertEquals(6, edificio.getTiempoDeConstruccion());
		assertEquals(750, edificio.getVida());
	}
	
	@Test
	public void crearUnaBarraca() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_BARRACA, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("150M")));
		assertEquals(12, edificio.getTiempoDeConstruccion());
		assertEquals(1000, edificio.getVida());
	}
	
	@Test
	public void crearUnaFabrica() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_FABRICA, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("200M100G")));
		assertEquals(12, edificio.getTiempoDeConstruccion());
		assertEquals(1250, edificio.getVida());
	}
	
	@Test
	public void crearUnPuertoEstelar() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_PUERTO_ESTELAR, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("150M100G")));
		assertEquals(10, edificio.getTiempoDeConstruccion());
		assertEquals(1300, edificio.getVida());
		
	}
	
	@Test
	public void creaUnNexoMineral() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_NEXO_MINERAL, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("50M")));
		assertEquals(4, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(250,250)));
		
	}
	
	@Test
	public void creaUnAsimilador() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_ASIMILADOR, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("100M")));
		assertEquals(6, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(450,450)));
	}	
		
	@Test
	public void creaUnAcceso() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_ACCESO, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("150M")));
		assertEquals(8, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(500,500)));
			
	}
	
	@Test
	public void creaUnPuertoEstelar() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_PUERTO_ESTELAR, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("150M150G")));
		assertEquals(10, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(600,600)));
	}
	
	@Test
	public void creaUnArchivoTemplario() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_ARCHIVO_TEMPLARIO, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("150M200G")));
		assertEquals(9, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(500,500)));
		
	}
	
	@Test
	public void creaDepositoDeSuministros() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_DEPOSITO_SUMINISTROS, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("100M")));
		assertEquals(6, edificio.getTiempoDeConstruccion());
		assertEquals(500, edificio.getVida());
	}
	
	@Test
	public void creaPilon() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.PROTOSS_PILON, posicion);
		assertEquals(true, edificio.getCosto().equals(new Costo("100M")));
		assertEquals(5, edificio.getTiempoDeConstruccion());
		assertEquals(true, edificio.getVitalidad().equals(new Vitalidad(300,300)));
	}
	
	@Test
	public void crearCentroDeComandoTerran() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		edificio = factory.getEdificio(TipoEdificio.TERRAN_CENTRO_COMANDO, new Posicion(100, 100));
		assertEquals(new Posicion(100, 100), edificio.getPosicion());
	}
	
	
	
}
