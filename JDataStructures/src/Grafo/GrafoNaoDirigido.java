package Grafo;

import java.util.*;

public class GrafoNaoDirigido extends Grafo{

	public static void main(String[] args) {
		GrafoNaoDirigido grafo = new GrafoNaoDirigido();
		
		
		Vertice v1 = new Vertice("v1") , v2 = new Vertice("v2") , v3 = new Vertice("v3") , v4 = new Vertice("v4") , v5 = new Vertice("v5") , v6 = new Vertice("v6") , v7 = new Vertice("v7");
		
		grafo.addVertice(v1);
		grafo.addVertice(v2);
		grafo.addVertice(v3);
		grafo.addVertice(v4);
		grafo.addVertice(v5);
		grafo.addVertice(v6);
		grafo.addVertice(v7);
		
		Aresta a1 = new Aresta(v1 , v2) , a2 = new Aresta(v2 , v3) , a3 = new Aresta(v2 , v5) , a4 = new Aresta(v3 , v6) , a5 = new Aresta(v4 , v1) , 
		a6 = new Aresta(v5 , v4) , a7 = new Aresta(v5 , v6) , a8 = new Aresta(v6 , v3) , a9 = new Aresta(v7 , v4) , a10 = new Aresta(v7 , v5) , a11 = new Aresta(v7 , v6);
		
		grafo.addAresta(a1);
		grafo.addAresta(a2);
		grafo.addAresta(a3);
		grafo.addAresta(a4);
		grafo.addAresta(a5);
		grafo.addAresta(a6);
		grafo.addAresta(a7);
		//grafo.addAresta(a8);
		grafo.addAresta(a9);
		grafo.addAresta(a10);
		grafo.addAresta(a11);
		
		System.out.println("Grafo nao dirigido");
		System.out.println("v1 eh Adjance a v3 : "+grafo.isAdjacente(v1, v3));
		System.out.println("v1 grau eh"+grafo.getGrau(v1));
		System.out.println("grafo eh regular"+grafo.isRegular());
		System.out.println("dfs "+grafo.DFS(v6));
		System.out.println("grafo eh conexo "+grafo.isConexo());
		System.out.println("grafo eh simples "+grafo.isSimples());
		System.out.println("grafo eh completo "+grafo.isCompleto());
	}
	
	
	
	
	@Override
	public List<Vertice> getVerticesAdjacentes(Vertice v){
		LinkedList<Vertice> adj = new LinkedList<Vertice>();
		for( Aresta aresta : getArestas()) {
			if( isEquals(aresta.getV1() , v) )
				adj.add(aresta.getV2());
			
			if( isEquals(aresta.getV2() , v) )
				adj.add(aresta.getV1());
		}
		return adj;
	}
	

	public boolean isRegular() {
		/*
		 * Um grafo regular é um grafo onde cada vértice tem o mesmo número de adjacências,
		 *  i.e. cada vértice tem o mesmo grau ou valência. Um grafo direcionado regular também deve satisfazer
		 *   a condição mais forte de que o grau de entrada e o grau de saída de cada vértice sejam iguais uns aos outros.
		 */
		int nAdj = this.getVerticesAdjacentes( this.getVertices().get(0) ).size();
		for(Vertice vertice : getVertices()){
			if(nAdj != getVerticesAdjacentes(vertice).size())
				return false;
		}
		return true;
	}

	
	public boolean isConexo() {
		/*
		 * Grafo  é conexo se existir um caminho entre qualquer par de vértices. 
		 *  Caso Contrário é desconexo – se há pelo menos um par de vértices que não está ligado a nenhuma cadeia (caminho).
		 */
		setAllVisited(false);
		List<Aresta> arestasDeArvore = DFS(getVertices().get(0));
		setAllVisited(false);
		
		getVertices().get(0).setVisited(true);
		
		for(Aresta aresta : arestasDeArvore) {
			aresta.getV1().setVisited(true);
			aresta.getV2().setVisited(true);
		}
		
		for( Vertice vertice : getVertices()) {
			if(!vertice.isVisited()) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isCompleto() {
		/*
		 Um grafo completo é um grafo simples 
		 em que todo vértice é adjacente a todos os outros vértices.
		 */
		if(isSimples())// verifica se grafo simples
			for(Vertice verticeX : getVertices()) {
				for(Vertice verticeY : getVertices()) {
					//verifica se vertice é adjacente a todos os outros vertices (exceto a ele proprio)
					if( !isEquals(verticeX , verticeY) && !isAdjacente(verticeX, verticeY))
						return false;
				}
			}
			
		else
			return false;
		
		return true;
	}
	
	public boolean isSimples() {
		/*
		  Um grafo é simples se ele não tem laços nem mais de uma aresta
		  ligando dois vértices
		*/
		for(Aresta aresta : getArestas()) {
			if( isEquals( aresta.getV1() , aresta.getV2() )) //verifica se ha laço
					return false;
		}
		
		
		for(Aresta aresta : getArestas()) {
			//verifica se ha mais de uma aresta ligando dois vertices
			if(getArestaAdjacente(aresta.getV1() , aresta.getV2()).size() > 1)
				return false;
		}
		
		return true;
	}
	

	
	
	
	public List<Aresta> getArestaAdjacente(Vertice v1 , Vertice v2){
		List<Aresta> tmp = new LinkedList<Aresta>();
		for(Aresta aresta : getArestas()) {
			if(isEquals(aresta.getV1() , v1) && isEquals(aresta.getV2() , v2)
			||
			isEquals(aresta.getV1() , v2) && isEquals(aresta.getV2() , v1))
				tmp.add(aresta);
		}
		return tmp;
	}


}
