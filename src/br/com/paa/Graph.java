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
		vertexList = new LinkedList[size]; // O(1)
		visited = new boolean[size]; 
		stack = new Stack<Integer>();
		circuit = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i ++) { // O(n)
			vertexList[i] = new LinkedList<Integer>(); // O(1)
		}
	}
	
	public void addEdge(int vertex, int edge) {
		vertexList[vertex].add(edge); // O(1)
	}
	
	
	public void traversal() {
		int odd = 0;
		for(int i=0; i < vertexList.length; i++) {
			
			int edges = vertexList[i].size();
			
			if(edges == 0) {
				System.out.println("Is not Eulerian");
				return;
			}
			
			if(edges % 2 != 0) {
				odd++;
			}
		}
		
		if(odd > 2) {
			System.out.println("\n\nIs not Eulerian\n\n");
		}else if(odd == 2) {
			System.out.println("\n\nIs Eulerian path\n\n");
		}else {
			System.out.print("\n\nEulerian Cycle:\n\n");
		}
		eulerianCycle(0);
		
		System.out.print(circuit.get(circuit.size() -1) + "");
		
		for(int i = circuit.size() -2; i >= 0; i--) {
			System.out.print(" -> "+circuit.get(i));
		}
	}
	/*Complexidade O(n), 
	onde n é o número de vértices */
	public void eulerianCycle(Integer currentVertex) {
		
		LinkedList<Integer> edges = vertexList[currentVertex];
		Iterator<Integer> iterator = edges.listIterator();
		
		if(iterator.hasNext()) {
			stack.push(currentVertex); //O(1)
			Integer nextVertex = iterator.next();
			edges.remove(nextVertex);
			vertexList[nextVertex].remove(currentVertex);
			
			eulerianCycle(nextVertex);
		}else if(!stack.isEmpty()){
			Integer vertexFromStack = stack.pop(); //O(1)
			circuit.add(currentVertex);
			
			if(!stack.isEmpty()) {
				eulerianCycle(vertexFromStack);
			}else {
				circuit.add(vertexFromStack);
			}
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
	
}
