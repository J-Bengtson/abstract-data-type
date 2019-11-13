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
		System.out.println("arestas do grafo : " +grafo.getArestas());
		System.out.println("arestas do grafo complementar : " +grafo.getComplementar().getArestas());
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
		 * Um grafo regular ï¿½ um grafo onde cada vï¿½rtice tem o mesmo nï¿½mero de adjacï¿½ncias,
		 *  i.e. cada vï¿½rtice tem o mesmo grau ou valï¿½ncia. Um grafo direcionado regular tambï¿½m deve satisfazer
		 *   a condiï¿½ï¿½o mais forte de que o grau de entrada e o grau de saï¿½da de cada vï¿½rtice sejam iguais uns aos outros.
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
		 * Grafo eh conexo se existir um caminho entre qualquer par de vï¿½rtices. 
		 *  Caso Contrario eh desconexo ï¿½ se hï¿½ pelo menos um par de vï¿½rtices que nï¿½o estï¿½ ligado a nenhuma cadeia (caminho).
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
					//verifica se vertice ï¿½ adjacente a todos os outros vertices (exceto a ele proprio)
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
		  Um grafo ï¿½ simples se ele nï¿½o tem lacos nem mais de uma aresta
		  ligando dois vï¿½rtices
		*/
		for(Aresta aresta : getArestas()) {
			if( isEquals( aresta.getV1() , aresta.getV2() )) //verifica se ha laï¿½o
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
	public boolean isIsolado(Vertice v1) {
		//Um vértice isolado é um vértice com grau zero, isto é, um vértice que não é um ponto final de toda a aresta.
		return this.getVerticesAdjacentes(v1).size() == 0;
	}




	@Override
	public boolean isPendente(Vertice v1) {
		//Um vértice folha (também vértice pendente) é um vértice de grau um.
		return this.getVerticesAdjacentes(v1).size() == 1;
	}




	@Override
	public boolean isNulo() {
		//grafo nulo ou o grafo vazio é o grafo sem arestas.		
		return this.getArestas().size() == 0;
	}




	@Override
	public boolean isBipartido() {
		// grafo bipartido ou bigrafo é um grafo cujos vértices podem ser divididos em dois conjuntos
		//disjuntos U e V tais que toda aresta conecta um vértice em U a um vértice em V;
		List<Vertice> U = new LinkedList<Vertice>();
		List<Vertice> V = new LinkedList<Vertice>();
		
		for( Aresta aresta : this.getArestas()) {
			//aresta.getV1()
		}
		
		return false;
	}





	@Override
	public Grafo getComplementar() {
		Grafo grafoComplementar = new GrafoNaoDirigido();
		grafoComplementar.addVertices(this.getVertices());
		for( Vertice v1 : grafoComplementar.getVertices()) {
			for(Vertice v2 : grafoComplementar.getVertices()) {
				if( !grafoComplementar.isEquals(v1, v2) && !(this.getArestaAdjacente(v1, v2).size() > 0)) {
					grafoComplementar.addAresta(new Aresta(v1,v2));
				}
			}
		}
		return grafoComplementar;
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
