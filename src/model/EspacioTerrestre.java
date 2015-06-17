package model;

import java.util.List;

import common.Danio;
import common.RangoAtaque;

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
	
	@Override
	public int getDanio(Danio danio) {
		return danio.getDanioT();
	}
	
	//TODO jl:agregado provisoriamente
	public void agregarBase(Base base){
		this.espacio.add(base);
	}

	@Override
	public int getRangoDeAtaque(RangoAtaque rangoAtaque) {
		return rangoAtaque.getRangoAtaqueTerrestre();
	}
}
