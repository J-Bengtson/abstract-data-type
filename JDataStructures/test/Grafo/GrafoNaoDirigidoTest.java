package Grafo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class GrafoNaoDirigidoTest extends TestCase {
	
	
	/*
assertEquals(): Testa igualdade entre dois objetos (esperado x retornado).
assertFalse(): Testa Retorno booleano FALSO.
assertTrue(): Testa Retorno booleano VERDADEIRO.
assertNotNull(): Testa se um valor de um objeto N�O est� NULO.
assertNull(): Testa se um valor de um objeto est� NULO.
	 */
	

	private GrafoNaoDirigido grafo;
	
	private Vertice v1 = new Vertice("v1") ,
			v2 = new Vertice("v2") , 
			v3 = new Vertice("v3");
	
	private Aresta a1 = new Aresta(v1 , v2) ,
		   a2 = new Aresta(v2 , v3),
		   a3 = new Aresta(v3 , v1);

	@BeforeEach
	protected void setUp() throws Exception {
		this.grafo = new GrafoNaoDirigido();

		grafo.addVertice(v1); grafo.addVertice(v2); grafo.addVertice(v3);
		grafo.addAresta(a1); grafo.addAresta(a2); grafo.addAresta(a3);
		
	}
	
	public void testGetGrau() {
		TestCase.assertEquals( grafo.getGrau(v1), 2);
		TestCase.assertEquals( grafo.getGrau(v2), 2);
		TestCase.assertEquals( grafo.getGrau(v3), 2);
	}


	
	public void testIsRegular() {
		
	}
	

	
	public void testIsConexo() {
		GrafoNaoDirigido GNaoConexo = new GrafoNaoDirigido() ,  GConexo = new GrafoNaoDirigido();
		
	}
	
	
	@Test
	public void testIsEuleriano() {
		
		GrafoNaoDirigido euleriano = new GrafoNaoDirigido();
		
		Vertice a = new Vertice("a"),
				b = new Vertice("b"),
				c = new Vertice("c"),
				d = new Vertice("d"),
				e = new Vertice("e");
		
		Aresta a1 = new Aresta(a , b),
			   a2 = new Aresta(a , d),
			   a3 = new Aresta( b , c),
			   a4 = new Aresta( b , c),
			   a5 = new Aresta(b , e),
			   a6 = new Aresta(c , d ),
			   a7 = new Aresta( c , d),
			   a8 = new Aresta(d , e);
		
		euleriano.addAresta(a1);
		euleriano.addAresta(a2);
		euleriano.addAresta(a3);
		euleriano.addAresta(a4);
		euleriano.addAresta(a5);
		euleriano.addAresta(a6);
		euleriano.addAresta(a7);
		euleriano.addAresta(a8);
		
		
 		System.out.println(euleriano.isEuleriano());
		TestCase.assertEquals(true, euleriano.isEuleriano());
		




		
		
	}

}
