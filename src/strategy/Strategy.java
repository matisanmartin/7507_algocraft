package strategy;

import java.util.List;

import model.ElementoArtificial;
import controller.Posicion;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;

public interface Strategy {
	
	void realizarAccion(Posicion posicionActual, String rangoAtaque, String daño, List<ElementoArtificial> unidadesEnemigas) throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException;

}
