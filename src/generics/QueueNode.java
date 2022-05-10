package generics;

public class QueueNode<T> {

	private QueueNode <T> next;
	
	private T value;
	
	private int index = -1;
	
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Constructor that use the value of node
	 * @param value, T, value of node
	 */
	public QueueNode(T value){
		this.value = value;
		this.index++;
	}
	
	/**
	 * Empty Constructor
	 */
	public QueueNode() {}

	/**
	 * @return the next
	 */
	public QueueNode<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(QueueNode<T> next) {
		this.next = next;
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
}