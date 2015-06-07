package factory.construcciones;

import model.Volcan;


public abstract class ConstruccionSobreVolcan extends ConstruccionSobreRecurso {
	
	public ConstruccionSobreVolcan(Volcan volcan) {
		this.setPosicion(volcan.getPosicion());
	}

}
