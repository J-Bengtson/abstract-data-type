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
assertNotNull(): Testa se um valor de um objeto NÃO está NULO.
assertNull(): Testa se um valor de um objeto está NULO.
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
	
	@Test
	public void testGetGrau() {
		TestCase.assertEquals( grafo.getGrau(v1), 2);
		TestCase.assertEquals( grafo.getGrau(v2), 2);
		TestCase.assertEquals( grafo.getGrau(v3), 2);
	}

	@Test
	void test() {
		testGetGrau();
		
	}
	
	
	public void testIsRegular() {
		
	}
	

	
	public void testIsConexo() {
		GrafoNaoDirigido GNaoConexo = new GrafoNaoDirigido() ,  GConexo = new GrafoNaoDirigido();
		
	}

}
