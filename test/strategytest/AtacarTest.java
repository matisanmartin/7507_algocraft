package strategytest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;

import strategy.Atacar;
import strategy.ContextoStrategy;
import controller.Posicion;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class AtacarTest {

	ContextoStrategy contexto;
	AbstractFactory factory;
	Unidad unidadAtacante;
	Unidad unidadDefensoraEnRango;
	Unidad unidadDefensoraFueraDeRango;
	Posicion posicionAtacante;
	Posicion posicionEnRango;
	Posicion posicionFueraDeRango;
	List<ElementoArtificial> unidadesEnemigas;
	
	@Before
	public void setUp() throws Exception {
		
		unidadesEnemigas = new ArrayList<ElementoArtificial>();
		contexto = new ContextoStrategy(new Atacar());
		factory = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		
		unidadAtacante=factory.getUnidad(TipoUnidad.TERRAN_MARINE);
		posicionAtacante = new Posicion(1,1);
		unidadAtacante.posicionar(posicionAtacante);
		unidadAtacante.setDaño("6");//temporalmente para que ande la prueba
		unidadAtacante.setRangoAtaque("4");
		
		unidadDefensoraEnRango=factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT);
		posicionEnRango = new Posicion(1,2);
		unidadDefensoraEnRango.posicionar(posicionEnRango);
		unidadDefensoraEnRango.setVida("60");
		
		unidadDefensoraFueraDeRango=factory.getUnidad(TipoUnidad.PROTOSS_ZEALOT);
		posicionFueraDeRango = new Posicion(10,10);
		unidadDefensoraFueraDeRango.posicionar(posicionFueraDeRango);
		unidadDefensoraFueraDeRango.setVida("60");
			
	}

	/**
	 * Un Marine ataca a un zealot en rango, por lo tanto, como el daño del Marine es 6
	 * la vida del Zealot deberia resultar en 60-6 (ya que daña el escudo y no llega a quitarle vida)
	 * @throws FueraDeRangoException 
	 * @throws FactoryInvalidaException 
	 * 
	 * 
	 */
	@Test
	public void testMarineAtacaUnidadEnemigaEnRango() 
	throws UnidadInvalidaException, FactoryInvalidaException, FueraDeRangoException {	
		unidadesEnemigas.add(unidadDefensoraEnRango);
		unidadAtacante.realizarAccion(contexto, unidadesEnemigas);
		
		assertEquals("54",unidadesEnemigas.get(0).getVida());		
	}

	/**
	 * Un marine ataca a un zealot fuera de rango, por lo tanto, la vida deberia quedar en 60.
	 * @throws FueraDeRangoException 
	 * @throws UnidadInvalidaException 
	 * @throws FactoryInvalidaException 
	 */
	@Test
	public void testMarineAtacaUnidadEnemigaFueraDeRango() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException {
		unidadesEnemigas.add(unidadDefensoraFueraDeRango);
		unidadAtacante.realizarAccion(contexto, unidadesEnemigas);
		
		assertEquals("60",unidadesEnemigas.get(0).getVida());
	}
	
	/**
	 * Un marine ataca dos unidades, la primera fuera de rango yla segunda fuera
	 * la primera no deberia perder vida (60) y la segunda deberia quedar en 54
	 * @throws FueraDeRangoException 
	 * @throws UnidadInvalidaException 
	 * @throws FactoryInvalidaException 
	 */
	@Test
	public void testMarineAtacaDosUnidadesEnemigasUnaEnRangoOtraFuera() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException {
		
		unidadesEnemigas.add(unidadDefensoraFueraDeRango);
		unidadesEnemigas.add(unidadDefensoraEnRango);	
		unidadAtacante.realizarAccion(contexto,unidadesEnemigas);
	
		assertEquals("60",unidadesEnemigas.get(0).getVida());
		assertEquals("54",unidadesEnemigas.get(1).getVida());
	}

}
