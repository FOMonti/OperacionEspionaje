package entidades;

import java.util.Set;

public class RedEspias extends Grafo<String, Double> {

	public void agregarEspia(String espia) {
		agregarVertice(espia.toUpperCase());
	}

	public void agregarComunicacion(String espiaEmisor, String espiaReceptor, Double riesgo) {
		agregarArista(espiaEmisor.toUpperCase(), espiaReceptor.toUpperCase(), riesgo);
	}

	public boolean existeComunicacion(String espiaEmisor, String espiaReceptor) {
		return existeArista(espiaEmisor.toUpperCase(), espiaReceptor.toUpperCase());
	}

	public Set<String> espias() {
		return vertices();
	}

	public Set<String> contactos(String espia) {
		return vecinos(espia.toUpperCase());
	}

}
