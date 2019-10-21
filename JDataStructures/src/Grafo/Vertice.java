package Grafo;

public class Vertice {
	private String id;
	private Boolean isVisited;
	
	Vertice(String id){
		this.id = id;
		this.isVisited = false;
	}
	
	
	public Boolean isVisited() {
		return this.isVisited;
	}
	
	public void setVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}
	
	public String getID() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Vertice "+id;
	}
}
