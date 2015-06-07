package factory.construcciones;

import java.util.List;

import strategy.ContextoStrategy;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import model.Cristal;
import model.ElementoArtificial;

public class CentroDeMineral extends ConstruccionSobreCristal {

	public CentroDeMineral(Cristal cristal) {
		super(cristal);
	}

	@Override
	public void realizarAccion(ContextoStrategy contexto,
			List<ElementoArtificial> unidadesEnemigas)
			throws FactoryInvalidaException, UnidadInvalidaException,
			FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}


}
