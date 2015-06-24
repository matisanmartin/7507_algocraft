package factory.construcciones;

import command.CrearArchivosTemplariosAccion;
import command.CrearNaveTransporteProtossAccion;
import command.CrearScoutAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.CostoInvalidoException;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class PuertoEstelarProtoss extends PuertoEstelar {

	public PuertoEstelarProtoss(int alto, int ancho, Posicion posicion)
			throws FueraDeRangoException, CostoInvalidoException, PosicionInvalidaException {
		super(alto, ancho, posicion);
		this.setVitalidad(new Vitalidad(600,600));
		this.setCosto(new Costo("150M150G"));
		this.definirAccionesDisponibles();
	}
	
	public void definirAccionesDisponibles() {
		agregarAccionDisponible("Crear Scout", new CrearScoutAccion(this));
		agregarAccionDisponible("Crear Nave Transporte", new CrearNaveTransporteProtossAccion(this));
		agregarAccionDisponible("Crear ArchivosTemplarios", new CrearArchivosTemplariosAccion(this));
	}

}
