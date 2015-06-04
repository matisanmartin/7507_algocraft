package model;

import common.Constantes;
import controller.Posicion;
import exceptions.FueraDeRangoException;

public class BaseSuperior extends Base {

	public BaseSuperior(Posicion pos) throws FueraDeRangoException {
		super(pos);
		// TODO Auto-generated constructor stub
	}

//	public BaseSuperior(Posicion pos) throws FueraDeRangoException {
//		super(pos);
//		for (int i = 0; i < Base.CANTIDAD_DE_CRISTALES-1; i++) {
//			for (int j = 0; j < Base.CANTIDAD_DE_CRISTALES-1; j++) {
//				if(!pos.equals(new Posicion(i,j)) || (pos.getPosX() != Constantes.POS_INICIAL) ){
//					this.agregarRecurso(new Cristal(pos));
//				}
//			}
//		}
//		
//	}
	
//	public BaseSuperior(Posicion pos) throws FueraDeRangoException {
//		super(pos);
//		//para probar
//		this.agregarRecurso(new Volcan(new Posicion(1, 1)));
//		this.agregarRecurso(new Cristal(new Posicion(1, 2)));
//		this.agregarRecurso(new Cristal(new Posicion(1, 3)));
//	
//		
//		
//	}
//	
}
