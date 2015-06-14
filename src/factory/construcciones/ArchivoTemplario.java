package factory.construcciones;

import command.CrearAltoTemplarioAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;

public class ArchivoTemplario extends Edificio {

	public ArchivoTemplario(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException {
		super(alto, ancho, posicion);
		this.setCosto(new Costo("150M200G"));
		this.setTiempoDeConstruccion(9);
		this.setVitalidad(new Vitalidad(500,500));
		this.definirAccionesDisponibles();
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Alto Templario", new CrearAltoTemplarioAccion(this));
	}
	
}
