package entidades;

public class Arista<X, Y> {

	private X vertice1;
	private X vertice2;
	private Y peso;

	public Arista(X vertice1, X vertice2, Y peso) {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.peso = peso;
	}

	public X getVertice1() {
		return vertice1;
	}

	public X getVertice2() {
		return vertice2;
	}

	public Y getPeso() {
		return peso;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {

		return equals((Arista<X, Y>) obj);
	}

	public boolean equals(Arista<X, Y> arista) {
		if (this.peso.equals(arista.peso)) {
			if (this.vertice1 == arista.vertice1 || this.vertice1 == arista.vertice2) {
				if (this.vertice2.equals(this.vertice1) || this.vertice2.equals(this.vertice2)) {
					return true;
				}
			}
		}
		return false;
	}

}
