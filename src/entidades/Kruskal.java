package entidades;

import java.util.HashMap;
import java.util.Set;

public class Kruskal<X> {

	private Grafo<X, Double> arbolGeneradorMinimo;
	private HashMap<X, X> componentesConexas;

	private Double pesoDeAristaAgregar;
	private X verticeAgregar;
	private X verticeReferencia;

	public Kruskal() {
		this.arbolGeneradorMinimo = new Grafo<X, Double>();
		this.componentesConexas = new HashMap<X, X>();
	}

	public Grafo<X, Double> arbolGeneradorMinimo(Grafo<X, Double> grafo) {
		arbolGeneradorMinimo = new Grafo<X, Double>();
		inicializarComponentesConexas(grafo.vertices());
		armarArbol(grafo);
		return arbolGeneradorMinimo;
	}

	private void armarArbol(Grafo<X, Double> grafo) {
		for (int i = 0; i < grafo.tamanio(); i++) {
			aristaDeMenorPeso(grafo);
			if (!arbolGeneradorMinimo.existeVertice(verticeReferencia))
				arbolGeneradorMinimo.agregarVertice(verticeReferencia);
			if (!arbolGeneradorMinimo.existeVertice(verticeAgregar))
				arbolGeneradorMinimo.agregarVertice(verticeAgregar);
			arbolGeneradorMinimo.agregarArista(verticeReferencia, verticeAgregar, pesoDeAristaAgregar);
			intercambiarComponentesConexas(grafo.vertices(), verticeReferencia, verticeAgregar);
		}
	}

	private void aristaDeMenorPeso(Grafo<X, Double> grafo) {
		pesoDeAristaAgregar = Double.MAX_VALUE;
		for (X vertice : grafo.vertices())
			recorrerVecinosDelArbol(grafo, vertice);
	}

	private void intercambiarComponentesConexas(Set<X> vertices, X vertice1, X vertice2) {
		if (cantComponenteConexa(vertices, vertice1) >= cantComponenteConexa(vertices, vertice2))
			intercambiar(vertices, vertice1, vertice2);
		else
			intercambiar(vertices, vertice2, vertice1);
	}

	private void intercambiar(Set<X> vertices, X verticeMayorComponente, X verticeMenorComponente) {
		for (X vetice : vertices)
			if (componentesConexas.get(vetice).equals(verticeMenorComponente))
				componentesConexas.replace(vetice, verticeMayorComponente);
	}

	private int cantComponenteConexa(Set<X> vertices, X vertice) {
		int cont = 0;
		for (X ver : vertices)
			if (mismaComponenteConexa(ver, vertice))
				cont++;
		return cont;
	}

	private void recorrerVecinosDelArbol(Grafo<X, Double> grafo, X vertice) {
		for (X vecino : grafo.vecinos(vertice))
			if (pesoDeAristaAgregar > grafo.peso(vertice, vecino) && (!mismaComponenteConexa(vertice, vecino))) {
				pesoDeAristaAgregar = grafo.peso(vertice, vecino);
				verticeAgregar = vecino;
				verticeReferencia = vertice;
			}
	}

	private boolean mismaComponenteConexa(X vertice1, X vertice2) {
		return componenteConexa(vertice1) == componenteConexa(vertice2);
	}

	private X componenteConexa(X vertice) {
		if (componentesConexas.get(vertice) == vertice) // Caso Base
			return vertice;
		else
			return componenteConexa(componentesConexas.get(vertice));// Recursión
	}

	private void inicializarComponentesConexas(Set<X> vertices) {
		for (X vertice : vertices)
			componentesConexas.put(vertice, vertice);
	}
}