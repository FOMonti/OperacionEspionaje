package comparadores;

import java.util.Comparator;

import entidades.Arista;

public class Comparadores<X> {

	public Comparator<Arista<X, Double>> ordenarPorPeso = new Comparator<Arista<X, Double>>() {

		@Override
		public int compare(Arista<X, Double> o1, Arista<X, Double> o2) {
			return o1.getPeso().compareTo(o2.getPeso());
		}
	};

}