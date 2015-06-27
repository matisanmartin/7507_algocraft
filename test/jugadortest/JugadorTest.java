package jugadortest;

import static org.junit.Assert.assertEquals;
import jugador.Jugador;

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
	 
	 @Test
	 public void borraUnElementoDeLaArmada() throws FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException, ElementoInvalidoException, RecursosInsuficientesException, UnidadLlenaException, UnidadInvalidaException, DanioInvalidoException, ElementoNoEncontradoException{
		 Jugador jug = new Jugador();
		 UnidadFactory factory = new UnidadFactory();
		 assertEquals(0, jug.obtenerDimensionArmada());
		 Unidad marine = factory.getUnidad(TipoUnidad.TERRAN_MARINE, new Posicion(50, 50));
		 jug.agregarElemento(marine);
		 marine = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO, new Posicion(200, 200));
		 jug.agregarElemento(marine);
		 assertEquals(2, jug.obtenerDimensionArmada());
		 jug.obtenerArmada().removerElementoEnPosicion(new Posicion(50, 50));
		 assertEquals(1, jug.obtenerDimensionArmada());
	 }
	 
//	 @Test
//	 public void siPideRecursosAUnEdificoDeRecursoRecibeMas10() throws FueraDeRangoException, NombreCortoException, ColorInvalidoException{
//		Jugador jugador = new Jugador("pepepe", TipoColor.COLOR_AMARILLO, new Terran());
//		ConstruccionSobreVolcan refineria = new Refineria(new Volcan(new Posicion(1, 1))); 
//		 
//		 
//	 }
}
