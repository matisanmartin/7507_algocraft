package factory.construcciones;

import strategy.ContextoStrategy;
import model.ElementoArtificial;
import model.EspacioTerrestre;
import common.Posicion;
import exceptions.CostoInvalidoException;
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

public class Edificio extends ElementoArtificial {

	private int tiempoDeConstruccion;

	public Edificio(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion, new EspacioTerrestre());
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
	throws FactoryInvalidaException,UnidadInvalidaException, FueraDeRangoException,ElementoInvalidoException, PosicionInvalidaException,ElementoNoEncontradoException, FueraDeRangoDeVisionException,EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException{
		contexto.ejecutarStrategy(this, posicionDestino);
	}
	
	//TODO msma:En principio se devuelve true ya que "esta muerta" a los fines de verificar el fin de la partida
	//pero no deberia ser asi
	@Override
	public boolean estaMuerta(){
		return true;
	}

	@Override
	public void agregarUnidad(ElementoArtificial elementoActuante)
			throws UnidadLlenaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCantidadDeUnidadesTransportadas() {
		// TODO Auto-generated method stub
		return 0;
	}


}
