package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import entidades.RedEspias;
import excepciones.ComunicacionExcepcion;
import excepciones.EspiaExcepcion;

public class RedEspiasTest {
	
	RedEspias red;

	@Before
	public void inicializar() {
		red = new RedEspias();
	}
 
	@Test
	public void agregarEspiaTest() throws EspiaExcepcion {
		red.agregarEspia("Ricardo");
		assertTrue(red.existeVertice("RICARDO"));
	}
	
	@Test (expected = EspiaExcepcion.class)
	public void agregarEspiaExistenteTest() throws EspiaExcepcion {
		red.agregarEspia("Ricardo");
		red.agregarEspia("Ricardo");
	}
	
	@Test
	public void agregarComunicacionTest() throws ComunicacionExcepcion, EspiaExcepcion {
		red.agregarEspia("Ricardo");
		red.agregarEspia("Eugenio");
		red.agregarComunicacion("Ricardo", "Eugenio", 2d);
		assertTrue(red.existeComunicacion("Ricardo", "Eugenio"));
	}
	
	@Test (expected = ComunicacionExcepcion.class)
	public void agregarComunicacionLoopTest() throws EspiaExcepcion, ComunicacionExcepcion {
		red.agregarEspia("Ricardo");
		red.agregarComunicacion("Ricardo", "Ricardo", 3d);
	}
	
	@Test (expected = ComunicacionExcepcion.class)
	public void agregarComunicacionInexistenteTest() throws ComunicacionExcepcion {
		red.agregarComunicacion("Ricardo", "Eugenio", 7d);
	}
	
	@Test (expected = ComunicacionExcepcion.class)
	public void noExisteComunicacionTest() throws ComunicacionExcepcion {
		red.existeComunicacion("Ricardo", "Eugenio");
	}
	
	@Test (expected = ComunicacionExcepcion.class)
	public void existeComunicacionLoopTest() throws EspiaExcepcion, ComunicacionExcepcion {
		red.agregarEspia("Ricardo");
		red.existeComunicacion("Ricardo", "Ricardo");
	}
	
	@Test
	public void riesgoTest() throws EspiaExcepcion, ComunicacionExcepcion {
		red.agregarEspia("Ricardo");
		red.agregarEspia("Eugenio");
		red.agregarComunicacion("Ricardo", "Eugenio", 8d);
		assertTrue(8d == red.riesgo("RICARDO", "EUGENIO"));
		
	}
	

}
