package strategytest;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import model.Elemento;

import org.junit.Before;

import strategy.ContextoStrategy;
import common.Posicion;
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
	ArrayList<Elemento> unidadesEnemigas;
	
	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void test() {
		fail("Not yet implemented");
	}

}
