package factory.construcciones;

import model.CreadorConstruccion;
import model.Elemento;
import controller.Posicion;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import factory.AbstractFactory;
import factory.GeneradorDeFactory;
import factory.TipoFactory;

public class Barraca extends Construccion implements CreadorConstruccion {

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void mover(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Elemento crearConstruccion(TipoConstruccion construccionRequerida) throws FactoryInvalidaException {
		
		AbstractFactory factoryConstruccion = GeneradorDeFactory.getFactory(TipoFactory.CONSTRUCCION_FACTORY);	
		Construccion construccion = factoryConstruccion.getConstruccion(construccionRequerida);
		return construccion;
	}

}
