package generics;

public class Edge<T> {
	private Vertex<T> inputVertex;
	private Vertex<T> outputVertex;
	 
	public Edge(Vertex<T> inputVertex, Vertex<T> outputVertex){
		this.inputVertex = inputVertex;
		this.outputVertex = outputVertex;
	}

	/**
	 * @return the inputVertex
	 */
	public Vertex<T> getInputVertex() {
		return inputVertex;
	}

	/**
	 * @param inputVertex the inputVertex to set
	 */
	public void setInputVertex(Vertex<T> inputVertex) {
		this.inputVertex = inputVertex;
	}

	/**
	 * @return the outputVertex
	 */
	public Vertex<T> getOutputVertex() {
		return outputVertex;
	}

	/**
	 * @param outputVertex the outputVertex to set
	 */
	public void setOutputVertex(Vertex<T> outputVertex) {
		this.outputVertex = outputVertex;
	}
	
	
}
