package entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import comparadores.Comparadores;

public class Kruskal2<X> {

	private Grafo<X, Double> arbolGeneradorMinimo;
	private HashMap<X, X> componentesConexas;
	private Conexo<X, Double> conexo;
	private List<Arista> aristas;
	private int indice;

	private Double pesoDeAristaAgregar;
	private X verticeAgregar;
	private X verticeReferencia;
	private long tiempo;

	public Kruskal2() {
		this.arbolGeneradorMinimo = new Grafo<X, Double>();
		this.componentesConexas = new HashMap<X, X>();
		this.conexo = new Conexo<X, Double>();
	}

	public Grafo<X, Double> arbolGeneradorMinimo(Grafo<X, Double> grafo) {
		inicializarAristas(grafo);
		long inicio = System.nanoTime();
		if (grafo.vertices().size() == 1)
			return grafo;
		excepcionNoEsConexo(grafo);
		arbolGeneradorMinimo = new Grafo<X, Double>();
		inicializarComponentesConexas(grafo.vertices());
		armarArbol(grafo);
		long fin = System.nanoTime();
		tiempo = fin - inicio;
		System.out.println(aristas.size());
//		for (X vertice : arbolGeneradorMinimo.vertices()) {
//			for (X vecinoX : arbolGeneradorMinimo.vecinos(vertice)) {
//				System.out.println(vertice + "|" + vecinoX);
//			}
//		}
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
			intercambiarComponentesConexas(grafo.vertices(), verticeReferencia, verticeAgregar);
			eliminarAristas();
		}
	}

	private void eliminarAristas() {
		for (int j = 0; j < indice; j++) {
			aristas.remove(j);
		}
	}

	private void asignarVertices() {
		Arista<X> a = aristas.get(indice);
		verticeReferencia = a.getVertice1();
		verticeAgregar = a.getVertice2();
		pesoDeAristaAgregar = a.getPeso();
	}

	private void aristaDeMenorPeso(Grafo<X, Double> grafo) {
		int i = 0;
		for (Arista<X> a : aristas) {
			if (!mismaComponenteConexa(a.getVertice1(), a.getVertice2())) {
				this.indice = i;
				break;
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
		this.aristas = new ArrayList<Arista>();
		for (X vertice : grafo.vertices()) {
			for (X vecino : grafo.vecinos(vertice)) {
				Arista<X> arista1 = new Arista<X>(vertice, vecino, grafo.peso(vertice, vecino));
				Arista<X> arista2 = new Arista<X>(vecino, vertice, grafo.peso(vertice, vecino));
				if (!aristas.contains(arista1) && !aristas.contains(arista2)) {
					aristas.add(arista1);
				}
			}
		}
		aristas.sort(Comparadores.ordenarPorPeso);
//		for (Arista<X> a : aristas) {
//			System.out.println(a.getVertice1() + "|" + a.getVertice2());
//		}
	}

	public long getTiempo() {
		return tiempo;
	}
}
