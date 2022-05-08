package entidades;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Conexo<X, Y> {

	private List<X> L;
	private Map<X, Boolean> marcados;

	public static void main(String[] args) {

	}

	public boolean esConexo(Grafo<X, Y> g) {
		if (g == null)
			throw new IllegalArgumentException("El grafo no puede ser nulo!");
		if (g.tamanio() == 0)
			return true;
		return alcanzables(g, (g.vertices().iterator().next())).size() == g.tamanio();
	}

	public Set<X> alcanzables(Grafo<X, Y> g, X verticeOrigen) {
		Set<X> ret = new HashSet<X>();

		// Inicializar las estructuras para la busqueda
		inicializarBusqueda(g, verticeOrigen);

		while (L.size() > 0) {
			X i = seleccionarYMarcarVertice(ret);
			agregarVecinosNoMarcados(g, i);
			removerSeleccionado();
		}
		return ret;
	}

	private void inicializarBusqueda(Grafo<X, Y> g, X origen) {
		L = new LinkedList<X>();
		L.add(origen);
		inicializarMap(g.vertices());
	}

	private void inicializarMap(Set<X> vertices) {
		marcados = new HashMap<X, Boolean>();
		for (X vertice : vertices) {
			marcados.put(vertice, false);
		}
	}

	private X seleccionarYMarcarVertice(Set<X> ret) {
		X vertice = L.get(0);
		marcados.replace(vertice, true);
		ret.add(vertice);
		return vertice;
	}

	private void agregarVecinosNoMarcados(Grafo<X, Y> g, X i) {
		for (X vecino : g.vecinos(i)) {
			if (!marcados.get(vecino) && !L.contains(vecino))
				L.add(vecino);
		}
	}

	private void removerSeleccionado() {
		L.remove(0);
	}

}
