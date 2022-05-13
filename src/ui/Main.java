package ui;

import java.util.Scanner;

import generics.Graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
/* Caso de prueba (Mismo del enunciado del seguimiento)
			U
			2
			U
			X
			2
			X
			Y
			2
			Y
			V
			2
			V
			U
			2
			Y
			Z
			2
			Z
			Y
			0

*/
		
		
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
		
		System.out.println("\n\n Por BFS: ");
		if(newGraph.BFS(newGraph.getFirstValue())) {
            System.out.println("---------Conexo--------");
        }else {
            System.out.println("---------No conexo--------");
        }
		
		System.out.println(" Por DFS: ");
		if(newGraph.DFS()) {
            System.out.println("---------Conexo--------");
        }else {
            System.out.println("---------No conexo--------");
        }

	}

}
