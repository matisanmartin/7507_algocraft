package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaNaveTransporteTerran extends Imagen {
	
	public VistaNaveTransporteTerran(ObjetoPosicionable modelo) throws IOException {
		super(VistaNaveTransporteTerran.class.getResource("/vista/imagenes/navetransporteterran.png"), modelo);
	}

}
