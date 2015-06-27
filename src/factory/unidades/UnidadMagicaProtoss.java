package factory.unidades;

import command.AlucinacionAccion;
import command.MoverAccion;
import command.TormentaPsionicaAccion;
import common.Costo;
import common.Danio;
import common.Posicion;
import common.RangoAtaque;
import common.Vitalidad;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;
import model.Espacio;

public class UnidadMagicaProtoss extends UnidadMagica {
	
	private static final int ENERGIA_MAXIMA=200;
	private static final int ENERGIA_CAMBIO_DE_TURNO=15;
	private static final int ESCUDO_CAMBIO_DE_TURNO=10;
	
	public UnidadMagicaProtoss(int unidadTransporte,
			int unidadVision, Costo unidadCosto,
			int unidadTiempoConstruccion,
			Danio danio, int unidadSuministro,
			RangoAtaque unidadAltoTemplarioRangoAtaque,
			Vitalidad unidadVida, int unidadAlto, int unidadAncho,
			Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {
		
		super(unidadTransporte,
			unidadVision, unidadCosto,
			unidadTiempoConstruccion,
			danio,unidadSuministro,
			unidadAltoTemplarioRangoAtaque,
			unidadVida,unidadAlto, unidadAncho,
			posicion, espacio);
		
		this.definirAccionesDisponibles();
	}

	public UnidadMagicaProtoss() {

	}

	public void definirAccionesDisponibles(){
		agregarAccionDisponible("Mover", new MoverAccion(this));
		agregarAccionDisponible("TormentaPsionica", new TormentaPsionicaAccion(this));
		agregarAccionDisponible("Alucinacion", new AlucinacionAccion(this));
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
	
	public String toString() {
		StringBuffer strUnidadProtoss = new StringBuffer();
		
		
		strUnidadProtoss.append("<html>Unidad Seleccionada: <br>");
		strUnidadProtoss.append("Vida: "+getVida()+"<br>");
		strUnidadProtoss.append("Escudo "+getEscudo()+"<br>");
		strUnidadProtoss.append("Energia: "+getEnergia()+"<br>");
		strUnidadProtoss.append("Posicion: ("+getPosicion().getX()+","+getPosicion().getY()+")<br></html>");
		
		return strUnidadProtoss.toString();	
	}

}
