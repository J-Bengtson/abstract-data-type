package Grafo;

public abstract class Objeto {
	Objeto(){
		this.isVisited = false;
	}
	private Boolean isVisited;

	
	public Boolean isVisited() {
		return this.isVisited;
	}
	
	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}
}
