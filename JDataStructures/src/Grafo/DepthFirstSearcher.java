package Grafo;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearcher{
	private Grafo grafo;
	
	DepthFirstSearcher(Grafo grafo){
		this.grafo = grafo.getClone();
	}
	
	public List<Visitavel> DFS_VisitaAresta (Vertice vertice){
		
		List<Visitavel> tmp = new LinkedList<Visitavel>();
		/* cria-se estrtura de dados para indxar vertices e arestas visitadas */
		tmp.add(vertice);/* add vertice a lista */
		for( Vertice adj : grafo.getVerticesAdjacentes(vertice)) 
		{/* percorre todos os vertices adjacentes a v (adj) */
			for(Aresta aresta : grafo.getArestaAdjacente(vertice, adj)) 
			{/* visita todas as arestas entre v e vertices adjacentes a v(adj) */
				if(!aresta.foiVisitado())
				{ /* verifica se aresta foi visitada */
					tmp.add(aresta); /* add aresta a lista */
					tmp.add(adj); /* add vertice a lista */
					aresta.visita();/* seta aresta como visitado */
					adj.visita(); /* seta vertice como visitado */
					
					List<Visitavel> dfs = DFS_VisitaAresta(adj);/* recursivamente visita todas as arestas nao visitadas adjacentes (profundidade) e as indexa em lista  */
					tmp.addAll(dfs); /* junta as listas */
				}
			}
		}
		return tmp; //retorna lista
		
	}
	
	
	public List<Aresta> DFS_VisitaVertice(Vertice vertice) {
		
		/*
		 Algoritmo busca em profundidade : as arestas de �rvore s�o exploradas a partir do v�rtice v mais
		 recentemente descoberto que ainda possui arestas n�o exploradas saindo dele e por fim retornada.
		 */
		
		
		List<Aresta> tmp = new LinkedList<Aresta>(); //cria-se estrutura de dados para indexar arestas de arvore
		vertice.visita(); //seta v como visitado

		
		for( Vertice adj : grafo.getVerticesAdjacentes(vertice))// percorre e adiciona na lista todos os vertices adjacentes de v recursivamente
			if(!adj.foiVisitado()) {
				tmp.add(this.grafo.getArestaAdjacente(vertice, adj).get(0));
				List<Aresta> arvore = DFS_VisitaVertice(adj);
				tmp.addAll(arvore);
			}
		
		return tmp;
	}
	
	
	
	public void setGrafo(Grafo grafo) {
		this.grafo = grafo.getClone();
	}
	
	public Grafo getGrafo() {
		return this.grafo;
	}


}
