package Grafo;

import java.util.*;

public abstract class Grafo {
	
	

	
	
	
	
	private List<Vertice> V = new LinkedList<Vertice>();
	private List<Aresta> A = new LinkedList<Aresta>();
	
	
	public void setAllVisited(Boolean isVisited) {
		for(Vertice vertice : getVertices())
			vertice.setVisited(isVisited);
	}
	
	
	public boolean addAresta(Aresta a) {
		return getArestas().add(a);
	}
	
	public boolean removeAresta(Aresta a) {
		return getArestas().remove(a);
	}
	
	public abstract List<Aresta> getArestaAdjacente(Vertice v1 , Vertice v2);
	
	public boolean isEquals(Vertice v1 , Vertice v2) {
		return v1.equals(v2);
	}
	
	
	
	public boolean addVertice(Vertice v) {
		return getVertices().add(v);	
	}
	
	public boolean removeVertice(Vertice v) {
		return getVertices().remove(v);
	}
	
	
	
	public abstract List<Vertice> getVerticesAdjacentes(Vertice v);
	
	public boolean isAdjacente(Vertice v1 , Vertice v2) {
		
		return getVerticesAdjacentes(v1).contains(v2);
	}



	
	public int getGrau(Vertice v) {
		return this.getVerticesAdjacentes(v).size();
	}
	
	
	public List<Aresta> DFS(Vertice vertice) {
		
		List<Aresta> tmp = new LinkedList<Aresta>();
		vertice.setVisited(true);

		
		for( Vertice adj : getVerticesAdjacentes(vertice))
			if(!adj.isVisited()) {
				tmp.add(this.getArestaAdjacente(vertice, adj).get(0));
				List<Aresta> arvore = DFS(adj);
				tmp.addAll(arvore);
			}
		
		return tmp;
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
	
	
	
	
}
