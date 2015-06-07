package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.Posicion;
import exceptions.ElementoNoEncontradoException;

public class Armada {
	
	List<ElementoArtificial> elementos;
	int dimensionArmada;
	
	public Armada() {
		elementos = new ArrayList<ElementoArtificial>();
		dimensionArmada=0;
	}
	
	public Armada(List<ElementoArtificial> elem){
		elementos=elem;
		dimensionArmada=elem.size();
	}
	
	public int getDimensionArmada() {
		return elementos.size();
	}
	
	public List<ElementoArtificial> getArmada() {
		return elementos;
	}
	
	public void agregarElemento(ElementoArtificial elem) {
		elementos.add(elem);
		dimensionArmada=elementos.size();
	}
	
	//TODO msma: Falta contemplar el caso de que dos unidades esten en la misma posicion(aerea/terrestre)
	//En el caso de eliminarElemento, que en general se usaria cuando una unidad muere, sacarlo de la lista
	//simplementa bastaria con buscar todas las ocurrencias y eliminar el que tenga
	public void eliminarElementoMuertoEnPosicion(Posicion pos) {
	//se asume que existen como mucho 2 elementos en una misma posicion
	//uno en aire y otro en tierra
		
 		Iterator<ElementoArtificial> it = elementos.iterator();
		int indice = 0;
		int i=0;
	
		while(it.hasNext())
		{	
			ElementoArtificial actual = it.next();
			
			if(actual.getPosicion().equals(pos)&&actual.getVida().equals("0"))
				indice=i;
			i++;
		}
		
		elementos.remove(indice);
		
		dimensionArmada=elementos.size();
	}
	
	public ElementoArtificial obtenerElementoEnPosicion(Posicion pos) throws ElementoNoEncontradoException {
		
		Iterator<ElementoArtificial> it = elementos.iterator();
		
		while(it.hasNext())
		{
			ElementoArtificial actual = it.next();
			if(actual.getPosicion().equals(pos))
				return actual;
		}

		throw new ElementoNoEncontradoException();
	}

}
