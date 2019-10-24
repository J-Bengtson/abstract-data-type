package Grafo;

import java.util.*;

public abstract class Grafo {
	
	private List<Vertice> V = new LinkedList<Vertice>();
	private List<Aresta> A = new LinkedList<Aresta>();
	
	
	public void setAllVisited(Boolean isVisited) {
		for(Vertice vertice : getVertices())
			vertice.setIsVisited(isVisited);
	}
	
	public boolean addAresta(Aresta a) {
		List<Vertice> vertices = getVertices();
		if(!vertices.contains(a.getV1()))
			addVertice(a.getV1());
		if(!vertices.contains(a.getV2()))
			addVertice(a.getV2());
		
		return getArestas().add(a);
	}
	
	public boolean removeAresta(Aresta a) {
		return getArestas().remove(a);  
	}
	
	public abstract List<Aresta> getArestaAdjacente(Vertice v1 , Vertice v2); 
	// funcao retorna lista de arestas adjancentes entre ambos vertices v1 e v2
	
	public abstract List<Vertice> getVerticesAdjacentes(Vertice v); 
	// funçao retorna lista de vertices adjancentes de v

	
	public boolean isEquals(Vertice v1 , Vertice v2) {
		return v1.equals(v2);
	}
	
	public boolean isEquals(Aresta a1 , Aresta a2) {
		return a1.equals(a2);
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
	
	
	
	public List<Aresta> DFS_VisitaVertice(Vertice vertice) {
		
		/*
		 Algoritmo busca em profundidade : as arestas de árvore são exploradas a partir do vértice v mais
		 recentemente descoberto que ainda possui arestas não exploradas saindo dele e por fim retornada.
		 */
		
		
		List<Aresta> tmp = new LinkedList<Aresta>(); //cria-se estrutura de dados para indexar arestas de arvore
		vertice.setIsVisited(true); //seta v como visitado

		
		for( Vertice adj : getVerticesAdjacentes(vertice))// percorre e adiciona na lista todos os vertices adjacentes de v recursivamente
			if(!adj.isVisited()) {
				tmp.add(this.getArestaAdjacente(vertice, adj).get(0));
				List<Aresta> arvore = DFS_VisitaVertice(adj);
				tmp.addAll(arvore);
			}
		
		return tmp;
	}
	
	
	public List<Objeto> DFS_VisitaAresta (Vertice vertice){
		
		List<Objeto> tmp = new LinkedList<Objeto>();
		tmp.add(vertice);
		for( Vertice adj : getVerticesAdjacentes(vertice)) {
			for(Aresta aresta : getArestaAdjacente(vertice, adj)) {
				if(!aresta.isVisited()) {
					tmp.add(aresta);
					aresta.setIsVisited(true);
					adj.setIsVisited(true);
					List<Objeto> arvore = DFS_VisitaAresta(adj);
					tmp.addAll(arvore);
				}
			}
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
