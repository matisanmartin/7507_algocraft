package factory.construcciones;

import command.CrearEspectroAccion;
import command.CrearNaveCienciaAccion;
import command.CrearNaveTransporteTerranAccion;
import common.Posicion;

import exceptions.FueraDeRangoException;

public class PuertoEstelarTerran extends PuertoEstelar {

	public PuertoEstelarTerran(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("1300");
		this.setCosto("150M100G");
		this.definirAccionesDisponibles();
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Espectro", new CrearEspectroAccion(this));
		agregarAccionDisponible("Crear Nave Transporte Terran", new CrearNaveTransporteTerranAccion(this));
		agregarAccionDisponible("Crear Nave Ciencia", new CrearNaveCienciaAccion(this));
	}
	
}
