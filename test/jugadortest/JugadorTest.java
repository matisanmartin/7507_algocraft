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

	 @Test
	 public void alCrerseDeberiaTener200DeCristal0DeGas() throws NombreCortoException, ColorInvalidoException{
		 jugadorPrueba = new Jugador("12345",TipoColor.COLOR_AZUL,razaPrueba);
		 assertEquals(200,jugadorPrueba.getCantidadDeCristal());
		 assertEquals(0,jugadorPrueba.getCantidadDeGas());
		 
	 }
	 
//	 @Test
//	 public void siPideRecursosAUnEdificoDeRecursoRecibeMas10() throws FueraDeRangoException, NombreCortoException, ColorInvalidoException{
//		Jugador jugador = new Jugador("pepepe", TipoColor.COLOR_AMARILLO, new Terran());
//		ConstruccionSobreVolcan refineria = new Refineria(new Volcan(new Posicion(1, 1))); 
//		 
//		 
//	 }
}
