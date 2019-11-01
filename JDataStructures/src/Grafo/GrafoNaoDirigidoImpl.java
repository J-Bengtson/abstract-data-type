package Grafo;

public interface GrafoNaoDirigidoImpl {
	boolean isAdjacente( Vertice v1 , Vertice v2);
	int getGrau(Vertice v1);
	boolean isRegular();
	boolean isIsolado();
	boolean isPendente(Vertice v1);
	boolean isNulo();
	boolean isCompleto();
	boolean isConexo();
	boolean isBipartido();
	Grafo getComplementar();
	boolean isEuleriano();
	boolean isUnicursal();
	boolean hasCiclo();
}
