package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entidades.Grafo;
import entidades.Prim;

public class PrimTest {

	Grafo<String, Double> grafo;
	Prim<String> prim;

	@Before
	public void inicializar() {
		prim = new Prim<String>();
		grafo = new Grafo<String, Double>();
		grafo.agregarVertice("A");
		grafo.agregarVertice("B");
		grafo.agregarVertice("C");
		grafo.agregarVertice("D");
		grafo.agregarVertice("E");
		grafo.agregarVertice("F");
		grafo.agregarVertice("G");
		grafo.agregarVertice("I");
		grafo.agregarVertice("H");
		grafo.agregarArista("A", "B", 4D);
		grafo.agregarArista("A", "H", 8d);
		grafo.agregarArista("B", "C", 8d);
		grafo.agregarArista("B", "H", 12d);
		grafo.agregarArista("C", "D", 6d);
		grafo.agregarArista("C", "I", 3d);
		grafo.agregarArista("C", "F", 4d);
		grafo.agregarArista("D", "F", 13d);
		grafo.agregarArista("D", "E", 9d);
		grafo.agregarArista("I", "G", 5d);
		grafo.agregarArista("I", "H", 6d);
		grafo.agregarArista("G", "H", 1d);
		grafo.agregarArista("G", "F", 3d);
		grafo.agregarArista("F", "E", 10d);
	}

	@Test
	public void testNoExiste() {

		Grafo<String, Double> arbol = prim.arbolGeneradorMinimo(grafo);
		assertFalse(arbol.existeArista("E", "F"));
		assertFalse(arbol.existeArista("D", "F"));
		assertFalse(arbol.existeArista("I", "G"));
		assertFalse(arbol.existeArista("I", "H"));
		assertFalse(arbol.existeArista("B", "H"));
		assertFalse(arbol.existeArista("E", "F"));

	}

	@Test
	public void testExiste() {

		Grafo<String, Double> arbol = prim.arbolGeneradorMinimo(grafo);
		assertTrue(arbol.existeArista("A", "B"));
		assertTrue(arbol.existeArista("B", "C"));
		assertTrue(arbol.existeArista("C", "I"));
		assertTrue(arbol.existeArista("C", "F"));
		assertTrue(arbol.existeArista("F", "G"));
		assertTrue(arbol.existeArista("D", "C"));
		assertTrue(arbol.existeArista("G", "H"));
		assertTrue(arbol.existeArista("C", "D"));
		assertTrue(arbol.existeArista("D", "E"));
	}

}
