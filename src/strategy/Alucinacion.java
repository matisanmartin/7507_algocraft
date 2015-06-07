package strategy;

import java.util.List;

import model.ElementoArtificial;
import controller.Posicion;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;
import factory.unidades.TipoUnidad;
import factory.unidades.Unidad;

public class Alucinacion implements Strategy {

	@Override
	public void realizarAccion(Posicion posicionActual, String rangoAtaque, String daño, List<ElementoArtificial> unidadesEnemigas) throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException {
		
		AbstractFactory factory = GeneradorDeFactory.getFactory(TipoFactory.UNIDAD_FACTORY);
		
		Posicion posicionFicticia1 = new Posicion(posicionActual.getPosX()+1,posicionActual.getPosY());
		Unidad copiaFicticia1 = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO);
		//copiaFicticia1.setDaño("0");
		copiaFicticia1.posicionar(posicionFicticia1);
		
		Posicion posicionFicticia2 = new Posicion(posicionActual.getPosX()-1,posicionActual.getPosY());
		Unidad copiaFicticia2 = factory.getUnidad(TipoUnidad.PROTOSS_ALTO_TEMPLARIO);
		//copiaFicticia2.setDaño("0");
		copiaFicticia2.posicionar(posicionFicticia2);

	}

}
