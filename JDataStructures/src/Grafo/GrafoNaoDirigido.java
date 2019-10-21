package Grafo;

import java.util.*;

public class GrafoNaoDirigido extends Grafo{

	public static void main(String[] args) {
		GrafoNaoDirigido grafo = new GrafoNaoDirigido();
		
		
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
		System.out.println(grafo.isRegular());
		System.out.println(grafo.DFS(v1));
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
	
	/*
	 * m grafo regular � um grafo onde cada v�rtice tem o mesmo n�mero de adjac�ncias,
	 *  i.e. cada v�rtice tem o mesmo grau ou val�ncia. Um grafo direcionado regular tamb�m deve satisfazer
	 *   a condi��o mais forte de que o grau de entrada e o grau de sa�da de cada v�rtice sejam iguais uns aos outros.
	 */
	public boolean isRegular() {
		
		int nAdj = this.getVerticesAdjacentes( this.getVertices().get(0) ).size();
		for(Vertice vertice : getVertices()){
			if(nAdj != getVerticesAdjacentes(vertice).size())
				return false;
		}
		return true;
	}
//	
//	public boolean isConexo() {
//		/*
//		 * Grafo  � conexo se existir um caminho entre qualquer par de v�rtices. 
//		 *  Caso Contr�rio � desconexo � se h� pelo menos um par de v�rtices que n�o est� ligado a nenhuma cadeia (caminho).
//		 */
//		
//
//		return isConexo(getVertices().get(0));
//	}
//	
//	
//	private Array= isConexo(Vertice vertice) {
//		
//		for( Vertice adj : getVerticesAdjacentes(vertice))
//			if(!adj.isVisited()) {
//				adj.setVisited(true);
//				if(isConexo(adj))
//					return true;
//			}
//		
//		return false;
//	}
	

	
	
	
	public List<Aresta> getArestaAdjacente(Vertice v1 , Vertice v2){
		List<Aresta> tmp = new LinkedList<Aresta>();
		for(Aresta aresta : getArestas()) {
			if(isEquals(aresta.getV1() , v1) && isEquals(aresta.getV2() , v2)
					||
				isEquals(aresta.getV1() , v2) && isEquals(aresta.getV2() , v1)
					)
				tmp.add(aresta);
		}
		return tmp;
	}


}
