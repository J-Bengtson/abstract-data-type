package Grafo;

import java.util.LinkedList;
import java.util.List;

public class GrafoDirigido extends Grafo{
	
	
	
	public static void main(String[] args) {
		GrafoDirigido grafo = new GrafoDirigido();
		
		
		
		Vertice v1 = new Vertice("v1") , v2 = new Vertice("v2") , v3 = new Vertice("v3") , v4 = new Vertice("v4");
		
		grafo.addVertice(v1);
		grafo.addVertice(v2);
		grafo.addVertice(v3);
		
		Aresta a1 = new Aresta(v1 , v2) , a2 = new Aresta(v2 , v3) , a3 = new Aresta(v3 , v1) , a4 = new Aresta(v4,v1);
		
		grafo.addAresta(a1);
		grafo.addAresta(a2);
		grafo.addAresta(a3);
		grafo.addAresta(a4);
		
		System.out.println(grafo.isAdjacente(v1, v3));
		System.out.println(grafo.getGrau(v1));
		System.out.println(grafo.DFS(v4));
	}
	
	

	@Override
	public List<Vertice> getVerticesAdjacentes(Vertice v){
		LinkedList<Vertice> adj = new LinkedList<Vertice>();
		for( Aresta aresta : getArestas()) {
			if( isEquals(aresta.getV1() , v))
				adj.add(aresta.getV2());

		}
		return adj;
	}



	
	public List<Aresta> getArestaAdjacente(Vertice v1 , Vertice v2){
		List<Aresta> tmp = new LinkedList<Aresta>();
		for(Aresta aresta : getArestas()) {
			if(isEquals(aresta.getV1() , v1) && isEquals(aresta.getV2() , v2))
				tmp.add(aresta);
		}
		return tmp;
	}

}
