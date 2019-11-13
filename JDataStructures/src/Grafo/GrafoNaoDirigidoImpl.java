package Grafo;

public interface GrafoNaoDirigidoImpl {
	
	boolean isAdjacente( Vertice v1 , Vertice v2); //ok
	int getGrau(Vertice v1); //ok
	boolean isRegular(); //ok
	boolean isIsolado(Vertice v1); //ok
	boolean isPendente(Vertice v1);//ok
	boolean isNulo();// ok
	boolean isCompleto();//ok
	boolean isConexo();//ok
	boolean isBipartido();//
	Grafo getComplementar();// ok
	boolean isEuleriano();//ok
	boolean isUnicursal();//
	boolean hasCiclo();//
}
