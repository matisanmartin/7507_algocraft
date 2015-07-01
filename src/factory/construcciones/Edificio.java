package factory.construcciones;

import java.io.IOException;

import model.CampoBatalla;
import model.Elemento;
import model.ElementoArtificial;
import model.Juego;
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

public class Edificio extends ElementoArtificial {

	private int tiempoDeConstruccion;

	public Edificio(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion, CampoBatalla.getInstancia().getEspacioTerrestre());
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
	public int getVida() {
		return 0;
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

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarUnidad(Elemento unidadASubir)
			throws UnidadLlenaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		
		StringBuffer strUnidad = new StringBuffer();
		strUnidad.append("<html>Edificio Seleccionado:<br>");
		strUnidad.append("Posicion: ("+getPosicion().getX()+","+getPosicion().getY()+")<br></html>");
		
		return strUnidad.toString();	
	}
}
