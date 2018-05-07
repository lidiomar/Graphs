package br.com.paa;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	
	private LinkedList<Integer> vertexList[];
	private boolean visited[];
	
	public Graph(int size) {
		vertexList = new LinkedList[size];
		visited = new boolean[size];
		
		for(int i = 0; i < size; i ++) {
			vertexList[i] = new LinkedList<Integer>();
		}
	}
	
	public void dfs(int vertex) {
		visited[vertex] = true;
		System.out.println("vertex: -> " + vertex);
		
		Iterator<Integer> iterator = vertexList[vertex].listIterator();
		
		while (iterator.hasNext()) {
			int nextVertex = iterator.next();
			if(!visited[nextVertex]) {
				dfs(nextVertex);
			}
		}
	}
	
	public void addEdge(int vertex, int edge) {
		vertexList[vertex].add(edge);
	}
	
	
	/* 0: Is not Eulerian
	 * 1: Eulerian Cycle 
	 * 2: Eulerian Path*/
	public int getGraphType() {
		int oddEdges = 0;
		
		for(int i=0; i < vertexList.length; i++) {
			
			int edges = vertexList[i].size();
			
			if(edges == 0) {
				System.out.println("Is not Eulerian");
				return 0;
			}
			
			if(edges % 2 != 0) {
				oddEdges++;
			}
		}
		
		if(oddEdges == 0) {
			System.out.println("Eulerian Cycle");
			return 1;
		}else if(oddEdges == 2) {
			System.out.println("Eulerian Path");
			return 2;
		}else {
			System.out.println("Is not Eulerian");
			return 0;
		}
	}

}
