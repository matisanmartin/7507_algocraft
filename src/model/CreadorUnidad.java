package model;

import factory.unidades.TipoUnidad;

public interface CreadorUnidad {
	
	Elemento crearUnidad(TipoUnidad unidadRequerida);

}
