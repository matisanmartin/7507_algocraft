package factory.construcciones;

import command.CrearGolliatAccion;
import common.Posicion;

import exceptions.FueraDeRangoException;

public class Fabrica extends Edificio {

	public Fabrica(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("200M100G");
		this.setTiempoDeConstruccion(12);
		this.setVida("1250");
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Golliat", new CrearGolliatAccion(this));
	}
	
}
