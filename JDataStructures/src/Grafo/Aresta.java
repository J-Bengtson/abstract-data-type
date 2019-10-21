package Grafo;

public class Aresta {
	
	private Vertice v1 , v2; 
	private Boolean isVisited;
	
	Aresta(Vertice v1 , Vertice v2 ){
		this.v1 = v1;
		this.v2 = v2;
		this.isVisited = false;
	}
	
	public Boolean isVisited() {
		return this.isVisited;
	}
	
	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public Vertice getV1() {
		return this.v1;
	}
	
	public Vertice getV2() {
		return this.v2;
	}
	
	@Override
	public String toString() {
		return "[Aresta "+this.getV1()+"--->"+this.getV2()+"]";
	}
	
}
