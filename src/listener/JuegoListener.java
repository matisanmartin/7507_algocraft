package listener;

import java.io.IOException;

import recursos.Cristal;
import model.Elemento;
import model.ElementoArtificial;
import exceptions.FueraDeRangoException;
import exceptions.PosicionInvalidaException;

public interface JuegoListener {
	
	//Metodo de prueba para ver si la comunicación vista-modelo funciona
	public String pruebaListener();
	
	//Métodos de creacion de unidades terran
	public void seCreoMarine(ElementoArtificial elemento) throws IOException, FueraDeRangoException, PosicionInvalidaException;
	public void seCreoGolliat(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoEspectro(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoNaveCiencia(ElementoArtificial elemento) throws IOException, FueraDeRangoException, PosicionInvalidaException;
	public void seCreoNaveTransporteTerran(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	//Metodos de creacion de unidades protoss
	public void seCreoZealot(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoDragon(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoScout(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoAltoTemplario(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoNaveTransporteProtoss(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	//Metodos de creacion de edificios terran
	public void seCreoCentroMineral(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoBarraca(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoDepositoDeSuministro(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoRefineria(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoFabrica(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoPuertoEstelarTerran(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoCentroDeComandoTerran(ElementoArtificial elemento ) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	//Metodos de creacion de edificios protoss
	public void seCreoNexoMineral(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoPilon(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoAsimilador(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoAcceso(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoPuertoEstelarProtoss(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	public void seCreoArchivosTemplarios(ElementoArtificial elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	//Metodos de creacion de cristal y volcan
	public void seCreoVolcan(Elemento elemento) throws FueraDeRangoException, PosicionInvalidaException, IOException;
	
	
	//Metodos relacionados con acciones de unidades
	public void seMovioUnidad(ElementoArtificial elemento);
	public void seRealizoAtaque(ElementoArtificial elemento);
	public void seRealizoEmp(ElementoArtificial elemento);
	public void seRealizoRadiacion(ElementoArtificial elemento);
	public void seRealizoTormentaPsionica(ElementoArtificial elemento);
	public void seRealizoAlucinacion(ElementoArtificial elemento);
	
	//Metodos relacionados con la vida de una unidad
	public void seMurioUnaUnidad();
	
	//Metodos relacionados con el juego
	public void comenzoJuego();
	public void terminojuego();

	public void seCreoCopiaFicticia(ElementoArtificial elemento);

	public void seCreoCristal(Cristal cristal) throws IOException, FueraDeRangoException, PosicionInvalidaException;

	
	
	
	

}
