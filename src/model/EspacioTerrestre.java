package model;

import java.util.List;

import exceptions.PosicionInvalidaException;

public class EspacioTerrestre extends Espacio {
	
	@Override
	public List<Elemento> obtenerElementosDeCampoDeBatalla() {
		return CampoBatalla.getInstancia().obtenerElementosTerrestres();
	}
	
	@Override
	public void agregarElemento(Elemento elementoParaAgregar) throws PosicionInvalidaException{
		super.agregarElemento(elementoParaAgregar);
		CampoBatalla.getInstancia().posicionarElementoEnEspacioTerrestre(elementoParaAgregar);
	}

}
