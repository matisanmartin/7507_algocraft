package listenertest;

import static org.junit.Assert.assertEquals;
import model.Juego;

import org.junit.Before;
import org.junit.Test;

import vista.VentanaMock;

public class MetodoPruebaListenerTest {

	@Before
	public void setUp() throws Exception {
		Juego.crearInstancia(new VentanaMock());
	}

	@Test
	public void testPruebaListener() {
		assertEquals(null,Juego.getInstancia().pruebaListener());
	}

}
