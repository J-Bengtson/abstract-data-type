package Grafo;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * Projected and implemented by: J�lio Bengtson Neves (J-Bengtson)
 * Projetado e implementado por: J�lio Bengtson Neves (J-Bengtson)
 * Available on Github: github.com/J-Bengtson
 * 
 */

public class GrafoVisualizador extends JFrame {

public static void main(String[]args) {	
	GrafoDirigido grafo = new GrafoDirigido();
	
	
	Vertice v1 = new Vertice("v1") , v2 = new Vertice("v2") , v3 = new Vertice("v3") , v4 = new Vertice("v4") , v5 = new Vertice("v5") , v6 = new Vertice("v6") , v7 = new Vertice("v7");
	
	grafo.addVertice(v1);
	grafo.addVertice(v2);
	grafo.addVertice(v3);
	grafo.addVertice(v4);
	grafo.addVertice(v5);
	grafo.addVertice(v6);
	grafo.addVertice(v7);
	
	Aresta a1 = new Aresta(v1 , v2 , 5) , a2 = new Aresta(v2 , v3) , a3 = new Aresta(v2 , v5) , a4 = new Aresta(v3 , v6) , a5 = new Aresta(v4 , v1) , 
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
	
	
	new GrafoVisualizador(grafo);
}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static final int WIDTH = 400 , HEIGHT = 400;
	private JCanvas JCanvas;
	GrafoVisualizador(Grafo grafo){
		super("Grafo Visualizador");
		this.setSize(WIDTH, HEIGHT);
		this.setAlwaysOnTop(true);
		
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add( JCanvas = new JCanvas(grafo) , BorderLayout.CENTER);
		
		JButton randomButton = new JButton("<>");
		this.getContentPane().add(randomButton , BorderLayout.SOUTH);
		
		randomButton.addActionListener( e -> {
			JCanvas.repaint();
		});

		
		this.setVisible(true);
		//this.pack();
	}
	
	
	private class JCanvas extends Canvas{
		private Grafo grafo;
		JCanvas(Grafo grafo){
			super();
			
			this.grafo = grafo;
			
			repaint();
		}
		
		
		@Override
		public void paint(Graphics g) {
			Collection<Vertice> vertices = grafo.getVertices();
			Collection<Aresta> arestas = grafo.getArestas();

			g.setColor(Color.RED);
			
			Map<Vertice, Point> map = new TreeMap<Vertice,Point>();
			
			
			for( Vertice v : vertices) {
				
				int x = (int) (Math.random() * GrafoVisualizador.HEIGHT) + 1;
				int y = (int) (Math.random() * GrafoVisualizador.WIDTH) + 1;
				
				map.put( v , new Point(x,y));
				g.fillOval(x , y  , 4 , 4);
				g.drawString(v.getID() , x  ,y );
				
			}
			
			g.setColor(Color.BLACK);
			for( Aresta e : arestas) {
				
				Point pV1 = null , pV2 = null ;
				
				for(Map.Entry<Vertice, Point> entry : map.entrySet()) {
					if(entry.getKey().compareTo(e.getV1())) {
						pV1 = entry.getValue();
						break;
					}
						
				}
				
				for(Map.Entry<Vertice, Point> entry : map.entrySet()) {
					if(entry.getKey().compareTo(e.getV2())) {
						pV2 = entry.getValue();
						break;
					}
						
				}

				
			
				if(grafo.ehDirigido()) {
					
					this.drawArrow(g , pV1.x , pV1.y , pV2.x  , pV2.y  );
		
				}
				else {
					g.drawLine(pV1.x + 5, pV1.y + 5  , pV2.x + 5 , pV2.y + 5);	
				}
				
				g.drawString(String.valueOf(e.getGrau()) , (int)(pV1.x+pV2.x)/2,(int)(pV1.y+pV2.y)/2);

			}
			
			g.dispose();
		}
		

        void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
            Graphics2D g = (Graphics2D) g1.create();
            
            int ARR_SIZE = 4;
            
            double dx = (x2 - x1), dy = y2 - y1;
            double angle = Math.atan2(dy, dx);
            int len = (int) Math.sqrt(dx*dx + dy*dy) - 5;
            AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
            at.concatenate(AffineTransform.getRotateInstance(angle));
            g.transform(at);

            g.drawLine(0, 0, len, 0);
            g.fillPolygon(new int[] {len + 4, len-ARR_SIZE - 2, len-ARR_SIZE - 2, len + 4},
                          new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
        }
		
	}

}