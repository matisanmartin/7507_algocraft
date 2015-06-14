package command;

import strategy.ContextoStrategy;
import strategy.CrearDragon;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import factory.unidades.Unidad;

public class CrearDragonAccion implements Accion {
	Unidad unidad;
	
	public CrearDragonAccion(Unidad unidad) {
		this.unidad=unidad;
	}
	
	@Override
	public void execute(Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException {
		unidad.realizarAccion(new ContextoStrategy(new CrearDragon()), posicionDestino);
		
	}

}
