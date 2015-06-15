package model;

import java.util.List;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class EspacioTerrestre extends Espacio {
	
	@Override
	public List<Elemento> obtenerElementosDeCampoDeBatalla() throws PosicionInvalidaException, FueraDeRangoException {
		return CampoBatalla.getInstancia().obtenerElementosTerrestres();
	}
	
	@Override
	public void agregarElemento(Elemento elementoParaAgregar) throws PosicionInvalidaException, FueraDeRangoException{
		super.agregarElemento(elementoParaAgregar);
		CampoBatalla.getInstancia().posicionarElementoEnEspacioTerrestre(elementoParaAgregar);
	}
	
	//TODO jl:agregado provisoriamente
	public void agregarBase(Base base){
		this.espacio.add(base);
	}

}
