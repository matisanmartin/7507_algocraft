package jugadortest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import jugador.TipoColor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import razas.Raza;
import exceptions.ColorInvalidoException;
import exceptions.NombreCortoException;

@RunWith(JUnit4.class)
public class JugadorTest {
	
	Jugador jugadorPrueba;
	Raza razaPrueba;
	
	 @Before
	 public void setUp() {
	 }
	 
	 @Test(expected = NombreCortoException.class)
	 public void testNombreCorto() throws NombreCortoException, ColorInvalidoException {
		 jugadorPrueba = new Jugador("",TipoColor.COLOR_AMARILLO,razaPrueba);
	}
	 
	 @Test(expected = ColorInvalidoException.class)
	 public void testColorInvalido() throws NombreCortoException, ColorInvalidoException {
		 jugadorPrueba = new Jugador("12345",TipoColor.ERROR,razaPrueba);
		 assertEquals("12345",jugadorPrueba.getNombre());
	 }
	 
	 @Test
	 public void testConstructorOk() throws NombreCortoException, ColorInvalidoException {
		 jugadorPrueba = new Jugador("12345",TipoColor.COLOR_AZUL,razaPrueba);
		 assertEquals("12345",jugadorPrueba.getNombre());
		 assertEquals(TipoColor.COLOR_AZUL,jugadorPrueba.getColor());
		 //assertEquals(Raza.class,jugadorPrueba.getRaza().getClass());
	 }

}
