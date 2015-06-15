package model;

import recursos.Cristal;
import common.Posicion;
import exceptions.FueraDeRangoException;

public class BaseSupIzq extends Base {

	public BaseSupIzq(Posicion pos) throws FueraDeRangoException {
		super(pos);
			//TODO jl:agregar metodo que detecte la posicion de los cristales a crear
		int posIInicial = this.getVolcan().get(0).getPosicion().getPosX();
		int posIFinal = this.getVolcan().get(0).getPosicion().getPosX() + this.getCantidadDeCristales()/2;
		int posJInicial = this.getVolcan().get(0).getPosicion().getPosY();
		int posJFinal = this.getVolcan().get(0).getPosicion().getPosY() + this.getCantidadDeCristales()/2;
		
			for (int i = (posIInicial); i <= (posIFinal); i++) {
				for (int j = (posJInicial); j <= (posJFinal); j++) {
					if( i == posIInicial || (j == posJInicial )){ 
						if( (i != posIInicial) || (j != posJInicial) ){ //no es la pos del volcan
							this.cristal.add(new Cristal(this.getAltoCristal(), this.getAnchoCristal(), new Posicion(i, j)));
						}
					}
				}
			}
			
		}
		
}


