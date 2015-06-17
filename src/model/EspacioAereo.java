package model;

import java.util.List;

import common.Danio;
import common.RangoAtaque;

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
	
	@Override
	public int getDanio(Danio danio) {
		return danio.getDanioA();
	}
	
	@Override
	public int getRangoDeAtaque(RangoAtaque rangoAtaque) {
		return rangoAtaque.getRangoAtaqueAereo();
	}
}
