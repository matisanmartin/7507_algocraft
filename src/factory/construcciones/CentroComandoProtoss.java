package factory.construcciones;

import command.CrearAccesoAccion;
import command.CrearAsimiladorAccion;
import common.Posicion;

import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class CentroComandoProtoss extends Edificio {

	public CentroComandoProtoss(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.definirAccionesDisponibles();
	}

	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Acceso", new CrearAccesoAccion(this));
		agregarAccionDisponible("Crear Asimilador", new CrearAsimiladorAccion(this));
		
	}

}