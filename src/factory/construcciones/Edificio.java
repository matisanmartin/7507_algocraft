package factory.construcciones;

import strategy.ContextoStrategy;
import model.ElementoArtificial;
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

public class Edificio extends ElementoArtificial {

	private int tiempoDeConstruccion;

	public Edificio(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		// TODO Auto-generated constructor stub
	}
	
	public int getTiempoDeConstruccion(){
		return this.tiempoDeConstruccion;
	}
	
	public void setTiempoDeConstruccion(int tiempo){
		this.tiempoDeConstruccion = tiempo;
	}

	@Override
	public void realizarAccion(ContextoStrategy contexto,Posicion posicionDestino) 
	throws FactoryInvalidaException,UnidadInvalidaException, FueraDeRangoException,ElementoInvalidoException, PosicionInvalidaException,ElementoNoEncontradoException, FueraDeRangoDeVisionException,EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException{
		contexto.ejecutarStrategy(this, posicionDestino);
	}

}
