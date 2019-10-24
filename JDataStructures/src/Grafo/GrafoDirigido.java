package Grafo;

import java.util.LinkedList;
import java.util.List;

public class GrafoDirigido extends Grafo{
	
		public static void main(String[] args) {
			GrafoDirigido grafo = new GrafoDirigido();
			
			
			Vertice v1 = new Vertice("v1") , v2 = new Vertice("v2") , v3 = new Vertice("v3") , v4 = new Vertice("v4") , v5 = new Vertice("v5") , v6 = new Vertice("v6") , v7 = new Vertice("v7");
			
			grafo.addVertice(v1);
			grafo.addVertice(v2);
			grafo.addVertice(v3);
			grafo.addVertice(v4);
			grafo.addVertice(v5);
			grafo.addVertice(v6);
			grafo.addVertice(v7);
			
			Aresta a1 = new Arco(v1 , v2) , a2 = new Aresta(v2 , v3) , a3 = new Aresta(v2 , v5) , a4 = new Aresta(v3 , v6) , a5 = new Aresta(v4 , v1) , 
			a6 = new Aresta(v5 , v4) , a7 = new Aresta(v5 , v6) , a8 = new Aresta(v6 , v3) , a9 = new Aresta(v7 , v4) , a10 = new Aresta(v7 , v5) , a11 = new Aresta(v7 , v6);
			
			grafo.addAresta(a1);
			grafo.addAresta(a2);
			grafo.addAresta(a3);
			grafo.addAresta(a4);
			grafo.addAresta(a5);
			grafo.addAresta(a6);
			grafo.addAresta(a7);
			grafo.addAresta(a8);
			grafo.addAresta(a9);
			grafo.addAresta(a10);
			grafo.addAresta(a11);
			
			System.out.println("v1 eh Adjance a v3 : "+grafo.isAdjacente(v1, v3));
			System.out.println("v1 grau eh"+grafo.getGrau(v1));
			System.out.println("dfs "+grafo.DFS_VisitaAresta(v7));
		}
	
	
	

	@Override
	public List<Vertice> getVerticesAdjacentes(Vertice v){
		LinkedList<Vertice> adj = new LinkedList<Vertice>();
		for( Aresta aresta : getArestas()) // grafo dirigido 
			if( isEquals(aresta.getV1() , v))// se vertice for igual ao primeiro vertice da aresta
				adj.add(aresta.getV2()); //logo segundo vertice é adjacente ao primeiro e entao add na lista
		return adj;
	}



	
	public List<Aresta> getArestaAdjacente(Vertice v1 , Vertice v2){
		List<Aresta> tmp = new LinkedList<Aresta>();
		for(Aresta aresta : getArestas()) // grafo dirigido
			if(isEquals(aresta.getV1() , v1) && isEquals(aresta.getV2() , v2))
				// se primeira vertice for igual a v1 e segunda vertice for igual a v2 entao a aresta é adjancente a ambos
				tmp.add(aresta);
		return tmp;
	}

}
