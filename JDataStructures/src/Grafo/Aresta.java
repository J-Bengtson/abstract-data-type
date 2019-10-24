package Grafo;

public class Aresta extends Objeto{
	
	private Vertice v1 , v2; 
	
	Aresta(Vertice v1 , Vertice v2){
		super();
		this.v1 = v1;
		this.v2 = v2;
	}


	
	public Vertice getV1() {
		return this.v1;
	}
	
	public Vertice getV2() {
		return this.v2;
	}
	
	@Override
	public String toString() {
		return "[Aresta "+this.getV1()+"------"+this.getV2()+"]";
	}
	
}
