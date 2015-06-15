package factory.unidades;

import model.Espacio;
import common.Costo;
import common.Posicion;
import common.Vitalidad;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class UnidadMagica extends Unidad {
	
	private static final int ENERGIA_INICIAL=50;
	private int energia;
	
	public UnidadMagica(int transporte, int vision, Costo costo,
			int tiempoConstruccion, String daño, int suministro,
			String rangoAtaque, Vitalidad vida, int alto, int ancho,
			Posicion posicion, Espacio espacio) throws FueraDeRangoException, PosicionInvalidaException {
		super(transporte, vision, costo, tiempoConstruccion, daño, suministro,
				rangoAtaque, vida, alto, ancho, posicion, espacio);
		this.setEnergia(ENERGIA_INICIAL);
		
	}
	
	public UnidadMagica() {
		super();
		// TODO msma: Temporal, borrar luego.
	}

	public void definirAccionesDisponibles(){
		super.definirAccionesDisponibles();
	}

	@Override
	public int getEnergia() {
		return energia;
	}

	@Override
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	@Override
	public void recibirEmp() {
		setEnergia(0);
		
	}

}
