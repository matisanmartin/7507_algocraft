package recursos;

import java.util.Hashtable;
import java.util.Map;

import model.Juego;
import razas.Raza;

import command.Accion;
import common.Posicion;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Volcan extends Recurso {

	public Volcan(int alto, int ancho, Posicion posicion) throws FueraDeRangoException, PosicionInvalidaException, CostoInvalidoException {	
		super(alto, ancho, posicion);
		definirAccionesDisponibles();
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void definirAccionesDisponibles() throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException{
		
		Raza razaJugador = Juego.getInstancia().getJugadorActual().getRaza();
		
		Map<String, Accion> acciones = new Hashtable<String, Accion>();
		acciones.put("Crear Recolector de Gas", razaJugador.obtenerAccionRecolectorDeGas(this));		
		setAccionesDisponibles(acciones);
	}
	
	public String toString() {
		StringBuffer volcan = new StringBuffer();
		
		
		volcan.append("<html>Recurso Seleccionado: Volcan <br>");
		volcan.append("Posicion: ("+getPosicion().getX()+","+getPosicion().getY()+")<br><html>");
		
		return volcan.toString();	
	}
}
