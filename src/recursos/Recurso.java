package recursos;

import java.io.IOException;

import model.Elemento;
import model.EspacioTerrestre;
import strategy.ContextoStrategy;

import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;

public class Recurso extends Elemento {

	public Recurso(int alto, int ancho, Posicion posicion) throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion,new EspacioTerrestre());
		setVitalidad(new Vitalidad(0,0));
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarAccion(ContextoStrategy contexto, Posicion posicionDestino) 
	throws UnidadLlenaException, FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException, ElementoInvalidoException, PosicionInvalidaException, ElementoNoEncontradoException, FueraDeRangoDeVisionException, EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, DanioInvalidoException, CloneNotSupportedException, RecursosFaltantesException, PoblacionFaltanteException, IOException {
		contexto.ejecutarStrategy(this, posicionDestino);
	}
	
	@Override
	public boolean estaMuerta(){
		return true;
	}

	

}
