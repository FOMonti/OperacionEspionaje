package entidades;

import java.util.HashMap;
import java.util.Set;

public class Grafo<X, Y> {

	private HashMap<X, HashMap<X, Y>> vertices;

	public Grafo() {
		this.vertices = new HashMap<X, HashMap<X, Y>>();
	}

	public void agregarVertice(X vertice) {
		if (vertices.containsKey(vertice))
			throw new IllegalArgumentException("Ya existe el vertice en el Grafo");
		vertices.put(vertice, new HashMap<X, Y>());
	}

	public void agregarArista(X vertice1, X vertice2, Y peso) {
		verificarArista(vertice1, vertice2);
		vertices.get(vertice1).put(vertice2, peso);
		vertices.get(vertice2).put(vertice1, peso);
	}

	public boolean existeArista(X vertice1, X vertice2) {
		verificarArista(vertice1, vertice2);
		return vertices.get(vertice1).get(vertice2) != null;
	}

	public boolean existeVertice(X vertice) {
		return vertices.get(vertice) != null;
	}

	public Y peso(X vertice1, X vertice2) {
		verificarArista(vertice1, vertice2);
		if (!existeArista(vertice1, vertice2))
			throw new IllegalArgumentException("No existe la arista: (" + vertice1 + ";" + vertice2 + ")");
		return vertices.get(vertice1).get(vertice2);
	}

	public Set<X> vertices() {
		return vertices.keySet();
	}

	public Set<X> vecinos(X vertice) {
		if (!vertices.containsKey(vertice))
			throw new IllegalArgumentException("No existe el veritce: " + vertice);
		return vertices.get(vertice).keySet();
	}

	public int tamanio() {
		return vertices().size();
	}

	private void verificarArista(X vertice1, X vertice2) {
		if (!vertices.containsKey(vertice1) || !vertices.containsKey(vertice2) || vertice1.equals(vertice2))
			throw new IllegalArgumentException(
					"El o los vertice no existe/n || son iguales: no se permiten loops--> no existe la arista : ("
							+ vertice1 + ";" + vertice2 + ")");
	}
}
