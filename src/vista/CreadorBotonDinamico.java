package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

import sonido.Reproductor;
import sonido.TipoSonido;
import command.Accion;
import common.Posicion;
import controller.ControladorMouse;
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

public class CreadorBotonDinamico implements ActionListener {
	
	private Accion accion;

	public CreadorBotonDinamico(Accion accion){
		this.accion = accion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			try {
				this.accion.execute(ControladorMouse.getPosicionDestino());
			} catch (FactoryInvalidaException | UnidadInvalidaException
					| FueraDeRangoException | ElementoInvalidoException
					| PosicionInvalidaException | ElementoNoEncontradoException
					| FueraDeRangoDeVisionException
					| EnergiaInsuficienteException | CostoInvalidoException
					| RecursosInsuficientesException
					| CloneNotSupportedException | FinDePartidaException
					| PartidaGanadaException | PartidaPerdidaException
					| UnidadLlenaException | RecursosFaltantesException
					| PoblacionFaltanteException | DanioInvalidoException
					| IOException e1) {

				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error",JOptionPane.INFORMATION_MESSAGE);	
				e1.printStackTrace();
			}
			VentanaPrincipal.agregarInformacionDeJugador();


	}

}
