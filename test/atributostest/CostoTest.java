package atributostest;

import static org.junit.Assert.*;

import org.junit.Test;
import common.Costo;
import exceptions.CostoInvalidoException;

public class CostoTest {
	
	private Costo costo;
	private Costo costoAComparar;

	@Test (expected = CostoInvalidoException.class)
	public void costoInvalidoError() throws CostoInvalidoException {
		costo = new Costo("cadenaInvalida");
	}

	@Test
	public void costoCantidadesCorrectas() throws CostoInvalidoException {
		costo = new Costo("50M35G");
		assertEquals(costo.getCantidadM(),50);
		assertEquals(costo.getCantidadG(),35);
	}
	
	@Test
	public void costoCubreAOtroCosto() throws CostoInvalidoException {
		costo = new Costo("100M30G");
		costoAComparar = new Costo("120M35G");
		assertTrue(costo.cubreCosto(costoAComparar));
	}
	
	@Test
	public void costoNoCubreAOtroCosto() throws CostoInvalidoException {
		costo = new Costo("100M30G");
		costoAComparar = new Costo("80M50G");
		assertFalse(costo.cubreCosto(costoAComparar));
	}
	
	@Test
	public void costoGEsCero() throws CostoInvalidoException {
		Costo costo = new Costo("100M");
		assertEquals(costo.getCantidadM(),100);
		assertEquals(costo.getCantidadG(),0);
	}
	
	@Test
	public void costoAlcanzanRecursos() throws CostoInvalidoException {
		Costo costo = new Costo("100M50G");
		assertTrue(costo.alcanzaCantidadM(120));
		assertTrue(costo.alcanzaCantidadG(50));
	}
	
	@Test
	public void costoNoAlcanzanRecursos() throws CostoInvalidoException {
		Costo costo = new Costo("80M30G");
		assertFalse(costo.alcanzaCantidadM(70));
		assertFalse(costo.alcanzaCantidadG(20));
	}
}
