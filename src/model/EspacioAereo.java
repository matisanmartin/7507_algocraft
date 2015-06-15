package model;

import java.util.List;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class EspacioAereo extends Espacio{
	
	@Override
	public List<Elemento> obtenerElementosDeCampoDeBatalla() throws PosicionInvalidaException, FueraDeRangoException {
		return CampoBatalla.getInstancia().obtenerElementosAereos();
	}

	@Override
	public void agregarElemento(Elemento elementoParaAgregar) throws PosicionInvalidaException, FueraDeRangoException{
		super.agregarElemento(elementoParaAgregar);
		CampoBatalla.getInstancia().posicionarElementoEnEspacioAereo(elementoParaAgregar);
	}
}
