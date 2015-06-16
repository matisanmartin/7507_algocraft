package factory.construcciones;

import command.CrearFabricaAccion;
import command.CrearMarineAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class Barraca extends Edificio {

	public Barraca(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.setCosto(new Costo("150M"));
		this.setTiempoDeConstruccion(12);
		this.setVitalidad(new Vitalidad(1000,0));
		this.definirAccionesDisponibles();
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Marine", new CrearMarineAccion(this));
		agregarAccionDisponible("Crear Fabrica", new CrearFabricaAccion(this));
	}
}
