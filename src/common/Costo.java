package common;

import exceptions.CostoInvalidoException;

public class Costo {

	private int costoMineral = 0;
	private int costoGas = 0;
	
	public Costo(int costoMineral, int costoGas){
		this.costoMineral=costoMineral;
		this.costoGas=costoGas;
	}
	
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
		this.costoMineral = Integer.parseInt(stringCantidadM);
		this.costoGas = Integer.parseInt(stringCantidadG);
	}
	
	public int getCostoMineral() {
		return costoMineral;
	}

	public int getCostoGas() {
		return costoGas;
	}

	public boolean cubreCosto(Costo costoAComparar) throws CostoInvalidoException {
		if (costoAComparar.getCostoMineral() >= this.costoMineral && 
				costoAComparar.getCostoGas() >= this.costoGas) return true;
		return false;
	}
	
	public boolean alcanzaCantidadMineral(int cantidadMRecibida) {
		return (cantidadMRecibida >= this.getCostoMineral());
	}
	
	public boolean alcanzaCantidadGas( int cantidadGRecibida) {
		return (cantidadGRecibida >= this.getCostoGas());
	}
	
	public boolean equals(Costo costo){
		return (this.costoGas==costo.getCostoGas()&&this.costoMineral==costo.getCostoMineral());
	}
}
