package Grafo;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class DijkstraAlgoritmo {
	private Grafo grafo;
	
	DijkstraAlgoritmo(Grafo grafo){
		if(grafo instanceof GrafoValoradoNaoDirigido || grafo instanceof GrafoValoradoDirigido)
			this.grafo = grafo;
	}
	
	
	public List<Visitavel> menorCaminhoEntre(Vertice v1 , Vertice v2){
		
		if(this.grafo == null)
			return new ArrayList<Visitavel>();
		
				
		List<Visitavel> resultado = new ArrayList<Visitavel>();
		
		Vertice no = v1;
		
		Number menorAdjacente = Integer.MAX_VALUE;
		for( Vertice vertice : grafo.getVerticesAdjacentes(no)) {
			for( Aresta aresta : grafo.getArestaAdjacente(no, vertice)) {
				menorAdjacente = Math.min( (int) aresta.getGrau() , (int) menorAdjacente);
			}
		}
		
		
		System.out.println(menorAdjacente);
		
		return resultado;
	}
}
