package entidades;

/*
 * X es un valor generico de un vertice, la implementacion de este algoritmo
 * no depende de tipo para el vertice, pero si para el peso de las aritas
 */
public class Prim<X> {
	private Grafo<X, Double> arbolGeneradorMinimo;

	private Double pesoDeAristaAgregar;
	private X verticeAgregar;
	private X verticeReferencia;

	public Prim() {
		this.arbolGeneradorMinimo = new Grafo<X, Double>();
	}

	public Grafo<X, Double> arbolGeneradorMinimo(Grafo<X, Double> grafo) {
		X vertice = grafo.vertices().iterator().next();
		arbolGeneradorMinimo = new Grafo<X, Double>();
		armarArbol(grafo, vertice);
		return arbolGeneradorMinimo;
	}

	private void armarArbol(Grafo<X, Double> grafo, X vertice) {
		arbolGeneradorMinimo.agregarVertice(vertice);
		while (!estenTodosMarcados(grafo)) {
			aristaDeMenorPeso(grafo);
			arbolGeneradorMinimo.agregarVertice(verticeAgregar);
			arbolGeneradorMinimo.agregarArista(verticeReferencia, verticeAgregar, pesoDeAristaAgregar);
		}
	}

	private void aristaDeMenorPeso(Grafo<X, Double> grafo) {
		pesoDeAristaAgregar = Double.MAX_VALUE;
		for (X vertice : arbolGeneradorMinimo.vertices()) {
			recorrerVecinosDelArbol(grafo, vertice);
		}
	}

	private void recorrerVecinosDelArbol(Grafo<X, Double> grafo, X vertice) {
		for (X vecino : grafo.vecinos(vertice)) {
			if (pesoDeAristaAgregar >= grafo.peso(vertice, vecino)
					&& !(arbolGeneradorMinimo.vertices().contains(vecino))) {
				pesoDeAristaAgregar = grafo.peso(vertice, vecino);
				verticeAgregar = vecino;
				verticeReferencia = vertice;
			}
		}
	}

	public boolean estenTodosMarcados(Grafo<X, Double> grafo) {
		return grafo.tamanio() == arbolGeneradorMinimo.tamanio();
	}

}
