package factory.construcciones;

import java.util.List;

import strategy.ContextoStrategy;
import model.ElementoArtificial;
import model.Volcan;
import controller.Posicion;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;

public class Refineria extends ConstruccionSobreVolcan {

	public Refineria(Volcan volcan) {
		super(volcan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void realizarAccion(ContextoStrategy contexto,
			List<ElementoArtificial> unidadesEnemigas)
			throws FactoryInvalidaException, UnidadInvalidaException,
			FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}

}
