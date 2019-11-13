package Grafo;

public interface GrafoDirigidoImpl {
	
	int getGrauEntrada(Vertice v1); //
	void ordenacaoTopologica(); // 
	Grafo getTransposto(); //
	boolean isFConexo(); //
}
