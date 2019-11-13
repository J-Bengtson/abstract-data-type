package Grafo;

import java.util.*;

public abstract class Grafo implements Cloneable {
	
	private List<Vertice> V = new LinkedList<Vertice>();
	private List<Aresta> A = new LinkedList<Aresta>();
	
	
	Grafo(){}
	Grafo(Grafo grafo){
		this.setArestas(grafo.getArestas());
		this.setVertices(grafo.getVertices());
	}

	
	private void setaVisitados(Boolean isVisited) {
		for(Vertice vertice : getVertices())
			vertice.setVisitado(false);
		
		for(Aresta aresta : getArestas())
			aresta.setVisitado(false);
	}
	
	public void limpaVisitados() {
		// seta todos as arestas e vertices previamente visitados com valor false
		// para realizar nova busca sem conflitos
		setaVisitados(false);
	}
	
	
	public boolean addArestas(List<Aresta> arestas) {
		for(Aresta aresta : arestas) {
			addAresta(aresta);
		}
		return true;
	}
	
	public boolean addAresta(Aresta a) { // adiciona aresta ao grafo (conjunto de arestas)
		
		List<Vertice> vertices = getVertices();
		if(!vertices.contains(a.getV1())) // se nao houver vertices adjacentes a arestas previamente no grafo, inseri-los
			addVertice(a.getV1());
		if(!vertices.contains(a.getV2()))
			addVertice(a.getV2());

		return getArestas().add(a);
	}
	
	public boolean removeAresta(Aresta a) {
		if(!getArestas().contains(a))
			return false;
		return getArestas().remove(a);  
	}
	
	public void removeArestas(List<Aresta> arestas) {
		for(Aresta aresta : arestas) {
			removeAresta(aresta);
		}
	}
	
	protected void resetArestas() {
		this.A = new LinkedList<Aresta>();
	}
	protected void resetVertices() {
		this.V = new LinkedList<Vertice>();
	}
	
	public void reset() {
		resetArestas();
		resetVertices();
	}
	
	public abstract List<Aresta> getArestaAdjacente(Vertice v1 , Vertice v2); 
	// funcao retorna lista de arestas adjancentes entre ambos vertices v1 e v2
	
	public abstract List<Vertice> getVerticesAdjacentes(Vertice v); 
	// fun�ao retorna lista de vertices adjancentes de v

	
	protected boolean isEquals(Vertice v1 , Vertice v2) {
		return v1.equals(v2);
	}
	
	protected boolean isEquals(Aresta a1 , Aresta a2) {
		return a1.equals(a2);
	}
	
	
	public void addVertices(List<Vertice> vertices) {
		for( Vertice v : vertices ) {
			this.addVertice(v);
		}
	}
	public boolean addVertice(Vertice v) {
		return getVertices().add(v);	
	}
	
	public boolean removeVertice(Vertice v) {
		return getVertices().remove(v);
	}
	
	
	
	
	public boolean isAdjacente(Vertice v1 , Vertice v2) {
		
		return getVerticesAdjacentes(v1).contains(v2);
	}



	
	public int getGrau(Vertice v) {
		return this.getVerticesAdjacentes(v).size();
	}

	
	public DepthFirstSearcher DFS() {
		return new DepthFirstSearcher(this);
	}

	
	
	
	
					/** SETTERS & GETTERS **/
	
	
	
	public List<Vertice> getVertices() {
		return V;
	}


	public void setVertices(List<Vertice> v) {
		V = v;
	}


	public List<Aresta> getArestas() {
		return A;
	}


	public void setArestas(List<Aresta> a) {
		A = a;
	}
	
	Grafo getClone() {
		try {
			return (Grafo) super.clone();
		}catch( CloneNotSupportedException e) {
			
		}
		return null;
	}
	
	
	
}
