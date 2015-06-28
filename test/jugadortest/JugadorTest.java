package jugadortest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;
import model.CampoBatalla;
import model.Juego;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import razas.Raza;

import common.Posicion;

import exceptions.ColorInvalidoException;
import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import exceptions.NombreCortoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

@RunWith(JUnit4.class)
public class JugadorTest {
	
	Jugador jugadorPrueba;
	Raza razaPrueba;
	
	 @Before
	 public void setUp() {
	 }
	 
	 @After
	 public void destroy() {
		 CampoBatalla.DestruirInstancia();
		 Juego.destruirInstancia();
	 }
	 
	 @Test(expected = NombreCortoException.class)
	 public void testNombreCorto() throws NombreCortoException, ColorInvalidoException {
			jugadorPrueba = new Jugador("","terran","rojo");
			
	}
	 
	 
	 @Test
	 public void testConstructorOk() throws NombreCortoException, ColorInvalidoException {
		 jugadorPrueba = new Jugador("12345","terran","azul");
		 assertEquals("12345",jugadorPrueba.getNombre());
		 assertEquals("azul",jugadorPrueba.getColor());
		 //assertEquals(Raza.class,jugadorPrueba.getRaza().getClass());
	 }

	 @Test
	 public void alCrerseDeberiaTener200DeCristal0DeGas() throws NombreCortoException, ColorInvalidoException{
		 jugadorPrueba = new Jugador("12345","terran","rojo");
		 assertEquals(200,jugadorPrueba.getCantidadDeCristal());
		 assertEquals(0,jugadorPrueba.getCantidadDeGas());
		 
	 }
	 
}
