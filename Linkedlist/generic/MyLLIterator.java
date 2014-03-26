import java.util.*;

public class MyLLIterator<T> implements Iterator<T> {
	public Node<T> currentNode;

	public MyLLIterator(Node<T> head) {
		currentNode = head.getNext();
	}

	public boolean hasNext() {
		return !(currentNode == null);
	}

	public T next() {
		if (hasNext()) {
			T n = currentNode.getData();
			currentNode = currentNode.getNext();
			return n;
		} else {
			throw new NoSuchElementException();
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}

