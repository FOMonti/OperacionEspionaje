package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import comparadores.Comparadores;

public class Kruskal<X> {

	private Grafo<X, Double> arbolGeneradorMinimo;
	private HashMap<X, X> componentesConexas;
	private Conexo<X, Double> conexo;
	private List<Arista<X, Double>> aristas;
	private List<Arista<X, Double>> aristasMarcadas;
	private int indice;

	private Double pesoDeAristaAgregar;
	private X verticeAgregar;
	private X verticeReferencia;
	private long tiempo;

	public Kruskal() {
		this.arbolGeneradorMinimo = new Grafo<X, Double>();
		this.componentesConexas = new HashMap<X, X>();
		this.conexo = new Conexo<X, Double>();
		this.aristasMarcadas = new ArrayList<Arista<X, Double>>();
	}

	public Grafo<X, Double> arbolGeneradorMinimo(Grafo<X, Double> grafo) {
		long inicio = System.nanoTime();
		if (grafo.vertices().size() == 0)
			return grafo;
		if (grafo.vertices().size() == 1)
			return grafo;
		inicializarAristas(grafo);
		excepcionNoEsConexo(grafo);
		arbolGeneradorMinimo = new Grafo<X, Double>();
		inicializarComponentesConexas(grafo.vertices());
		armarArbol(grafo);
		long fin = System.nanoTime();
		tiempo = fin - inicio;
		return arbolGeneradorMinimo;
	}

	private void armarArbol(Grafo<X, Double> grafo) {
		for (int i = 0; i < grafo.tamanio() - 1; i++) {
			aristaDeMenorPeso(grafo);
			asignarVertices();
			if (!arbolGeneradorMinimo.existeVertice(verticeReferencia))
				arbolGeneradorMinimo.agregarVertice(verticeReferencia);
			if (!arbolGeneradorMinimo.existeVertice(verticeAgregar))
				arbolGeneradorMinimo.agregarVertice(verticeAgregar);
			arbolGeneradorMinimo.agregarArista(verticeReferencia, verticeAgregar, pesoDeAristaAgregar);
			aristasMarcadas.add(aristas.get(indice));
			intercambiarComponentesConexas(grafo.vertices(), verticeReferencia, verticeAgregar);
		}
	}

	private void asignarVertices() {
		Arista<X, Double> a = aristas.get(indice);
		verticeReferencia = a.getVertice1();
		verticeAgregar = a.getVertice2();
		pesoDeAristaAgregar = a.getPeso();
	}

	private void aristaDeMenorPeso(Grafo<X, Double> grafo) {
		int i = 0;
		for (Arista<X, Double> a : aristas) {
			if (!aristasMarcadas.contains(a) && !mismaComponenteConexa(a.getVertice1(), a.getVertice2())) {
				this.indice = i;
				return;
			}
			i++;
		}
	}

	private boolean mismaComponenteConexa(X vertice1, X vertice2) {
		return componenteConexa(vertice1) == componenteConexa(vertice2);
	}

	private X componenteConexa(X vertice) {
		if (componentesConexas.get(vertice) == vertice) // Caso Base
			return vertice;
		else
			return componenteConexa(componentesConexas.get(vertice));// Recursion
	}

	private void inicializarComponentesConexas(Set<X> vertices) {
		for (X vertice : vertices)
			componentesConexas.put(vertice, vertice);
	}

	private void intercambiarComponentesConexas(Set<X> vertices, X vertice1, X vertice2) {
		if (cantComponenteConexa(vertices, vertice1) >= cantComponenteConexa(vertices, vertice2))
			intercambiar(vertices, vertice1, vertice2);
		else
			intercambiar(vertices, vertice2, vertice1);
	}

	private int cantComponenteConexa(Set<X> vertices, X vertice) {
		int cont = 0;
		for (X ver : vertices)
			if (mismaComponenteConexa(ver, vertice))
				cont++;
		return cont;
	}

	private void intercambiar(Set<X> vertices, X verticeMayorComponente, X verticeMenorComponente) {
		for (X vetice : vertices)
			if (componentesConexas.get(vetice).equals(verticeMenorComponente))
				componentesConexas.replace(vetice, verticeMayorComponente);
	}

	private void excepcionNoEsConexo(Grafo<X, Double> grafo) {
		if (!conexo.esConexo(grafo))
			throw new IllegalArgumentException("El grafo no es conexo, no existe camino posible!");
	}

	private void inicializarAristas(Grafo<X, Double> grafo) {
		this.aristas = grafo.aristas();
		Comparadores<X> comparadores = new Comparadores<X>();
		aristas.sort(comparadores.ordenarPorPeso);
	}

	public long getTiempo() {
		return tiempo;
	}
}
