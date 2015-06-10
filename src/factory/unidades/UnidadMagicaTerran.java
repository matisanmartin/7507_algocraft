package factory.unidades;

import command.EmpAccion;
import command.RadiacionAccion;
import common.Posicion;
import exceptions.FueraDeRangoException;

public class UnidadMagicaTerran extends UnidadMagica {
	
	public UnidadMagicaTerran(int unidadNaveCienciaTransporte,
			int unidadNaveCienciaVision, String unidadNaveCienciaCosto,
			int unidadNaveCienciaTiempoConstruccion,
			String unidadNaveCienciaDaño, int unidadNaveCienciaSuministro,
			String unidadNaveCienciaRangoAtaque, String unidadNaveCienciaVida,
			int unidadAlto, int unidadAncho, Posicion posicion) throws FueraDeRangoException {

		super(unidadNaveCienciaTransporte,
			unidadNaveCienciaVision,unidadNaveCienciaCosto,
			unidadNaveCienciaTiempoConstruccion,
			unidadNaveCienciaDaño,unidadNaveCienciaSuministro,
			unidadNaveCienciaRangoAtaque, unidadNaveCienciaVida,
			unidadAlto,unidadAncho,posicion);
	}

	public UnidadMagicaTerran() {
		// TODO Auto-generated constructor stub
	}

	public void definirAccionesDisponibles(){
		super.definirAccionesDisponibles();
		//TODO msma: Agregar validacion de vida/Energia cuando este implementado
		agregarAccionDisponible("Emp", new EmpAccion(this));
		agregarAccionDisponible("Radiacion",new RadiacionAccion(this));
	}

}
