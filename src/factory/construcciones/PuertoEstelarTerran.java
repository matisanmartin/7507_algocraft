package factory.construcciones;

import command.CrearEspectroAccion;
import command.CrearNaveCienciaAccion;
import command.CrearNaveTransporteTerranAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class PuertoEstelarTerran extends PuertoEstelar {

	public PuertoEstelarTerran(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.setVitalidad(new Vitalidad(1300,0));
		this.setCosto(new Costo("150M100G"));
		this.definirAccionesDisponibles();
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Espectro", new CrearEspectroAccion(this));
		agregarAccionDisponible("Crear Nave Transporte Terran", new CrearNaveTransporteTerranAccion(this));
		agregarAccionDisponible("Crear Nave Ciencia", new CrearNaveCienciaAccion(this));
	}
	
}
