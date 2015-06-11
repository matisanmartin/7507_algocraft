package edificiotest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import common.Posicion;
import exceptions.FueraDeRangoException;
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
import factory.construcciones.PuertoEstelar;
import factory.construcciones.PuertoEstelarProtoss;
import factory.construcciones.PuertoEstelarTerran;
import factory.construcciones.Refineria;

public class EdificioTest {
	

	@Test
	public void creaUnaBarraca() throws FueraDeRangoException {
		Edificio edificio = new Barraca(2, 2, new Posicion(10, 10));
		assertEquals("150M", edificio.getCosto());
		assertEquals(12, edificio.getTiempoDeConstruccion());
		assertEquals("1000", edificio.getVida());
		
	}
	
	@Test
	public void creaUnaFabrica() throws FueraDeRangoException{
		Edificio edificio = new Fabrica(2,2, new Posicion(10, 10));
		assertEquals("200M100G", edificio.getCosto());
		assertEquals(12, edificio.getTiempoDeConstruccion());
		assertEquals("1250", edificio.getVida());
	}
	
	@Test
	public void creaUnAcceso() throws FueraDeRangoException{
		Edificio edificio = new Acceso(2,2, new Posicion(10, 10));
		assertEquals("150M", edificio.getCosto());
		assertEquals(8, edificio.getTiempoDeConstruccion());
		assertEquals("500/500", edificio.getVida());
	}
	
	@Test
	public void creaUnPuertoEstelarTerrar() throws FueraDeRangoException{
		PuertoEstelar edificio = new PuertoEstelarTerran(2,2, new Posicion(10, 10));
		assertEquals("150M150G", edificio.getCosto());
		assertEquals(10, edificio.getTiempoDeConstruccion());
		assertEquals("1300", edificio.getVida());
	}
	
	
	@Test
	public void creaUnPuertoEstelarProtoss() throws FueraDeRangoException{
		PuertoEstelar edificio = new PuertoEstelarProtoss(2,2, new Posicion(10, 10));
		assertEquals("150M150G", edificio.getCosto());
		assertEquals(10, edificio.getTiempoDeConstruccion());
		assertEquals("600/600", edificio.getVida());
	}
	
	@Test
	public void creaUnArchivoTemplario() throws FueraDeRangoException{
		Edificio edificio = new ArchivoTemplario(2,2, new Posicion(2, 2));
		assertEquals("150M200G", edificio.getCosto());
		assertEquals(9, edificio.getTiempoDeConstruccion());
		assertEquals("500/500", edificio.getVida());
	}
	

	@Test
	public void crearUnEdificioMineral() throws FueraDeRangoException{
		EdificioMineral centro = new CentroMineral(2,2, new Posicion(2, 2));
		EdificioMineral nexo = new NexoMineral(2,2, new Posicion(2, 2));
		assertEquals("50M", centro.getCosto());
		assertEquals(4, centro.getTiempoDeConstruccion());
		assertEquals("500", centro.getVida());
		assertEquals("250/250", nexo.getVida());
		assertEquals(5, centro.getMineral());
		assertEquals(5, nexo.getMineral());
	}
	
	@Test
	public void crearEdificioDeGas() throws FueraDeRangoException{
		EdificioGas refineria = new Refineria(2, 2, new Posicion(10, 10));
		EdificioGas asimilador = new Asimilador(2,2, new Posicion(10, 10));
		assertEquals("100M", refineria.getCosto());
		assertEquals(6, refineria.getTiempoDeConstruccion());
		assertEquals("750", refineria.getVida());
		assertEquals("450/450", asimilador.getVida());
		assertEquals(5, refineria.getGas());
		assertEquals(5, asimilador.getGas());
	}
}
