package entidades;

import java.util.HashMap;
import java.util.Set;

public class Grafo<X, Y> {

	private HashMap<X, HashMap<X, Y>> vertices;

	public Grafo() {
		this.vertices = new HashMap<X, HashMap<X, Y>>();
		// vertice1 -- ({vertice2,50} , {vertice3; 70})
	}

	public void agregarVertice(X vertice) {
		if (!vertices.containsKey(vertice)) {
			vertices.put(vertice, new HashMap<X, Y>());
		}
		// lanzamos expcecion si ya agregó al espia?
	}

	public void agregarArista(X vertice1, X vertice2, Y peso) {
		if (!vertices.containsKey(vertice1)) {
			// lanzamos excepcion? No existe el espia
		}
		if (!vertices.containsKey(vertice2)) {
			// lanzamos excepcion? No existe el espia Receptor
		}
		vertices.get(vertice1).put(vertice2, peso);
		vertices.get(vertice2).put(vertice1, peso);

	}

	public boolean existeArista(X vertice1, X vertice2) {
		if (vertices.get(vertice1).get(vertice2) != null) {
			return true;
		}
		return false;
	}

	public boolean existeVertice(X vertice) {
		return vertices.get(vertice) != null;
	}

	public Set<X> vertices() {
		return vertices.keySet();
	}

	public Set<X> vecinos(X vertice) {
		return vertices.get(vertice).keySet();
	}

	public Y peso(X vertice1, X vertice2) {
		return vertices.get(vertice1).get(vertice2);
	}

	public int tamanio() {
		return vertices().size();
	}

}
