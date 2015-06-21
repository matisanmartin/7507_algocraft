package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaMarine extends Imagen {

	public VistaMarine(ObjetoPosicionable modelo) throws IOException {
		super(VistaMarine.class.getResource("/vista/imagenes/terran-marine.png"), modelo);
	}
	
	

}
