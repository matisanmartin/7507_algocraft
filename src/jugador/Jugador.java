package jugador;

import common.Posicion;

import model.Armada;
import model.ElementoArtificial;
import razas.Raza;
import exceptions.ColorInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.NombreCortoException;

public class Jugador {
	
	public static final int MIN_CARACT_NOMBRE=4;
	
	String nombre;
	TipoColor color;
	Raza raza;
	Armada armada;

	private int cantidadDeCristal;
	private int cantidadDeGas;
	
	public Jugador(String nombre,TipoColor color,Raza raza) 
	throws NombreCortoException, ColorInvalidoException {
		
		if(nombre.length()<MIN_CARACT_NOMBRE)
			throw new NombreCortoException();
		
		if(color== TipoColor.ERROR)
			throw new ColorInvalidoException();
		
		this.nombre=nombre;
		this.color=color;
		this.raza=raza;
		
		armada = new Armada();
		
		this.cantidadDeCristal = 200;
		this.cantidadDeGas = 0;
	}
	
	public void agregarElemento(ElementoArtificial elem) throws ElementoInvalidoException {
		
		if(elem==null)
			throw new ElementoInvalidoException();
		
		armada.agregarElemento(elem);
	}
	
	public void eliminarElementoMuertoEnPosicion(Posicion pos){
		
		armada.eliminarElementoMuertoEnPosicion(pos);
	}
	
	public int obtenerDimensionArmada(){
		return armada.getDimensionArmada();
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public Raza getRaza() {
		// TODO Auto-generated method stub
		return this.raza;
	}

	public TipoColor getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	public int getCantidadDeCristal() {
		// TODO Auto-generated method stub
		return this.cantidadDeCristal;
	}

	public int getCantidadDeGas() {
		// TODO Auto-generated method stub
		return this.cantidadDeGas;
	}


}
