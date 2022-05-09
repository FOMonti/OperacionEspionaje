package entidades;

public class Main {

	public static void main(String[] args) {
		Grafo<String, Double> grafo1 = new Grafo<String, Double>();
		grafo1.agregarVertice("A");
		grafo1.agregarVertice("B");
		grafo1.agregarVertice("C");
		grafo1.agregarVertice("D");
		grafo1.agregarVertice("E");
		grafo1.agregarVertice("F");
		grafo1.agregarVertice("G");
		grafo1.agregarVertice("I");
		grafo1.agregarVertice("H");
		grafo1.agregarArista("A", "B", 4d);
		grafo1.agregarArista("A", "H", 8d);
		grafo1.agregarArista("B", "C", 8d);
		grafo1.agregarArista("B", "H", 12d);
		grafo1.agregarArista("C", "D", 6d);
		grafo1.agregarArista("C", "I", 3d);
		grafo1.agregarArista("C", "F", 4d);
		grafo1.agregarArista("D", "F", 13d);
		grafo1.agregarArista("D", "E", 9d);
		grafo1.agregarArista("I", "G", 5d);
		grafo1.agregarArista("I", "H", 6d);
		grafo1.agregarArista("G", "H", 1d);
		grafo1.agregarArista("G", "F", 3d);
		grafo1.agregarArista("F", "E", 10d);
		Kruskal<String> kruskal = new Kruskal<String>();
		Grafo<String, Double> arbol1 = kruskal.arbolGeneradorMinimo(grafo1);
		System.out.println(kruskal.getTiempo());
		Kruskal2<String> kruskal2 = new Kruskal2<String>();
		Grafo<String, Double> arbol2 = kruskal2.arbolGeneradorMinimo(grafo1);
		System.out.println(kruskal2.getTiempo() + "|" + arbol2.tamanio());
	}

}
