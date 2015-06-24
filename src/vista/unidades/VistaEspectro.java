package vista.unidades;

import java.io.IOException;

import titiritero.dibujables.Imagen;
import titiritero.modelo.ObjetoPosicionable;

public class VistaEspectro extends Imagen {
	
	//TODO falta buscar imagen pequeña
	public VistaEspectro(ObjetoPosicionable modelo) throws IOException {
		super(VistaEspectro.class.getResource("/vista/imagenes/espectro40-40.png"), modelo);
	}

}
