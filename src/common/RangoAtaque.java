package common;

public class RangoAtaque {

	private int rangoAtaqueAereo;
	private int rangoAtaqueTerrestre;
	
	public RangoAtaque(int rangoAtaqueAereo, int rangoAtaqueTerrestre) {
		this.rangoAtaqueAereo = rangoAtaqueAereo;
		this.rangoAtaqueTerrestre = rangoAtaqueTerrestre;
	}

	public int getRangoAtaqueAereo() {
		return rangoAtaqueAereo;
	}

	public int getRangoAtaqueTerrestre() {
		return rangoAtaqueTerrestre;
	}
	
	public boolean equals(RangoAtaque rango){
		return (this.rangoAtaqueAereo==rango.getRangoAtaqueAereo()&&this.rangoAtaqueTerrestre==rango.getRangoAtaqueTerrestre());
	}
}
