package factory.unidades;

import command.EmpAccion;
import command.RadiacionAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.FueraDeRangoException;

public class UnidadMagicaTerran extends UnidadMagica {
	
	private static final int ENERGIA_MAXIMA=200;
	private static final int ENERGIA_CAMBIO_DE_TURNO=10;
	
	public UnidadMagicaTerran(int unidadTransporte,
			int unidadVision, Costo unidadCosto,
			int unidadTiempoConstruccion,
			String unidadDaño, int unidadSuministro,
			String unidadRangoAtaque, Vitalidad unidadVida,
			int unidadAlto, int unidadAncho, Posicion posicion) throws FueraDeRangoException {

		super(unidadTransporte,
			unidadVision,unidadCosto,
			unidadTiempoConstruccion,
			unidadDaño,unidadSuministro,
			unidadRangoAtaque, unidadVida,
			unidadAlto,unidadAncho,posicion);
		
		//Energia inicial de nave de ciencia
		this.definirAccionesDisponibles();
	}

	public UnidadMagicaTerran() {
		// TODO Auto-generated constructor stub
	}

	public void definirAccionesDisponibles(){
		//super.definirAccionesDisponibles();
		//TODO msma: Agregar validacion de vida/Energia cuando este implementado
		agregarAccionDisponible("Emp", new EmpAccion(this));
		agregarAccionDisponible("Radiacion",new RadiacionAccion(this));
	}
	
	@Override
	public void agregarEnergiaPorPasoDeTurno(){
		
		if(this.getEnergia()>=ENERGIA_MAXIMA-ENERGIA_CAMBIO_DE_TURNO)
			this.setEnergia(ENERGIA_MAXIMA);
		else
			this.setEnergia(this.getEnergia()+ENERGIA_CAMBIO_DE_TURNO);
	}

}
