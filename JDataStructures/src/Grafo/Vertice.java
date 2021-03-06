package Grafo;

public class Vertice implements Visitavel, Comparable{
	private String id;
	private Boolean foiVisitado;
	
	
	private Vertice(){
		this.foiVisitado = false;
	}
	Vertice(String id){
		this();
		this.id = id;
	}

	public String getID() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Vertice "+id;
	}

	@Override
	public void visita() {
		this.setVisitado(true);
	}

	@Override
	public boolean foiVisitado() {
		return this.foiVisitado;
	}

	@Override
	public void setVisitado(Boolean foiVisitado) {
		this.foiVisitado = foiVisitado;
	}
	public boolean compareTo(Vertice v1) {
		return (this.equals(v1));
	}
	
	@Override
	public int compareTo(Object otherVertex) {
		if(this.getID().equals(((Vertice) otherVertex).getID()))
			return 0;
		return -1;
	}
	
}
