package strategy;

import model.ElementoArtificial;
import common.Posicion;
import exceptions.CostoInvalidoException;
import exceptions.DanioInvalidoException;
import exceptions.ElementoInvalidoException;
import exceptions.ElementoNoEncontradoException;
import exceptions.EnergiaInsuficienteException;
import exceptions.FactoryInvalidaException;
import exceptions.FinDePartidaException;
import exceptions.FueraDeRangoDeVisionException;
import exceptions.FueraDeRangoException;
import exceptions.PartidaGanadaException;
import exceptions.PartidaPerdidaException;
import exceptions.PoblacionFaltanteException;
import exceptions.PosicionInvalidaException;
import exceptions.RecursosFaltantesException;
import exceptions.RecursosInsuficientesException;
import exceptions.UnidadInvalidaException;
import exceptions.UnidadLlenaException;

public interface Strategy {
	
	void realizarAccion(ElementoArtificial elementoActuante, Posicion posicionDestino) 
	throws 	FactoryInvalidaException, 
			UnidadInvalidaException, 
			FueraDeRangoException, 
			ElementoInvalidoException, 
			PosicionInvalidaException, 
			ElementoNoEncontradoException, 
			FueraDeRangoDeVisionException, 
			EnergiaInsuficienteException, 
			CostoInvalidoException, 
			RecursosInsuficientesException, 
			CloneNotSupportedException, 
			FinDePartidaException, 
			PartidaGanadaException, 
			PartidaPerdidaException, 
			UnidadLlenaException, RecursosFaltantesException, PoblacionFaltanteException, DanioInvalidoException;

}
