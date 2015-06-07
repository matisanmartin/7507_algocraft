package model;

import java.util.ArrayList;

import controller.Posicion;
import exceptions.FueraDeRangoException;

public class Base extends ElementoImpl {
	
	private ArrayList<Recurso> recursos;
	public static final int CANTIDAD_DE_CRISTALES = 4;
	
	//La posicion representa al vertice de la base
	//Ej VCC
	//   C
	//   C  
	//
	//
	
	public Base(Posicion pos) throws FueraDeRangoException{
		this.setPosicion(pos);
		this.recursos = new ArrayList<Recurso>();
		
		//carga de prueba
		this.cargaDeRecursos();

	}
	
	private void cargaDeRecursos() throws FueraDeRangoException{
		this.agregarRecurso(new Volcan(new Posicion(1, 1)));
		this.agregarRecurso(new Cristal(new Posicion(1, 2)));
		this.agregarRecurso(new Cristal(new Posicion(1, 3)));
		this.agregarRecurso(new Cristal(new Posicion(2, 1)));
		this.agregarRecurso(new Cristal(new Posicion(3, 1)));
		
		
	}

	public ArrayList<Recurso> getRecursos(){
		return this.recursos;
	}
	
	public void agregarRecurso(Recurso recurso){
		this.recursos.add(recurso);
	}
	@Override
	public void posicionar(Posicion nuevaPosicion) throws FueraDeRangoException {
		// TODO Auto-generated method stub
		
	}

}
