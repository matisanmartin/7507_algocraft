package factory.unidades;

import command.RadiacionAccion;
import command.TormentaPsionicaAccion;
import common.Posicion;
import exceptions.FueraDeRangoException;

public class UnidadMagicaProtoss extends UnidadMagica {
	
	public UnidadMagicaProtoss(int unidadAltoTemplarioTransporte,
			int unidadAltoTemplarioVision, String unidadAltoTemplarioCosto,
			int unidadAltoTemplarioTiempoConstruccion,
			String unidadAltoTemplarioDaño, int unidadAltoTemplarioSuministro,
			String unidadAltoTemplarioRangoAtaque,
			String unidadAltoTemplarioVida, int unidadAlto, int unidadAncho,
			Posicion posicion) throws FueraDeRangoException {
		
		super(unidadAltoTemplarioTransporte,
			unidadAltoTemplarioVision, unidadAltoTemplarioCosto,
			unidadAltoTemplarioTiempoConstruccion,
			unidadAltoTemplarioDaño,unidadAltoTemplarioSuministro,
			unidadAltoTemplarioRangoAtaque,
			unidadAltoTemplarioVida,unidadAlto, unidadAncho,
			posicion);
	}

	public UnidadMagicaProtoss() {
		// TODO Auto-generated constructor stub
	}

	public void definirAccionesDisponibles(){
		//super.definirAccionesDisponibles();
		
		//TODO msma: Agregar validacion de vida/Energia cuando este implementado
		agregarAccionDisponible("TormentaPsionica", new TormentaPsionicaAccion(this));
		agregarAccionDisponible("Alucinacion",new RadiacionAccion(this));
	}

}
