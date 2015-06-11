package commandtest;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import model.ElementoArtificial;

import org.junit.Before;
import org.junit.Test;

import command.Accion;
import common.Posicion;

import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import factory.UnidadFactory;
import factory.unidades.TipoUnidad;

public class AtacarCommandTest {

	UnidadFactory factory;
	ElementoArtificial unidadPrueba;
	ElementoArtificial unidadMagicaProtossPrueba;
	Map<String,Accion> acciones;
	ElementoArtificial unidadMagicaTerranPrueba;
	
	@Before
	public void setUp() throws Exception {
		

		factory = new UnidadFactory();
		unidadPrueba= factory.getUnidad(TipoUnidad.TERRAN_MARINE,new Posicion(3,3));
		unidadPrueba.definirAccionesDisponibles();
		
		unidadMagicaProtossPrueba= factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO,new Posicion(3,3));
		unidadMagicaProtossPrueba.definirAccionesDisponibles();
		
		unidadMagicaTerranPrueba = factory.getUnidad(TipoUnidad.TERRAN_NAVE_CIENCIA,new Posicion(3,3));
		unidadMagicaTerranPrueba.definirAccionesDisponibles();
	}

	@Test
	public void testAccionesUnidadComunSoloAtacar() 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		
		acciones = unidadPrueba.getAccionesDisponibles();
		
		assertEquals(1,acciones.size());
		assertEquals(true,acciones.containsKey("Atacar"));
		
		//Accion atacar = acciones.get("Atacar");
		
		//atacar.execute(new Posicion(4,4));
		
	}
	
	@Test
	public void testAccionesUnidadMagicaProtossAtacarYVariasMas() {
		acciones = unidadMagicaProtossPrueba.getAccionesDisponibles();
		assertEquals(true,acciones.containsKey("Alucinacion"));
		assertEquals(true,acciones.containsKey("TormentaPsionica"));
	}
	
	@Test
	public void testAccionesUnidadMagicaTerranAtacarYVariasMas() {
		acciones=unidadMagicaTerranPrueba.getAccionesDisponibles();	
		assertEquals(true,acciones.containsKey("Emp"));
		assertEquals(true,acciones.containsKey("Radiacion"));
	}

}
