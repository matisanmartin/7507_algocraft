package model;

import recursos.Cristal;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class BaseSupDer extends Base {

	public BaseSupDer(Posicion pos) throws FueraDeRangoException, PosicionInvalidaException {
		super(pos);
		int posIInicial = this.getVolcan().get(0).getPosicion().getX() ;
		int posIFinal = this.getVolcan().get(0).getPosicion().getX() + (this.getCantidadDeCristales()/2);
		int posJInicial = this.getVolcan().get(0).getPosicion().getY() - (this.getCantidadDeCristales()/2) ;
		int posJFinal = this.getVolcan().get(0).getPosicion().getY();
		
			for (int i = (posIInicial); i <= (posIFinal); i++) {
				for (int j = (posJInicial); j <= (posJFinal); j++) {
					if( i == posIInicial || (j == posJFinal )){ 
						if( (i != posIInicial) || (j != posJFinal) ){ //no es la pos del volcan
							this.cristal.add(new Cristal(this.getAltoCristal(), this.getAnchoCristal(), new Posicion(i, j)));
						}
					}
				}
			}
			
		}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}
}

