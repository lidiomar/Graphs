package br.com.paa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	
	private LinkedList<Integer> vertexList[];
	private Stack<Integer> stack;
	private ArrayList<Integer> circuit;
	
	public Graph(int size) {
		vertexList = new LinkedList[size]; // O(1) 
		stack = new Stack<Integer>();
		circuit = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i ++) { // O(n)
			vertexList[i] = new LinkedList<Integer>(); // O(1)
		}
	}
	
	public void addEdge(int vertex, int edge) {
		vertexList[vertex].add(edge); // O(1)
	}
	
	/*Complexidade O(n), 
	onde n é o número de vértices */
	public void traversal() {
		
		for(int i=0; i < vertexList.length; i++) { // O(n)		
			int edges = vertexList[i].size();		
			if(edges == 0) {
				System.out.println("Is not Eulerian");
				return;
			}
			
			if(edges % 2 != 0) {
				System.out.println("Is not Eulerian Cycle");
				return;
			}
		}
		
		System.out.println("Eulerian Cycle Stack O(n):\n\n");
		eulerianCycle(0);
		
		System.out.print(circuit.get(circuit.size() -1) + "");
		
		for(int i = circuit.size() -2; i >= 0; i--) {
			System.out.print(" -> "+circuit.get(i));
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
	
	/*Complexidade O(n), 
	onde n é o número de vértices */
	public void traversal2() {
		for(int i=0; i < vertexList.length; i++) { // O(n)
			int edges = vertexList[i].size();
			
			if(edges == 0) {
				System.out.println("Is not Eulerian");
				return;
			}
			
			if(edges % 2 != 0) {
				System.out.println("Is not Eulerian Cycle");
				return;
			}
		}
		
		System.out.println("\n\nEulerian Cycle Ordem Decrescente O(n):\n\n");
		eulerianCycle2(0);
		
		System.out.print(circuit.get(0) + "");
		
		for(int i = 1; i < circuit.size(); i++) {
			System.out.print(" -> "+circuit.get(i));
		}
	}
	
	public void eulerianCycle2(Integer currentVertex) {
		LinkedList<Integer> edges = vertexList[currentVertex];
		Iterator<Integer> iterator = edges.listIterator();
		circuit.add(currentVertex);
		
		if(iterator.hasNext()) {	
			Integer nextVertex = iterator.next();
			edges.remove(nextVertex);
			vertexList[nextVertex].remove(currentVertex);
			
			eulerianCycle2(nextVertex);
		}
	}
	
	/*Complexidade O(n * nLogN), 
	onde n é o número de vértices */
	public void traversal3() {
		for(int i=0; i < vertexList.length; i++) { // O(n)
			int edges = vertexList[i].size();
			
			if(edges == 0) {
				System.out.println("Is not Eulerian");
				return;
			}
			
			if(edges % 2 != 0) {
				System.out.println("Is not Eulerian Cycle");
				return;
			}
		}
		
		System.out.println("\n\nEulerian Cycle lista Desordenada O(nLogN):\n\n");
		eulerianCycle3(0);
		
		System.out.print(circuit.get(0) + "");
		
		for(int i = 1; i < circuit.size(); i++) {
			System.out.print(" -> "+circuit.get(i));
		}
	}
	
	public void eulerianCycle3(Integer currentVertex) {
		LinkedList<Integer> edges = vertexList[currentVertex];
		Collections.sort(edges, Collections.reverseOrder()); //O(nLogN)
		Iterator<Integer> iterator = edges.listIterator();
		
		if(iterator.hasNext()) {
			circuit.add(currentVertex);
			Integer nextVertex = iterator.next();
			edges.remove(nextVertex);
			vertexList[nextVertex].remove(currentVertex);
			
			eulerianCycle3(nextVertex);
		}
	}
	
}
