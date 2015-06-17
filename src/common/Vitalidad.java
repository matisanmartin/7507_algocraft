package common;

public class Vitalidad {

	int vida;
	int escudo;
	
	public Vitalidad(int vida,int escudo){
		this.vida=vida;
		this.escudo=escudo;
	}
	
	public void restarVitalidad(int danio){
		
		if(getEscudo()==0){
			setVida(getVida()-danio);
		}
		else if(escudo<danio){
			setEscudo(0);
			setVida(getVida()-(danio-getEscudo()));
		}
		else
			setEscudo(getEscudo()-danio);
	}

	public void setEscudo(int i) {
		escudo=i;
		
	}

	public void setVida(int i) {
		if(i<=0)
			vida=0;
		else
			vida=i;
		
	}

	public int getVida() {
		return vida;
	}

	public int getEscudo() {
		return escudo;
	}
	
	public boolean equals(Vitalidad otraVitalidad){
		return (otraVitalidad.getEscudo()==escudo&&otraVitalidad.getVida()==vida);
	}
		
}
