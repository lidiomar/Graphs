package br.com.paa;

public class Main {
	public static void main(String ... args) {
		Graph g1 = new Graph(9);
		
	    g1.addEdge(0, 1);
	    g1.addEdge(0, 5);
	    g1.addEdge(0, 7);
	    g1.addEdge(0, 8);
	    
	    g1.addEdge(1, 0);
	    g1.addEdge(1, 2);
	    g1.addEdge(1, 3);
	    g1.addEdge(1, 7);
	    
	    g1.addEdge(2, 1);
	    g1.addEdge(2, 3);
	    
	    g1.addEdge(3, 1);
	    g1.addEdge(3, 2);
	    
	    g1.addEdge(4, 6);
	    g1.addEdge(4, 7);
	    
	    g1.addEdge(5, 0);
	    g1.addEdge(5, 8);
	    
	    g1.addEdge(6, 4);
	    g1.addEdge(6, 7);
	    
	    g1.addEdge(7, 0);
	    g1.addEdge(7, 1);
	    g1.addEdge(7, 4);
	    g1.addEdge(7, 6);
	    
	    g1.addEdge(8, 0);
	    g1.addEdge(8, 5);
	    
	    //g1.traversal();
	    
	    Graph g2 = new Graph(9);
		
	    g2.addEdge(0, 8);
	    g2.addEdge(0, 7);
	    g2.addEdge(0, 5);
	    g2.addEdge(0, 1) ;
	    
	    g2.addEdge(1, 7);
	    g2.addEdge(1, 3);
	    g2.addEdge(1, 2);
	    g2.addEdge(1, 0);
	    
	    g2.addEdge(2, 3);
	    g2.addEdge(2, 1);
	    
	    g2.addEdge(3, 2);
	    g2.addEdge(3, 1);
	    
	    g2.addEdge(4, 7);
	    g2.addEdge(4, 6);
	    
	    g2.addEdge(5, 8);
	    g2.addEdge(5, 0);
	    
	    g2.addEdge(6, 7);
	    g2.addEdge(6, 4);
	    
	    g2.addEdge(7, 6);
	    g2.addEdge(7, 4);
	    g2.addEdge(7, 1);
	    g2.addEdge(7, 0);
	    
	    g2.addEdge(8, 5);
	    g2.addEdge(8, 0);
	    
	    g2.traversal2();
	    
	    
	    Graph g3 = new Graph(9);
		
	    g3.addEdge(0, 1);
	    g3.addEdge(0, 7);
	    g3.addEdge(0, 5);
	    g3.addEdge(0, 8) ;
	    
	    g3.addEdge(1, 0);
	    g3.addEdge(1, 3);
	    g3.addEdge(1, 2);
	    g3.addEdge(1, 7);
	    
	    g3.addEdge(2, 1);
	    g3.addEdge(2, 3);
	    
	    g3.addEdge(3, 1);
	    g3.addEdge(3, 2);
	    
	    g3.addEdge(4, 6);
	    g3.addEdge(4, 7);
	    
	    g3.addEdge(5, 0);
	    g3.addEdge(5, 8);
	    
	    g3.addEdge(6, 4);
	    g3.addEdge(6, 7);
	    
	    g3.addEdge(7, 0);
	    g3.addEdge(7, 4);
	    g3.addEdge(7, 1);
	    g3.addEdge(7, 6);
	    
	    g3.addEdge(8, 0);
	    g3.addEdge(8, 5);
	    
	    //g3.traversal3();
       
	}
}
