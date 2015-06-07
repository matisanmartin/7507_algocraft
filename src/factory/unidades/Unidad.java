package factory.unidades;

import java.util.List;

import model.ElementoArtificial;
import model.ElementoArtificialImpl;
import strategy.ContextoStrategy;
import exceptions.FactoryInvalidaException;
import exceptions.FueraDeRangoException;
import exceptions.UnidadInvalidaException;

public class Unidad extends ElementoArtificialImpl {

	private int transporte;
	private int vision;
	private int tiempoConstruccion;
	private String daño;
	private int suministro;
	private String rangoAtaque;

	public Unidad(int transporte, int vision, String costo, int tiempoConstruccion, 
			          String daño, int suministro,String rangoAtaque, String unidadMarineVida) {
		
		setTransporte(transporte);
		setVision(vision);
		setCosto(costo);
		setTiempoConstruccion(tiempoConstruccion);
		setDaño(daño);
		setSuministro(suministro);
		setRangoAtaque(rangoAtaque);
		setVida(unidadMarineVida);
		
	}

	public int getTransporte() {
		return transporte;
	}
	public void setTransporte(int transporte) {
		this.transporte = transporte;
	}
	public int getVision() {
		return vision;
	}
	public void setVision(int vision) {
		this.vision = vision;
	}

	public int getTiempoConstruccion() {
		return tiempoConstruccion;
	}

	public void setTiempoConstruccion(int tiempoConstruccion) {
		this.tiempoConstruccion = tiempoConstruccion;
	}

	public String getDaño() {
		return daño;
	}

	public void setDaño(String daño) {
		this.daño = daño;
	}

	public int getSuministro() {
		return suministro;
	}

	public void setSuministro(int suministro) {
		this.suministro = suministro;
	}

	public String getRangoAtaque() {
		return rangoAtaque;
	}

	public void setRangoAtaque(String rangoAtaque) {
		this.rangoAtaque = rangoAtaque;
	}
 
	@Override
	public void realizarAccion(ContextoStrategy contexto, List<ElementoArtificial> unidadesEnemigas) 
	throws FactoryInvalidaException, UnidadInvalidaException, FueraDeRangoException {
		contexto.ejecutarStrategy(this.getPosicion(),this.getRangoAtaque(),this.getDaño(), unidadesEnemigas);
	}


}
