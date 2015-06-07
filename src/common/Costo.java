package common;

import exceptions.CostoInvalidoException;

public class Costo {

	private int cantidadM = 0;
	private int cantidadG = 0;
	
	public Costo(String costoConcatenado) throws CostoInvalidoException {
		String stringCantidadM;
		String stringCantidadG;
		int posicionM = 0;
		int posicionG = 0;
		for (int i = 0; i < costoConcatenado.length(); i++) {
			if (costoConcatenado.charAt(i) == 'M') posicionM = i;
			if (costoConcatenado.charAt(i) == 'G') posicionG = i;
		}
		if (posicionM == 0) throw new CostoInvalidoException();
		stringCantidadM = costoConcatenado.substring(0, posicionM);
		if (posicionG == 0) {
			stringCantidadG = "0";
		}
		else {
			stringCantidadG = costoConcatenado.substring(posicionM+1,posicionG);
		}
		this.cantidadM = Integer.parseInt(stringCantidadM);
		this.cantidadG = Integer.parseInt(stringCantidadG);
	}
	
	public int getCantidadM() {
		return cantidadM;
	}

	public int getCantidadG() {
		return cantidadG;
	}

	public boolean cubreCosto(Costo costoAComparar) throws CostoInvalidoException {
		if (costoAComparar.getCantidadM() >= this.cantidadM && 
				costoAComparar.getCantidadG() >= this.cantidadG) return true;
		return false;
	}
	
	public boolean alcanzaCantidadM(int cantidadMRecibida) {
		return (cantidadMRecibida >= this.getCantidadM());
	}
	
	public boolean alcanzaCantidadG(int cantidadGRecibida) {
		return (cantidadGRecibida >= this.getCantidadG());
	}
}
