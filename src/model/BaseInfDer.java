package model;

import recursos.Cristal;
import common.Posicion;
import exceptions.FueraDeRangoException;

public class BaseInfDer extends Base {

	public BaseInfDer(Posicion pos) throws FueraDeRangoException {
		super(pos);
		int posIInicial = this.getVolcan().get(0).getPosicion().getPosX() - (this.getCantidadDeCristales()/2);
		int posIFinal = this.getVolcan().get(0).getPosicion().getPosX();
		int posJInicial = this.getVolcan().get(0).getPosicion().getPosY() - (this.getCantidadDeCristales()/2) ;
		int posJFinal = this.getVolcan().get(0).getPosicion().getPosY();
		
			for (int i = (posIInicial); i <= (posIFinal); i++) {
				for (int j = (posJInicial); j <= (posJFinal); j++) {
					if( i == posIFinal || (j == posJFinal )){ 
						if( (i != posIFinal) || (j != posJFinal) ){ //no es la pos del volcan
							this.cristal.add(new Cristal(this.getAltoCristal(), this.getAnchoCristal(), new Posicion(i, j)));
						}
					}
				}
			}
			
		}
}
