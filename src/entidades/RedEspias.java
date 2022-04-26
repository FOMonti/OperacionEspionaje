package entidades;

import java.util.HashMap;

public class RedEspias extends Grafo<String, Double> {

	public void agregarEspia(String espia) {
		agregarVertice(espia);
	}

	public void agregarComunicacion(String espiaEmisor, String espiaReceptor, Double riesgo) {
		agregarArista(espiaEmisor, espiaReceptor, riesgo);
	}

	public boolean existeComunicacion(String espiaEmisor, String espiaReceptor) {
		return existeArista(espiaEmisor, espiaReceptor);
	}

	public HashMap<String, Double> contactos(String espia) {
		return vecinos(espia);
	}
}
