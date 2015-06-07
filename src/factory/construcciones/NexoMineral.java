package factory.construcciones;

import java.util.List;

import strategy.ContextoStrategy;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;
import model.Cristal;
import model.ElementoArtificial;

public class NexoMineral extends ConstruccionSobreCristal {

	public NexoMineral(Cristal cristal) {
		super(cristal);
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
