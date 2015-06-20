package vista.unidades;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaAltoTemplario extends Imagen {
	
	public VistaAltoTemplario(ObjetoPosicionable modelo) throws IOException {
		super(VistaAltoTemplario.class.getResource("/imagenes/altotemplario.png"), modelo);
	}

}
