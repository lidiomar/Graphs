package br.com.paa;

public class Main {
	public static void main(String ... args) {
		Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 0);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 1);
        g1.addEdge(2, 3);
        g1.addEdge(3, 2);
        
        g1.getGraphType();
 
        /*Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 0);
        g2.getGraphType();
        
        Graph g3 = new Graph(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(3, 2);
        g3.addEdge(3, 1);
        g3.addEdge(2, 4);
        g3.getGraphType();*/
	}
}
