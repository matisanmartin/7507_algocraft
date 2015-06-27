package factory.construcciones;

import command.CrearAccesoAccion;
import command.CrearPilonAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;

import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

//TODO jl : DEFINIR COSTO, VIDA, ETC
public class CentroComandoProtoss extends Edificio {

	public CentroComandoProtoss(int alto, int ancho, Posicion posicion)
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
		agregarAccionDisponible("Crear Acceso", new CrearAccesoAccion(this));
		agregarAccionDisponible("Crear Pilon", new CrearPilonAccion(this));
		
	}

}