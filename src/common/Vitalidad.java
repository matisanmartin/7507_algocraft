package common;

public class Vitalidad {

	int vida;
	int escudo;
	
	public Vitalidad(int vida,int escudo){
		this.vida=vida;
		this.escudo=escudo;
	}
	
	public void restarVitalidad(int da�o){
		
		if(getEscudo()==0){
			setVida(getVida()-da�o);
		}
		else if(escudo<da�o){
			setEscudo(0);
			setVida(getVida()-(da�o-getEscudo()));
		}
		else
			setEscudo(getEscudo()-da�o);
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
