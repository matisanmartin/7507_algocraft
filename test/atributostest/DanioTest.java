package atributostest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import common.Danio;

import exceptions.DanioInvalidoException;

public class DanioTest {
	
	private Danio danio;

	@Test (expected = DanioInvalidoException.class)
	public void danioInvalidoError() throws DanioInvalidoException {
		danio = new Danio("danioInvalido");
	}

	@Test
	public void DanioAtaquesCorrectos() throws DanioInvalidoException {
		danio = new Danio("6A5T");
		assertEquals(danio.getDanioA(),6);
		assertEquals(danio.getDanioT(),5);
	}
	
	@Test
	public void DanioAtaquesIncorrectos() throws DanioInvalidoException {
		danio = new Danio("0A3T");
		assertFalse(danio.getDanioA() == 3);
	    assertFalse(danio.getDanioT() == 0);
	}
}