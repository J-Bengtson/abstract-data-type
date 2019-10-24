package Grafo;

public class Vertice extends Objeto{
	private String id;
	
	Vertice(String id){
		super();
		this.id = id;
	}

	public String getID() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Vertice "+id;
	}
}
