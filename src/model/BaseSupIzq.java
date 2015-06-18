package model;

import recursos.Cristal;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class BaseSupIzq extends Base {

	public BaseSupIzq(Posicion pos) throws FueraDeRangoException, PosicionInvalidaException {
		super(pos);
			//TODO jl:agregar metodo que detecte la posicion de los cristales a crear
		int posIInicial = this.getVolcan().get(0).getPosicion().getX();
		int posIFinal = this.getVolcan().get(0).getPosicion().getX() + this.getCantidadDeCristales()/2;
		int posJInicial = this.getVolcan().get(0).getPosicion().getY();
		int posJFinal = this.getVolcan().get(0).getPosicion().getY() + this.getCantidadDeCristales()/2;
		
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

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}
		
}


