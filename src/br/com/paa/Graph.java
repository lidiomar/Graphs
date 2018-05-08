package br.com.paa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	
	private LinkedList<Integer> vertexList[];
	private boolean visited[];
	private Stack<Integer> stack;
	private ArrayList<Integer> circuit;
	
	public Graph(int size) {
		vertexList = new LinkedList[size];
		visited = new boolean[size];
		stack = new Stack<Integer>();
		circuit = new ArrayList<Integer>();
		
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
	public void traversal() {
		int oddEdges = 0;
		
		for(int i=0; i < vertexList.length; i++) {
			
			int edges = vertexList[i].size();
			
			if(edges == 0) {
				System.out.println("Is not Eulerian");
			}
			
			if(edges % 2 != 0) {
				oddEdges++;
			}
		}
		
		if(oddEdges == 0) {
			System.out.print("Eulerian Cycle:\n\n");
			eulerianCycle(0);
			
			
			System.out.print(circuit.get(circuit.size() -1) + "");
			for(int i = circuit.size() -2; i >= 0; i--) {
				System.out.print(" -> "+circuit.get(i));
			}
			
		}else if(oddEdges == 2) {
			System.out.println("Eulerian Path");
			
		}else {
			System.out.println("Is not Eulerian");
		}
	}
	
	public void eulerianCycle(Integer currentVertex) {
		
		LinkedList<Integer> edges = vertexList[currentVertex];
		Iterator<Integer> iterator = edges.listIterator();
		
		if(iterator.hasNext()) {
			stack.push(currentVertex);
			Integer nextVertex = iterator.next();
			edges.remove(nextVertex);
			vertexList[nextVertex].remove(currentVertex);
			eulerianCycle(nextVertex);
		}else if(!stack.isEmpty()){
			Integer vertexFromStack = stack.pop();
			circuit.add(currentVertex);
			
			if(!stack.isEmpty()) {
				eulerianCycle(vertexFromStack);
			}else {
				circuit.add(vertexFromStack);
			}
		}
		
	}
}
