package recursos;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import razas.Raza;
import strategy.ContextoStrategy;
import strategy.CrearNexoMineral;
import command.Accion;
import command.AtaqueAccion;
import command.MoverAccion;
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
import model.CampoBatalla;
import model.Elemento;
import model.EspacioTerrestre;
import model.Juego;

public class Cristal extends Recurso {

	public Cristal(int alto, int ancho, Posicion posicion) throws FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException {
		super(alto, ancho, posicion);
		this.definirAccionesDisponibles();
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void definirAccionesDisponibles() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		
		Raza razaJugador = Juego.getInstancia().getJugadorActual().getRaza();
		
		Map<String, Accion> acciones = new Hashtable<String, Accion>();
		acciones.put("Crear Recolector de Cristal", razaJugador.obtenerAccionRecolectorDeMinerales(this));		
		setAccionesDisponibles(acciones);
	}
	
	public String toString() {
		StringBuffer cristal = new StringBuffer();
		
		
		cristal.append("<html>Recurso Seleccionada: Cristal <br>");
		cristal.append("Posicion: ("+getPosicion().getX()+","+getPosicion().getY()+")<br><html>");
		
		return cristal.toString();	
	}

}
