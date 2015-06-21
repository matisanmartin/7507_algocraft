package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaAltoTemplario extends Imagen {
	
	public VistaAltoTemplario(ObjetoPosicionable modelo) throws IOException {
		super(VistaAltoTemplario.class.getResource("/vista/imagenes/altoTemplario30-30.png"), modelo);
	}

}
