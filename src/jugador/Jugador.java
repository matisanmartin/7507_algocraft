package jugador;

import model.Armada;
import model.CampoBatalla;
import model.ElementoArtificial;
import model.Espacio;
import razas.Raza;
import common.Posicion;
import exceptions.ColorInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.NombreCortoException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;

public class Jugador {
	
	public static final int MIN_CARACT_NOMBRE=4;
	
	String nombre;
	TipoColor color;
	Raza raza;
	Armada armada;

	private int cantidadDeCristal;
	private int cantidadDeGas;
	
	public Jugador() {
	}
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
	
	public void agregarElemento(ElementoArtificial elem) throws ElementoInvalidoException, RecursosInsuficientesException, PosicionInvalidaException {
		
		if(elem==null)
			throw new ElementoInvalidoException();
		armada.agregarElemento(elem);

	}
	
//	public void generarNuevaUnidad(TipoUnidad unidad){
//		
//	}
	public void eliminarElementoMuertoEnPosicion(Posicion pos){
		
		armada.eliminarElementoMuertoEnPosicion(pos);
	}
	
	public int obtenerDimensionArmada(){
		return armada.getDimensionArmada();
	}
	
	public Armada obtenerArmada() {
		return armada;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Raza getRaza() {
		return this.raza;
	}

	public TipoColor getColor() {
		return this.color;
	}

	public int getCantidadDeCristal() {
		return this.cantidadDeCristal;
	}

	public int getCantidadDeGas() {
		return this.cantidadDeGas;
	}
	public void agregarCantidadDeCristal(int cantidadDeMineral) {	
		this.cantidadDeCristal=this.cantidadDeCristal+cantidadDeMineral;
	}
	public void agregarCantidadDeGas(int cantidadDeGas) {
		this.cantidadDeGas=this.cantidadDeGas+cantidadDeGas;
		
	}
	public void actualizarUnidades() {
		armada.actualizarUnidades();
		
	}
	public boolean elementoMePertenece(Posicion pos, Espacio espacio) {
		
		try
		{
			
			armada.obtenerElementoEnPosicion(pos);
		}
		catch(ElementoNoEncontradoException ene)
		{
			return false;
		}
		
		return true;
	}


}
