package factory.construcciones;

import command.CrearBarracaAccion;
import command.CrearDepositoSuministroAccion;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class CentroComandoTerran extends Edificio {

	public CentroComandoTerran(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.definirAccionesDisponibles();
	}

	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Barraca", new CrearBarracaAccion(this));
		agregarAccionDisponible("Crear Deposito Suministros", new CrearDepositoSuministroAccion(this));
		
	}

}
