package strategytest;

import static org.junit.Assert.*;

import java.util.List;

import model.Elemento;

import org.junit.Before;
import org.junit.Test;

import strategy.ContextoStrategy;
import controller.Posicion;
import factory.AbstractFactory;
import factory.unidades.Unidad;

public class TormentaPsionicaTest {

	ContextoStrategy contexto;
	AbstractFactory factory;
	Unidad unidadAtacante;
	Unidad unidadDefensoraEnRango;
	Unidad unidadDefensoraFueraDeRango;
	Posicion posicionAtacante;
	Posicion posicionEnRango;
	Posicion posicionFueraDeRango;
	List<Elemento> unidadesEnemigas;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
