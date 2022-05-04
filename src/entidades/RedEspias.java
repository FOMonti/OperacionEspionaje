package entidades;

import java.util.Set;

import excepciones.ComunicacionExcepcion;
import excepciones.EspiaExcepcion;

public class RedEspias extends Grafo<String, Double> {

	public void agregarEspia(String espia) throws EspiaExcepcion {
		try {
			agregarVertice(espia.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new EspiaExcepcion("Ya existe: " + espia + " en la red de espias");
		}
	}

	public void agregarComunicacion(String espiaEmisor, String espiaReceptor, Double riesgo)
			throws ComunicacionExcepcion {
		try {
			agregarArista(espiaEmisor.toUpperCase(), espiaReceptor.toUpperCase(), riesgo);
		} catch (IllegalArgumentException e) {
			throw new ComunicacionExcepcion(
					"El o los espias no existe/n || Estas intentando comunicar a un espia consigo mismo --> "
							+ "no existe la comunicacion : (" + espiaEmisor + ";" + espiaReceptor + ")");
		}
	}

	public boolean existeComunicacion(String espiaEmisor, String espiaReceptor) throws ComunicacionExcepcion {
		boolean ret = false;
		try {
			ret = existeArista(espiaEmisor.toUpperCase(), espiaReceptor.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new ComunicacionExcepcion(
					"El o los espias no existe/n || Estas verificando una comunicacion entre espia y consigo mismo --> "
							+ "no existe la comunicacion : (" + espiaEmisor + ";" + espiaReceptor + ")");
		}
		return ret;
	}

	public Double riesgo(String espiaEmisor, String espiaReceptor) throws ComunicacionExcepcion {
		Double ret = 0d;
		try {
			ret = peso(espiaEmisor, espiaReceptor);
		} catch (IllegalArgumentException e) {
			throw new ComunicacionExcepcion(
					"El o los espias no existe/n || Estas verificando el riesgo entre espia y consigo mismo || "
							+ "No existe la comunicacion : (" + espiaEmisor + ";" + espiaReceptor + ")");
		}
		return ret;
	}

	public Set<String> espias() {
		return vertices();
	}

	public Set<String> contactos(String espia) throws EspiaExcepcion {
		Set<String> contactos = null;
		try {
			contactos = vecinos(espia.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new EspiaExcepcion("No existe: " + espia + " en la red de espias");
		}
		return contactos;
	}
}
