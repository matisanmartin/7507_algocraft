package command;

import strategy.ContextoStrategy;
import strategy.CrearGolliat;

import common.Posicion;

import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import exceptions.UnidadInvalidaException;
import factory.unidades.Unidad;

public class CrearGolliatAccion implements Accion {
	Unidad unidad;
	
	public CrearGolliatAccion(Unidad unidad) {
		this.unidad=unidad;
	}
	
	@Override
	public void execute(Posicion posicionDestino) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException {
		unidad.realizarAccion(new ContextoStrategy(new CrearGolliat()), posicionDestino);
		
	}

}
