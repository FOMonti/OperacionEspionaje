package servicio;

import java.util.Set;

import entidades.RedEspias;
import excepciones.ComunicacionExcepcion;
import excepciones.EspiaExcepcion;

public class RedEspiasService {

	private RedEspias redEspias;

	public RedEspiasService() {
		this.redEspias = new RedEspias();
	}

	public void agregarEspia(String espia) throws EspiaExcepcion {
		redEspias.agregarEspia(espia);
	}

	public void agregarComunicacion(String espiaEmisor, String espiaReceptor, Double riesgo)
			throws ComunicacionExcepcion {
		redEspias.agregarComunicacion(espiaEmisor, espiaEmisor, riesgo);
	}

	public boolean existeComunicacion(String espiaEmisor, String espiaReceptor) throws ComunicacionExcepcion {
		return redEspias.existeComunicacion(espiaEmisor, espiaReceptor);
	}

	public Set<String> espias() {
		return redEspias.espias();
	}

	public Set<String> contactos(String espia) throws EspiaExcepcion {
		return redEspias.contactos(espia);
	}

	public Double riesgo(String espiaEmisor, String espiaReceptor) throws ComunicacionExcepcion {
		return redEspias.riesgo(espiaEmisor, espiaReceptor);
	}
}
