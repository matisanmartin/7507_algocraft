package factory.construcciones;

import command.CrearAltoTemplarioAccion;
import common.Posicion;

import exceptions.FueraDeRangoException;

public class ArchivoTemplario extends Edificio {

	public ArchivoTemplario(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("150M200G");
		this.setTiempoDeConstruccion(9);
		this.setVida("500/500");
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Alto Templario", new CrearAltoTemplarioAccion(this));
	}
	
}
