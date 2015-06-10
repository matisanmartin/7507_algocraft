package factory.unidades;

import common.Posicion;

import exceptions.FueraDeRangoException;

public class UnidadMagica extends Unidad {
	
	public UnidadMagica(int transporte, int vision, String costo,
			int tiempoConstruccion, String daño, int suministro,
			String rangoAtaque, String unidadMarineVida, int alto, int ancho,
			Posicion posicion) throws FueraDeRangoException {
		super(transporte, vision, costo, tiempoConstruccion, daño, suministro,
				rangoAtaque, unidadMarineVida, alto, ancho, posicion);
	}
	
	public UnidadMagica() {
		super();
		// TODO msma: Temporal, borrar luego.
	}

	public void definirAccionesDisponibles(){
		super.definirAccionesDisponibles();
	}

}
