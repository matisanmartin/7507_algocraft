package factory.construcciones;

import java.util.List;

import strategy.ContextoStrategy;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import model.ElementoArtificial;
import model.Volcan;

public class Asimilador extends ConstruccionSobreVolcan {

	public Asimilador(Volcan volcan) {
		super(volcan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realizarAccion(ContextoStrategy contexto,
			List<ElementoArtificial> unidadesEnemigas)
			throws FactoryInvalidaException, UnidadInvalidaException,
			FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}



}
