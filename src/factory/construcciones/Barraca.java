package factory.construcciones;

import command.CrearMarineAccion;
import common.Posicion;
import exceptions.FueraDeRangoException;

public class Barraca extends Edificio {

	public Barraca(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException {
		super(alto, ancho, posicion);
		this.setCosto("150M");
		this.setTiempoDeConstruccion(12);
		this.setVida("1000");
		this.definirAccionesDisponibles();
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Marine", new CrearMarineAccion(this));
	}
}
