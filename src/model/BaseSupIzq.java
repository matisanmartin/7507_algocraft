package model;

import recursos.Cristal;
import common.Posicion;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public class BaseSupIzq extends Base {

	public BaseSupIzq(Posicion pos) throws FueraDeRangoException, PosicionInvalidaException {
		super(pos);
		int ancho = this.getAnchoCristal();
		int alto = this.getAltoCristal();
//			//TODO jl:agregar metodo que detecte la posicion de los cristales a crear
//		int posIInicial = this.getVolcan().get(0).getPosicion().getX();
//		int posIFinal = this.getVolcan().get(0).getPosicion().getX() + this.getCantidadDeCristales()/2;
//		int posJInicial = this.getVolcan().get(0).getPosicion().getY();
//		int posJFinal = this.getVolcan().get(0).getPosicion().getY() + this.getCantidadDeCristales()/2;
//		
//			for (int i = (posIInicial); i <= (posIFinal); i++) {
//				for (int j = (posJInicial); j <= (posJFinal); j++) {
//					if( i == posIInicial || (j == posJInicial )){ 
//						if( (i != posIInicial) || (j != posJInicial) ){ //no es la pos del volcan
//							this.cristal.add(new Cristal(this.getAltoCristal(), this.getAnchoCristal(), new Posicion(i, j)));
//						}
//					}
//				}
//			}
		
		for (int i = 1; i <= this.getCantidadDeCristales(); i++) {
			Cristal cristal = new Cristal(this.getAltoCristal(), this.getAnchoCristal(), new Posicion(pos.getX(), pos.getY()+ (i*ancho)));
			this.cristal.add(cristal);
			Cristal cristal2 = new Cristal(this.getAltoCristal(), this.getAnchoCristal(), new Posicion(pos.getX()+(i * alto), pos.getY()));
			this.cristal.add(cristal2);
		}
		
	}

	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}
		
}


