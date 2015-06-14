package model;

import java.util.List;

import exceptions.PosicionInvalidaException;

public class EspacioAereo extends Espacio{
	
	@Override
	public List<Elemento> obtenerElementosDeCampoDeBatalla() {
		return CampoBatalla.getInstancia().obtenerElementosAereos();
	}

	@Override
	public void agregarElemento(Elemento elementoParaAgregar) throws PosicionInvalidaException{
		super.agregarElemento(elementoParaAgregar);
		CampoBatalla.getInstancia().posicionarElementoEnEspacioAereo(elementoParaAgregar);
	}
}
