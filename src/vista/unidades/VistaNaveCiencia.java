package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaNaveCiencia extends Imagen {
	
	public VistaNaveCiencia(ObjetoPosicionable modelo) throws IOException {
		super(VistaNaveCiencia.class.getResource("/vista/imagenes/naveciencia.png"), modelo);
	}

}
