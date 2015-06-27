package factory.unidades;

import command.EmpAccion;
import command.RadiacionAccion;
import common.Costo;
import common.Danio;
import common.Posicion;
import common.RangoAtaque;
import common.Vitalidad;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import model.Espacio;

public class UnidadMagicaTerran extends UnidadMagica {
	
	private static final int ENERGIA_MAXIMA=200;
	private static final int ENERGIA_CAMBIO_DE_TURNO=10;
	
	public UnidadMagicaTerran(int unidadTransporte,
			int unidadVision, Costo unidadCosto,
			int unidadTiempoConstruccion,
			Danio danio, int unidadSuministro,
			RangoAtaque unidadNaveCienciaRangoAtaque, Vitalidad unidadVida,
			int unidadAlto, int unidadAncho, Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {

		super(unidadTransporte,
			unidadVision,unidadCosto,
			unidadTiempoConstruccion,
			danio,unidadSuministro,
			unidadNaveCienciaRangoAtaque, unidadVida,
			unidadAlto,unidadAncho,posicion, espacio);
		
		this.definirAccionesDisponibles();
	}

	public UnidadMagicaTerran() {
		// TODO Auto-generated constructor stub
	}

	public void definirAccionesDisponibles(){
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
