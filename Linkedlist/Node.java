public class Node {
	private String data;
	private Node next;

	public Node(String data) {
		this.data = data;
	}

	public Node(String data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	public String getData() {
		return data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String toString() {
		return data;
	}
}
