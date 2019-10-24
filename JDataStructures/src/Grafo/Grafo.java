package Grafo;

import java.util.*;

public abstract class Grafo {
	
	private List<Vertice> V = new LinkedList<Vertice>();
	private List<Aresta> A = new LinkedList<Aresta>();
	
	
	public void setAllVisited(Boolean isVisited) {
		for(Vertice vertice : getVertices())
			vertice.setIsVisited(isVisited);
		
		for(Aresta aresta : getArestas())
			aresta.setIsVisited(isVisited);
	}
	
	protected void limpaVisitados() {
		// seta todos as arestas e vertices previamente visitados com valor false
		// para realizar nova busca sem conflitos
		setAllVisited(false);
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
		 Algoritmo busca em profundidade : as arestas de �rvore s�o exploradas a partir do v�rtice v mais
		 recentemente descoberto que ainda possui arestas n�o exploradas saindo dele e por fim retornada.
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
		/* cria-se estrtura de dados para indxar vertices e arestas visitadas */
		tmp.add(vertice);/* add vertice a lista */
		for( Vertice adj : getVerticesAdjacentes(vertice)) {
			/* percorre todos os vertices adjacentes a v (adj) */
			for(Aresta aresta : getArestaAdjacente(vertice, adj)) {
				/* visita todas as arestas entre v e vertices adjacentes a v(adj) */
				if(!aresta.isVisited()){ /* verifica se aresta foi visitada */
					tmp.add(aresta); /* add aresta a lista */
					tmp.add(adj); /* add vertice a lista */
					aresta.setIsVisited(true);/* seta aresta como visitado */
					adj.setIsVisited(true); /* seta vertice como visitado */
					List<Objeto> dfs = DFS_VisitaAresta(adj);/* recursivamente visita todas as arestas nao visitadas adjacentes (profundidade) e as indexa em lista  */
					tmp.addAll(dfs); /* junta as listas */
				}
			}
		}
		return tmp; //retorna lista
		
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
