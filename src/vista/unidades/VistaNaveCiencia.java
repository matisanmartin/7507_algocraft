package vista.unidades;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaNaveCiencia extends Imagen {
	
	public VistaNaveCiencia(ObjetoPosicionable modelo) throws IOException {
		super(VistaNaveCiencia.class.getResource("/imagenes/naveciencia.png"), modelo);
	}

}
