package factory.construcciones;

import java.io.IOException;

import strategy.ContextoStrategy;
import common.Posicion;
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
import model.ElementoArtificial;
import model.EspacioTerrestre;
import model.Juego;

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
	throws FactoryInvalidaException,UnidadInvalidaException, FueraDeRangoException,ElementoInvalidoException, PosicionInvalidaException,ElementoNoEncontradoException, FueraDeRangoDeVisionException,EnergiaInsuficienteException, CostoInvalidoException, RecursosInsuficientesException, CloneNotSupportedException, FinDePartidaException, PartidaGanadaException, PartidaPerdidaException, UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException, IOException{
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

	@Override
	public int getSuministro() {
		return 0;
	}

	@Override
	public void disminuirPoblacion() {
		Juego.getInstancia().getJugadorEnemigo().disminuirPoblacionDisponble(0);
		
	}


}
