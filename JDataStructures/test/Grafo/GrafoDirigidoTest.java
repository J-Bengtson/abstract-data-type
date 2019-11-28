package Grafo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class GrafoDirigidoTest extends TestCase{

	
	private GrafoDirigido grafoDirigido = new GrafoDirigido();
	private Vertice v1 = new Vertice("v1") , 
			v2 = new Vertice("v2"), 
			v3 = new Vertice("v3"),
			v4 = new Vertice("v4");

	
	@BeforeEach
	protected
	void setUp() throws Exception {
		
		grafoDirigido.addAresta(new Aresta( v1 , v2 ));
		grafoDirigido.addAresta(new Aresta( v2 , v3 ));
		grafoDirigido.addAresta(new Aresta( v3 , v1 ));
		grafoDirigido.addAresta(new Aresta( v3 , v4 ));
	}

	
	/*
assertEquals(): Testa igualdade entre dois objetos (esperado x retornado).
assertFalse(): Testa Retorno voido FALSO.
assertTrue(): Testa Retorno voido VERDADEIRO.
assertNotNull(): Testa se um valor de um objeto N�O est� NULO.
assertNull(): Testa se um valor de um objeto est� NULO.
	 */
	
	@Test
	public void isAdjacente() {
		TestCase.assertTrue(grafoDirigido.isAdjacente(v1, v2));
		TestCase.assertFalse(grafoDirigido.isAdjacente(v1, v3));
	}
	
	@Test
	public void getGrauEntrada() {
		TestCase.assertEquals(grafoDirigido.getGrauEntrada(v1), 1);
	}
	
	public void ordenacaoTopologica() {
		
	}

	@Test
	public void getTransposto() {
		System.out.println("grafo dirigido : "+grafoDirigido);
		System.out.println("Grafo dirigido transposto : " +grafoDirigido.getTransposto());
	}


	public void isFConexo() {
	}

}
