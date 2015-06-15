package factory.unidades;

import model.Espacio;
import command.AlucinacionAccion;
import command.TormentaPsionicaAccion;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class UnidadMagicaProtoss extends UnidadMagica {
	
	private static final int ENERGIA_MAXIMA=200;
	private static final int ENERGIA_CAMBIO_DE_TURNO=15;
	private static final int ESCUDO_CAMBIO_DE_TURNO=10;
	
	public UnidadMagicaProtoss(int unidadTransporte,
			int unidadVision, Costo unidadCosto,
			int unidadTiempoConstruccion,
			String unidadDaño, int unidadSuministro,
			String unidadRangoAtaque,
			Vitalidad unidadVida, int unidadAlto, int unidadAncho,
			Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {
		
		super(unidadTransporte,
			unidadVision, unidadCosto,
			unidadTiempoConstruccion,
			unidadDaño,unidadSuministro,
			unidadRangoAtaque,
			unidadVida,unidadAlto, unidadAncho,
			posicion, espacio);
		
		this.definirAccionesDisponibles();
	}

	public UnidadMagicaProtoss() {

	}

	public void definirAccionesDisponibles(){

		agregarAccionDisponible("TormentaPsionica", new TormentaPsionicaAccion(this));
		agregarAccionDisponible("Alucinacion",new AlucinacionAccion(this));
	}
	
	@Override
	public void agregarEnergiaPorPasoDeTurno(){
		
		if(this.getEnergia()>=ENERGIA_MAXIMA-ENERGIA_CAMBIO_DE_TURNO)
			this.setEnergia(ENERGIA_MAXIMA);
		else
			this.setEnergia(this.getEnergia()+ENERGIA_CAMBIO_DE_TURNO);
	}
	
	@Override
	public void agregarEscudoPorPasoDeTurno() {
		setEscudo(getEscudo()+ESCUDO_CAMBIO_DE_TURNO);
		
	}

}
