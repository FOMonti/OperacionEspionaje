package entidades;

public class Prim<X> {
	private Grafo<X, Double> arbolGeneradorMinimo;
	private Conexo<X, Double> conexo;

	private Double pesoDeAristaAgregar;
	private X verticeAgregar;
	private X verticeReferencia;
	private long tiempo;

	public Prim() {
		this.arbolGeneradorMinimo = new Grafo<X, Double>();
		this.conexo = new Conexo<X, Double>();
	}

	public Grafo<X, Double> arbolGeneradorMinimo(Grafo<X, Double> grafo) {
		long inicio = System.nanoTime();
		if(grafo.vertices().size() == 1) return grafo;
		if(grafo.vertices().size() == 0) return grafo;
		excepcionNoEsConexo(grafo);
		X vertice = grafo.vertices().iterator().next();
		arbolGeneradorMinimo = new Grafo<X, Double>();
		armarArbol(grafo, vertice);
		long fin = System.nanoTime();
		tiempo = fin - inicio;
		return arbolGeneradorMinimo;
	}

	private void excepcionNoEsConexo(Grafo<X, Double> grafo) {
		if(!conexo.esConexo(grafo)) throw new IllegalArgumentException("El grafo no es conexo, no existe camino posible!");
		
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
		for (X vertice : arbolGeneradorMinimo.vertices())
			recorrerVecinosDelArbol(grafo, vertice);
	}

	private void recorrerVecinosDelArbol(Grafo<X, Double> grafo, X vertice) {
		for (X vecino : grafo.vecinos(vertice))
			if (pesoDeAristaAgregar >= grafo.peso(vertice, vecino)
					&& !(arbolGeneradorMinimo.vertices().contains(vecino))) {
				pesoDeAristaAgregar = grafo.peso(vertice, vecino);
				verticeAgregar = vecino;
				verticeReferencia = vertice;
			}
	}

	public boolean estenTodosMarcados(Grafo<X, Double> grafo) {
		return grafo.tamanio() == arbolGeneradorMinimo.tamanio();
	}
	
	public long getTiempo() {
		return this.tiempo;
	}
}
