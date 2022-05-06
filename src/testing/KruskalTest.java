package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entidades.Grafo;
import entidades.Kruskal;

public class KruskalTest {

	Grafo<String, Double> grafo1;
	Grafo<String, Double> grafo2;
	Kruskal<String> kruskal;
	
	public void inicializarGrafo1() {
		grafo1 = new Grafo<String, Double>();
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
	}
	
	public void inicializarGrafo2() {
		grafo2 = new Grafo<String, Double>();
		grafo2.agregarVertice("A");
		grafo2.agregarVertice("B");
		grafo2.agregarVertice("C");
		grafo2.agregarArista("A", "B", 1d);
		grafo2.agregarArista("B", "C", 1d);
		grafo2.agregarArista("C", "A", 4d);
	}


	@Before
	public void inicializar() {
		kruskal = new Kruskal<String>();
		inicializarGrafo1();
		inicializarGrafo2();
	}

	@Test
	public void testNoExiste() {
		Grafo<String, Double> arbol = kruskal.arbolGeneradorMinimo(grafo1);
		assertFalse(arbol.existeArista("E", "F"));
		assertFalse(arbol.existeArista("D", "F"));
		assertFalse(arbol.existeArista("I", "G"));
		assertFalse(arbol.existeArista("I", "H"));
		assertFalse(arbol.existeArista("B", "H"));
		assertFalse(arbol.existeArista("E", "F"));
	}

	@Test
	public void testExiste() {
		Grafo<String, Double> arbol = kruskal.arbolGeneradorMinimo(grafo1);
		assertTrue(arbol.existeArista("A", "B"));
		// Notar que la siguiente arista no esta en Prim, y es remplazada por BC
		assertTrue(arbol.existeArista("A", "H"));
		assertTrue(arbol.existeArista("C", "I"));
		assertTrue(arbol.existeArista("C", "F"));
		assertTrue(arbol.existeArista("F", "G"));
		assertTrue(arbol.existeArista("D", "C"));
		assertTrue(arbol.existeArista("G", "H"));
		assertTrue(arbol.existeArista("C", "D"));
		assertTrue(arbol.existeArista("D", "E"));
	}
	
	//deberia tirar excepcion
	@Test(expected = IllegalArgumentException.class)
	public void testNoEsConexo() {
		grafo2.agregarVertice("D");
		grafo2.agregarVertice("E");
		grafo2.agregarArista("D", "E", 2d);
		
		@SuppressWarnings("unused")
		Grafo<String, Double> arbol = kruskal.arbolGeneradorMinimo(grafo2);
	}
	
}
