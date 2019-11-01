package Grafo;

import java.util.*;

public class GrafoNaoDirigido extends Grafo implements GrafoNaoDirigidoImpl{

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
		grafo.addAresta(a8);
		grafo.addAresta(a9);
		grafo.addAresta(a10);
		grafo.addAresta(a11);
		
		System.out.println("Grafo nao dirigido");
		System.out.println("v1 eh Adjance a v3 : "+grafo.isAdjacente(v1, v3));
		System.out.println("v1 grau eh"+grafo.getGrau(v1));
		System.out.println("grafo eh regular"+grafo.isRegular());
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
		 * Um grafo regular � um grafo onde cada v�rtice tem o mesmo n�mero de adjac�ncias,
		 *  i.e. cada v�rtice tem o mesmo grau ou val�ncia. Um grafo direcionado regular tamb�m deve satisfazer
		 *   a condi��o mais forte de que o grau de entrada e o grau de sa�da de cada v�rtice sejam iguais uns aos outros.
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
		 * Grafo eh conexo se existir um caminho entre qualquer par de v�rtices. 
		 *  Caso Contrario eh desconexo � se h� pelo menos um par de v�rtices que n�o est� ligado a nenhuma cadeia (caminho).
		 */
		this.limpaVisitados();
		
		DepthFirstSearcher DFSeacher = DFS();
		
		DFSeacher.DFS_VisitaVertice(this.getVertices().get(0));
		
		// aplica algoritmo dfs em qualquer vertice,
		//se houver vertices nao visitadas significa que o grafo nao eh conexo
		for( Vertice vertice : DFSeacher.getGrafo().getVertices()) {
			if(!vertice.foiVisitado()) {
				return false;
			}
		}
		
		return true;
	}

	
	public boolean isCompleto() {
		/*
		 Um grafo completo eh um grafo simples 
		 em que todo vertice eh adjacente a todos os outros vertices.
		 */
		if(isSimples())// verifica se grafo simples
			for(Vertice verticeX : getVertices()) {
				for(Vertice verticeY : getVertices()) {
					//verifica se vertice � adjacente a todos os outros vertices (exceto a ele proprio)
					if( !isEquals(verticeX , verticeY) && !isAdjacente(verticeX, verticeY))
						return false;
				}
			}
			
		else
			return false;
		
		return true;
	}
	
	private boolean isSimples() {
		/*
		  Um grafo � simples se ele n�o tem lacos nem mais de uma aresta
		  ligando dois v�rtices
		*/
		for(Aresta aresta : getArestas()) {
			if( isEquals( aresta.getV1() , aresta.getV2() )) //verifica se ha la�o
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
			if( (isEquals(aresta.getV1() , v1) && isEquals(aresta.getV2() , v2) )||
			(isEquals(aresta.getV1() , v2) && isEquals(aresta.getV2() , v1)))
				tmp.add(aresta);
		}
		return tmp;
	}

	
	public boolean isEuleriano() {
		
		if(!isConexo())
			return false;
		
		for(Vertice vertice : getVertices()) {
			if(getVerticesAdjacentes(vertice).size() % 2 != 0)
				return false;
		}
		
		return true;
	}



	
	
	
	

	@Override
	public boolean isIsolado() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean isPendente(Vertice v1) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean isNulo() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean isBipartido() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public Grafo getComplementar() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean isUnicursal() {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean hasCiclo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
