package jugador;

import model.Armada;
import model.ElementoArtificial;
import model.Espacio;
import razas.Raza;

import common.Posicion;

import exceptions.ColorInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.FueraDeRangoException;
import exceptions.NombreCortoException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosInsuficientesException;

public class Jugador {
	
	public static final int MIN_CARACT_NOMBRE=4;
	public static final int MAX_CANTIDAD_POBLACION = 200;
	
	String nombre;
	TipoColor color;
	Raza raza;
	Armada armada;

	private int cantidadDeCristal;
	private int cantidadDeGas;
	private int poblacionActual;
	private int poblacionDisponible;
	private int excesoPoblacion; //cuando se crea una "casa" y ya se llego a la maxima cant de poblacion (200)
	                             //la poblacion ganada se suma al exceso. Analogamente cuando se destruye una
	
	
	public int getExcesoPoblacion() {
		return excesoPoblacion;
	}
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
		this.poblacionActual = 0;
		this.poblacionDisponible = 100;
		this.excesoPoblacion = 0;
	}
	
	public void agregarElemento(ElementoArtificial elem) throws ElementoInvalidoException, RecursosInsuficientesException, PosicionInvalidaException, FueraDeRangoException {
		
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

	
	private void disminuirCantidadDeGas(int cantidadDeGas) {
		this.cantidadDeGas=this.cantidadDeGas-cantidadDeGas;	
	}
	private void disminuirCantidadDeCristal(int cantidadDeMineral) {	
		this.cantidadDeCristal=this.cantidadDeCristal-cantidadDeMineral;
	}
	public void disminuirRecursos(int cantidadDeMineral, int cantidadDeGas) {
		disminuirCantidadDeCristal(cantidadDeMineral);
		disminuirCantidadDeGas(cantidadDeGas);
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
	
	public void aumentarPoblacionDisponible(int aumento) {
		
		if (this.poblacionDisponible == MAX_CANTIDAD_POBLACION) {
			this.excesoPoblacion += aumento;
		}
		else {
			this.poblacionDisponible += aumento;
		}
	}
		
	public void disminuirPoblacionDisponble(int disminucion) {
		if (this.excesoPoblacion == 0) {
			this.poblacionDisponible -= disminucion;
		}
		else {
			this.excesoPoblacion -= disminucion;
		}
		
	}
	
	public void aumentarPoblacionActual(int aumento) {
		this.poblacionActual += aumento;
		
	}
	public int getPoblacionActual() {
		return poblacionActual;
	}
	public void setPoblacionActual(int poblacionActual) {
		this.poblacionActual = poblacionActual;
	}
	public int getPoblacionDisponible() {
		return poblacionDisponible;
	}
	public void setPoblacionDisponible(int poblacionDisponible) {
		this.poblacionDisponible = poblacionDisponible;
	}
	public void setMinerales(int cantM) {
		this.cantidadDeCristal = cantM;
		
	}
	public void setGas(int cantG) {
		this.cantidadDeGas = cantG;
		
	}

}
