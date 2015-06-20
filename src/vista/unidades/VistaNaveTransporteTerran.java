package vista.unidades;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaNaveTransporteTerran extends Imagen {
	
	public VistaNaveTransporteTerran(ObjetoPosicionable modelo) throws IOException {
		super(VistaNaveTransporteTerran.class.getResource("/vista/imagenes/navetransporteterran.png"), modelo);
	}

}
