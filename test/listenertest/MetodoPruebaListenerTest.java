package listenertest;

import static org.junit.Assert.*;
import model.Juego;

import org.junit.Before;
import org.junit.Test;

public class MetodoPruebaListenerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPruebaListener() {
		assertEquals("pruebaListener()",Juego.getInstancia().pruebaListener());
	}

}
