package factory.construcciones;

import command.CrearNaveTransporteProtossAccion;
import command.CrearScoutAccion;
import common.Posicion;

import exceptions.FueraDeRangoException;

public class PuertoEstelarProtoss extends PuertoEstelar {

	public PuertoEstelarProtoss(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setVida("600/600");
		this.setCosto("150M150G");
		this.definirAccionesDisponibles();
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Scout", new CrearScoutAccion(this));
		agregarAccionDisponible("Crear Nave Transporte Protoss", new CrearNaveTransporteProtossAccion(this));
	}

}
