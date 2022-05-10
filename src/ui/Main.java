package ui;

import java.util.Scanner;

import generics.Graph;

public class Main {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		// TODO Auto-generated method stub
		/*Graph<String> graph = new Graph<String>("U");
		System.out.println(1);
		graph.newEdge("U", "X");
		System.out.println(2);
		graph.newEdge("X", "Y");
		System.out.println(3);
		graph.newEdge("Y", "Z");
		System.out.println(4);
		graph.newEdge("Z", "Y");
		System.out.println(5);
		graph.newEdge("Y", "V");
		System.out.println(6);
		graph.newEdge("V", "U");
		
		ArrayList<Edge<String>> edges = graph.getEdges();
		graph.printColors();
		System.out.println("Edges quant: " + edges.size());
		graph.iterativeDFS();
		graph.printColors();*/
		System.out.println("Ingrese el primer valor (String) de su grafo");
		Graph<String> newGraph = new Graph<>(sc.next());
		int ans = 0;
		do{
			System.out.println("Desea agregar un nodo o una arista? (escoga 0 si no desea agregar más)"+
					"\n 1. Nodo"+
					"\n 2. Arista"+
					"\n 0. --terminar--");
			ans = sc.nextInt();
			switch(ans) {
				case 1:
					String node = sc.next();
					newGraph.addVertex(node);
					break;
				case 2: 
					String a = sc.next();
					String b = sc.next();
					newGraph.newEdge(a,b);
					break;
				default:
					ans = 0;
			}
		}while(ans != 0);
	}

}
