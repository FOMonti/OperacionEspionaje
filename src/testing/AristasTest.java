package testing;

import static org.junit.Assert.*;

//import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
//
//import java.util.Set;
//
//import org.junit.Test;

import entidades.Grafo;

public class AristasTest {

	private Grafo<Integer, Double> grafo;
	private Grafo<String, Double> grafo2;
//	private Grafo<String, Double> grafo3;

	@Before
	public void inicializar() {
		inicializarGrafo1();
		inicializarGrafo2();
		inicializarGrafo1();

	}

	@Test
	public void existenteNumTest() {
		grafo.agregarArista(2, 5, 3.5);
		assertTrue(grafo.existeArista(2, 5));
	}

	@Test
	public void existenteStringTest() {
		grafo2.agregarArista("Juan", "Pepito", 3.5);
		assertTrue(grafo2.existeArista("Juan", "Pepito"));
	}

	private void inicializarGrafo1() {
		grafo = new Grafo<Integer, Double>();
		grafo.agregarVertice(2);
		grafo.agregarVertice(5);
	}

	private void inicializarGrafo2() {
		grafo2 = new Grafo<String, Double>();
		grafo2.agregarVertice("Pepito");
		grafo2.agregarVertice("Juan");
	}

}
