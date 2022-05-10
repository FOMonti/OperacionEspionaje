package entidades;

import java.util.Set;

import excepciones.ComunicacionExcepcion;
import excepciones.EspiaExcepcion;
import entidades.Prim;
import entidades.Kruskal;

public class RedEspias extends Grafo<String, Double> {
	
	Prim<String> prim;
	Kruskal<String> kruskal;
	Kruskal2<String> kruskal2;
	Grafo<String, Double> arbol;

	public RedEspias() {
		super();
	}

	public void agregarEspia(String espia) throws EspiaExcepcion {
		try {
			agregarVertice(espia.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new EspiaExcepcion("Ya existe: " + espia + " en la red de espias");
		}
	}

	public void agregarComunicacion(String espiaEmisor, String espiaReceptor, Double riesgo)
		throws ComunicacionExcepcion {

			try {
				agregarArista(espiaEmisor.toUpperCase(), espiaReceptor.toUpperCase(), riesgo);
			} catch (IllegalArgumentException e) {
				throw new ComunicacionExcepcion("Estas comunicando un espia consigo mismo");
			}
		
		}

	public boolean existeComunicacion(String espiaEmisor, String espiaReceptor) throws ComunicacionExcepcion {
		boolean ret = false;
		try {
			ret = existeArista(espiaEmisor.toUpperCase(), espiaReceptor.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new ComunicacionExcepcion(
					"El o los espias no existe/n || Estas verificando una comunicacion entre un espia consigo mismo --> "
							+ "no existe la comunicacion : (" + espiaEmisor + ";" + espiaReceptor + ")");
		}
		return ret;
	}
	

	public Double riesgo(String espiaEmisor, String espiaReceptor) throws ComunicacionExcepcion {
		Double ret = 0d;
		try {
			ret = peso(espiaEmisor.toUpperCase(), espiaReceptor.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new ComunicacionExcepcion(
					"El o los espias no existe/n || Estas verificando el riesgo entre espia y consigo mismo || "
							+ "No existe la comunicacion : (" + espiaEmisor + ";" + espiaReceptor + ")");
		}
		return ret;
	}
	
	public Grafo<String, Double> prim() throws ComunicacionExcepcion {
		prim = new Prim<String>();
		arbol = new Grafo<String, Double>();
		try {
			arbol = prim.arbolGeneradorMinimo(this);
			return arbol;
		} catch (IllegalArgumentException e) {
			throw new ComunicacionExcepcion("No existe camino posible para el mensaje");
		}
	}
	
	public Grafo<String, Double> kruskal() throws ComunicacionExcepcion {
		kruskal2 = new Kruskal2<String>();
		arbol = new Grafo<String, Double>();
		try {
			arbol = kruskal2.arbolGeneradorMinimo(this);
			return arbol;
		} catch (IllegalArgumentException e) {
			throw new ComunicacionExcepcion("No existe camino posible para el mensaje");
		}
	}
	
	public long getTiempoPrim() {
		return prim.getTiempo();
	}
	
	public long getTiempoKruskal() {
		return kruskal2.getTiempo();
	}

	public Set<String> espias() {
		return vertices();
	}

	public Set<String> contactos(String espia) throws EspiaExcepcion {
		Set<String> contactos = null;
		try {
			contactos = vecinos(espia.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new EspiaExcepcion("No existe: " + espia + " en la red de espias");
		}
		return contactos;
	
	}
	
	
	
	// Function to convert Set<String> to String[]
    public String[] arrEspias()
    {
    	
        // Create String[] of size of setOfString
        String[] arrayOfString = new String[this.espias().size()];
  
        // Copy elements from set to string array
        // using advanced for loop
        int index = 0;
        for (String str : this.espias())
            arrayOfString[index++] = str;
  
        // return the formed String[]
        return arrayOfString;
    }
}
	
	
    
	

