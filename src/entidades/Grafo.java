package entidades;

import java.util.HashMap;

public class Grafo<X, Y> {

	private HashMap<X, HashMap<X, Y>> vertices;

	public Grafo() {
		this.vertices = new HashMap<X, HashMap<X, Y>>();
		// vertice1 -- ({vertice2,50} , {vertice3; 70})
	}

	protected void agregarVertice(X vertice) {
		if (!vertices.containsKey(vertice)) {
			vertices.put(vertice, new HashMap<X, Y>());
		}
		// lanzamos expcecion si ya agregó al espia?
	}

	protected void agregarArista(X vertice1, X vertice2, Y peso) {
		if (!vertices.containsKey(vertice1)) {
			// lanzamos excepcion? No existe el espia
		}
		if (!vertices.containsKey(vertice2)) {
			// lanzamos excepcion? No existe el espia Receptor
		}
		vertices.get(vertice1).put(vertice2, peso);
		vertices.get(vertice2).put(vertice1, peso);

	}

	protected boolean existeArista(X vertice1, X vertice2) {
		if (vertices.get(vertice1).get(vertice2) != null) {
			return true;
		}
		return false;
	}

	protected HashMap<X, Y> vecinos(X vertice) {
		return vertices.get(vertice);
	}
}
