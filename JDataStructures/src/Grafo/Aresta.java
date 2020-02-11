package Grafo;

public class Aresta implements Visitavel{
	
	private Vertice v1 , v2; 
	private Boolean foiVisitado;
	
	private Number grau;
	
	
	private Aresta(){
		this.foiVisitado = false;
		this.grau = 0;
	}
	
	Aresta(Vertice v1 , Vertice v2){
		this();
		this.v1 = v1;
		this.v2 = v2;
	}
	
	Aresta(Vertice v1 , Vertice v2 , Number grau){
		this(v1 , v2);
		this.grau = grau;
	}


	
	
	public Number getGrau() {
		return this.grau;
	}
	
	public Vertice getV1() {
		return this.v1;
	}
	
	public Vertice getV2() {
		return this.v2;
	}
	
	@Override
	public String toString() {
		return "[Aresta "+this.getV1()+"---"+(this.getGrau())  +"---"+this.getV2()+"]";
	}



	@Override
	public void visita() {
		setVisitado(true);
	}


	@Override
	public boolean foiVisitado() {
		return this.foiVisitado;
	}

	@Override
	public void setVisitado(Boolean foiVisitado) {
		this.foiVisitado = foiVisitado;
	}
	
}
