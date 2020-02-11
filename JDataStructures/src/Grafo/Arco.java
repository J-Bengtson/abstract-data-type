package Grafo;

public class Arco extends Aresta{

	Arco(Vertice v1, Vertice v2) {
		super(v1, v2);
	}
	
	
	@Override
	public String toString() {
		return "[Arco "+this.getV1()+"---"+ this.getGrau() +"--->"+this.getV2()+"]";
	}

}
