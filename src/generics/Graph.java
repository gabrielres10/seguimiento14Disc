package generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T> {
	private ArrayList<Vertex<T>> vertices;
	private ArrayList<Edge<T>> edges;
	private int time;

	public Graph(T value) {
		this.vertices = new ArrayList<>();
		this.edges = new ArrayList<>();
		this.vertices.add(new Vertex<T>(value));
	}

	public void BFS(Vertex<T> s) {
		for (Vertex<T> u : vertices) {
			u.setColor(Color.WHITE);
			u.setDistance(Integer.MAX_VALUE);
			u.setFather(null);
		}
		s.setColor(Color.GRAY);
		s.setDistance(0);
		s.setFather(null);
		Queue<Vertex<T>> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			Vertex<T> u = q.remove();
			for (Vertex<T> v : u.getAdjacencyList()) {
				if (v.getColor().equals(Color.WHITE)) {
					v.setColor(Color.GRAY);
					v.setDistance(u.getDistance() + 1);
					v.setFather(u);
					q.remove(v);
				}
			}
			u.setColor(Color.BLACK);
		}
	}

	public void DFS() {
		for (Vertex<T> u : vertices) {
			u.setColor(Color.WHITE);
			u.setFather(null);
		}
		setTime(0);
		for (Vertex<T> u : vertices) {
			if (u.getColor().equals(Color.WHITE)) {
				DFSVisit(u);
			}
		}
	}

	private void DFSVisit(Vertex<T> u) {
		// TODO Auto-generated method stub
		time++;
		u.setDistance(time);
		u.setColor(Color.GRAY);
		for (Vertex<T> v : u.getAdjacencyList()) {
			if (v.getColor() != null && v.getColor().equals(Color.WHITE)) {
				v.setFather(u);
				DFSVisit(v);
			}
		}
		u.setColor(Color.BLACK);
		time++;
		u.setFinalTime(time);
	}

	public void iterativeDFS() {

		for (Vertex<T> u : vertices) {
			u.setColor(Color.WHITE);
			u.setFather(null);
		}

		time = 0;
		for (Vertex<T> u : vertices) {
			if (u.getColor().equals(Color.WHITE)) {
				time++;
				u.setDistance(time);
				u.setColor(Color.GRAY);
				for (Vertex<T> v : u.getAdjacencyList()) {
					if (v.getColor() != null && v.getColor().equals(Color.WHITE)) {
						v.setFather(u);
						u = v;
						break;
					}
				}
				u.setColor(Color.BLACK);
				time++;
				u.setFinalTime(time);
			}
		}
	}
	
	public void search(T value){
		
	}
	
	public void printColors(){
		for(Vertex<T> v : vertices) {
			System.out.println(v.getColor());
		}
	}

	/**
	 * @return the vertices
	 */
	public ArrayList<Vertex<T>> getVertices() {
		return vertices;
	}

	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(ArrayList<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	/**
	 * @return the edges
	 */
	public ArrayList<Edge<T>> getEdges() {
		return edges;
	}

	/**
	 * @param edges the edges to set
	 */
	public void setEdges(ArrayList<Edge<T>> edges) {
		this.edges = edges;
	}

	public void newEdge(T inputVertex, T outputVertex) {
		System.out.println("adding " + inputVertex + " -> " + outputVertex);
		Vertex<T> a = new Vertex<>(inputVertex);
		Vertex<T> b = new Vertex<>(outputVertex);
		if (existsVertex(a)) {
			if (existsVertex(b)) {
				if (!existsEdge(a, b)) {
					updateAdjacencyList(a,b);
					a.getAdjacencyList().add(b);
					edges.add(new Edge<T>(a, b));
				}
			} else {
				edges.add(new Edge<T>(a, b));
				updateAdjacencyList(a,b);
				a.getAdjacencyList().add(b);
				vertices.add(b);
			}
		} else {
			a.getAdjacencyList().add(b);
			if (existsVertex(b)) {
				vertices.add(a);
				edges.add(new Edge<T>(a, b));
			} else {
				vertices.add(a);
				vertices.add(b);
				edges.add(new Edge<T>(a, b));
			}
		}
	}
	
	/**
	 * This method checks if a vertex with a value exists
	 * @param a, vertex to be checked
	 * @return true, if the vertex exists, false otherwise
	 */
	public boolean existsVertex(Vertex<T> a) {
		for(Vertex<T> v : vertices) {
			if(v.getValue() != null)
			if(v.getValue().equals(a.getValue())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks if an edge exists
	 * 
	 * @param a, this is the input vertex
	 * @param b, this is the output vertex
	 * @return true, if the edge exists, false otherwise
	 */
	public boolean existsEdge(Vertex<T> a, Vertex<T> b) {
		for (Edge<T> e : edges) {
			if (e.getInputVertex().getValue().equals(a.getValue()) && e.getOutputVertex().getValue().equals(b.getValue())) {
				return true;
			}
		}
		return false;
	}
	
	public void addVertex(T value) {
		if(!existsVertex(new Vertex<T>(value))) {
			this.vertices.add(new Vertex<T>(value));
		}
	}
	
	
	public void updateAdjacencyList(Vertex<T> inputVertex, Vertex<T> outputVertex) {
		for(Vertex<T> v : vertices) {
			if(v.getValue().equals(inputVertex.getValue())) {
				v.getAdjacencyList().add(outputVertex);
				return;
			}
		}
	}
	
	/**
	 * This method returns the exact vertex of the vertices array by searching its value
	 * @param value, this is the value of the vertex
	 * @return (T) Vertex, this is the vertex 
	 */
	public Vertex<T> findVertex(T value){
		for(Vertex<T> v : vertices) {
			if(v.getValue().equals(value)) {
				return v;
			}
		}
		return null;
	}
	
	/**
	 * This method gets an output vertex given the value of its input vertex
	 * 
	 * @param inputValue, T, this is the Value of the input vertex
	 * @return (T) Vertex, this is the output vertex according to the input vertex
	 */
	public Vertex<T> get(T inputValue) {
		for (Edge<T> edges : this.edges) {
			if (inputValue.equals(edges.getInputVertex().getValue())) {
				return edges.getOutputVertex();
			}
		}
		return null;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

}
