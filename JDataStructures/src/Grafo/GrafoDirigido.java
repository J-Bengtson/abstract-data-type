package Grafo;

import java.util.LinkedList;
import java.util.List;

public class GrafoDirigido extends Grafo implements GrafoDirigidoImpl{
	
	GrafoDirigido(){
		super();
		this.setEhDirigido(true);
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


	@Override
	public int getGrauEntrada(Vertice v1) {
		
		int grauEntrada = 0;
		
		for(Vertice vertice : this.getVertices()) {
			if(!isEquals(vertice , v1)) 
				grauEntrada += getArestaAdjacente(vertice , v1).size();
		}
		
		return grauEntrada;
	}




	@Override
	public void ordenacaoTopologica() {
		
	}




	@Override
	public Grafo getTransposto() {
		
		GrafoDirigido grafoDirigido = new GrafoDirigido();
		for( Aresta aresta : this.getArestas() ) {
			grafoDirigido.addAresta(new Arco(aresta.getV2() , aresta.getV1()));
		}
		
		return grafoDirigido != null? grafoDirigido : null;
	}




	@Override
	public boolean isFConexo() {
		return false;
	}
	
	


}
