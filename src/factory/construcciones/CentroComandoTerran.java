package factory.construcciones;

import command.CrearBarracaAccion;

//TODO jl : DEFINIR COSTO, VIDA, ETC
import command.CrearDepositoSuministroAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class CentroComandoTerran extends Edificio {

	public CentroComandoTerran(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		try {
			this.setCosto(new Costo("0M0G"));
		} catch (CostoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setTiempoDeConstruccion(0);
		this.setVitalidad(new Vitalidad(100000,0));
		this.definirAccionesDisponibles();
	}

	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Barraca", new CrearBarracaAccion(this));
		agregarAccionDisponible("Crear Deposito Suministros", new CrearDepositoSuministroAccion(this));
		
	}

}
