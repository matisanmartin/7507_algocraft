package common;

import exceptions.DanioInvalidoException;

public class Danio {

	private int danioA = 0;
	private int danioT = 0;
	
	public Danio(String danioConcatenado) throws DanioInvalidoException {
		String stringDanioA;
		String stringDanioT;
		int posicionA = 0;
		int posicionT = 0;
		for (int i = 0; i < danioConcatenado.length(); i++) {
			if (danioConcatenado.charAt(i) == 'A') posicionA = i;
			if (danioConcatenado.charAt(i) == 'T') posicionT = i;
		}
		if (posicionA == 0 || posicionT == 0) throw new DanioInvalidoException();
		stringDanioA = danioConcatenado.substring(0, posicionA);
		stringDanioT = danioConcatenado.substring(posicionA+1, posicionT);
		this.danioA = Integer.parseInt(stringDanioA);
		this.danioT = Integer.parseInt(stringDanioT);
	}
	
	public int getDanioA() {
		return danioA;
	}

	public int getDanioT() {
		return danioT;
	}

}