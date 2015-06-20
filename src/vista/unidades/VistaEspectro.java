package vista.unidades;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaEspectro extends Imagen {
	
	public VistaEspectro(ObjetoPosicionable modelo) throws IOException {
		super(VistaEspectro.class.getResource("/imagenes/espectro.png"), modelo);
	}

}
