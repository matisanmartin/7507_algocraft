package factory.construcciones;

import command.CrearGolliatAccion;
import command.CrearPuertoEstelarTerranAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Fabrica extends Edificio {

	public Fabrica(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.setCosto(new Costo("200M100G"));
		this.setTiempoDeConstruccion(12);
		this.setVitalidad(new Vitalidad(1250,0));
		this.definirAccionesDisponibles();
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Golliat", new CrearGolliatAccion(this));
		agregarAccionDisponible("Crear PuertoEstelarTerran", new CrearPuertoEstelarTerranAccion(this));
	}
	
}
