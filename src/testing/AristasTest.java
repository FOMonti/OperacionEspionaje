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
	
	@Before
	public void inicializar() {
		inicializarGrafo1();
		inicializarGrafo2();
	}
	
	@Test 
	public void existeVerticeTest() {
		grafo.agregarVertice(9);
		assertTrue(grafo.existeVertice(9));
	}
	
	@Test
	public void existeVerticeStringTest() {
		grafo2.agregarVertice("Pedro");
		assertTrue(grafo2.existeVertice("Pedro"));
	}
	
	@Test
	public void existeAristaNumTest() {
		grafo.agregarArista(2, 5, 3.5);
		assertTrue(grafo.existeArista(2, 5));
	}

	@Test
	public void existeAristaStringTest() {
		grafo2.agregarArista("Juan", "Pepito", 3.5);
		assertTrue(grafo2.existeArista("Juan", "Pepito"));
	}
	
	@Test
	public void vecinosTest() {
		grafo.agregarVertice(7);
		grafo.agregarArista(2, 5, 1d);
		grafo.agregarArista(2, 7, 1d);
		assertEquals(2, grafo.vecinos(2).size());
		assertEquals(1, grafo.vecinos(5).size());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void yaExisteVerticeTest() {
		grafo.agregarVertice(2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void aristaConVerticesInexistentesTest() {
		grafo2.agregarArista("Rodolfo", "Carmen", 1d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void loopAristaTest() {
		grafo.agregarArista(5, 5, 8d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void vecinosVerticeInexistenteTest() {
		grafo.vecinos(6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void pesoAristaInexistenteTest() {
		grafo.peso(20, 40);
	}
	


}
