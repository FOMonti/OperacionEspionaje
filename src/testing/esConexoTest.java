package testing;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entidades.Conexo;
import entidades.Grafo;

public class esConexoTest {
	Grafo<String, Double> grafo;

	public void inicializarGrafo1() {
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
		grafo.agregarArista("A", "B", 4d);
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

	@Before
	public void before() {
		inicializarGrafo1();
	}

	@Test
	public void esConexoTrue() {
		Conexo<String, Double> conexo = new Conexo<String, Double>();
		assertTrue(conexo.esConexo(grafo));
	}
}
