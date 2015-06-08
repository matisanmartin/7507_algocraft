package strategy;

import java.util.List;

import common.Posicion;

import model.ElementoArtificial;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;

public interface Strategy {
	
	void realizarAccion(Posicion posicionActual, String rangoAtaque, String da�o, List<ElementoArtificial> unidadesEnemigas) throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException;

}
