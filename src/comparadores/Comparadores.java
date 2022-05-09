package comparadores;

import java.util.Comparator;

import entidades.Arista;

public class Comparadores {

	public static Comparator<Arista> ordenarPorPeso = new Comparator<Arista>() {

		@Override
		public int compare(Arista o1, Arista o2) {

			return o1.getPeso().compareTo(o2.getPeso());
		}
	};
}
