package factory;

import exceptions.FactoryInvalidaException;

public class GeneradorDeFactory {
	
	public static AbstractFactory getFactory(TipoFactory factoryRequerida) throws FactoryInvalidaException{
		
		switch(factoryRequerida){
		
		case UNIDAD_FACTORY:
			return new UnidadFactory();
		case CONSTRUCCION_FACTORY:
			return new EdificioFactory();
		default:
			throw new FactoryInvalidaException();
		}
	}

}
