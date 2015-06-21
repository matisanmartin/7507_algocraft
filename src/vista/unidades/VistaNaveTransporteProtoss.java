package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaNaveTransporteProtoss extends Imagen {
	
	public VistaNaveTransporteProtoss(ObjetoPosicionable modelo) throws IOException {
		super(VistaNaveTransporteProtoss.class.getResource("/vista/imagenes/navetransporteprotoss.png"), modelo);
	}

}
