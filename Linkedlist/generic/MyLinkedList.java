import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {
	private Node<T> head;
	private int length;

    public MyLinkedList(){
		head = new Node<T>(null);
		length = 0;
    }

	public Iterator<T> iterator() {
		return new MyLLIterator<T>(head);
	}

	public Node<T> getNode(int position) {
		if (position < -1 || position >= length)
			throw new IndexOutOfBoundsException("index out of bounds\nLength: " + length +
													" Position: " + position);

		return getNode(position, head);
	}

	public Node<T> getNode(int position, Node<T> node) {
		if (position == -1)
			return node;
		else if (position == 0)
			return node.getNext();
		else
			return getNode(position-1, node.getNext());
	}

    public void add(T s){
		Node<T> tmp = new Node<T>(s);
		tmp.setNext(head.getNext());
		head.setNext(tmp);
		length++;
    }

	public void add(T s, int position) {

		// throw exception if index is out of bounds
		if (position > length)
			throw new IndexOutOfBoundsException("index out of bounds\nLength: " + length + 
													" Position: " + position);
		// keep track of length
		length++;

		// create a pointer to the node before the indexed position
		Node<T> tmp = getNode(position-1);

		// move tmp2 to node at index position
		Node<T> tmp2 = tmp.getNext();

		// initiate new Node
		Node<T> newNode = new Node<T>(s);

		// point newNode to correct next node
		newNode.setNext(tmp2);

		// point previous node to tmp
		tmp.setNext(newNode);
	}

	public T get(int position) {
		return getNode(position).getData();
	}

	public void set(int position, T newString) {
		getNode(position).setData(newString);
	}

	public void remove(int position) {
		if (position < 0 || position >= length)
			throw new IndexOutOfBoundsException("index out of bounds\nLength: " + length +
													" Position: " + position);

		// keep track of length
		length--;

		// create tmp to avoid calling getNode() O(n) twice
		Node<T> tmp = getNode(position-1);

		// set tmp to two nodes in front of the current node
		tmp.setNext(tmp.getNext().getNext());
	}


	public int find(T s) {
		Node<T> tmp = head.getNext();
		int index = -1;
		int i = 0;

		// iterate through the list
		// if it is equal, set to the correct index and stop the loop
		while (tmp != null) {
			if (s.equals(tmp.getData())) {
				index = i;
				break;
			}
			i++;
			tmp = tmp.getNext();
		}

		return index;
	}

    public String toString(){
		// return empty brackets if LinkedList is empty
		if (length == 0)
			return "[]";

		// initialize string to build on
		String s="[";
		// create temporary pointer to help build string
		Node<T> tmp = head.getNext();

		// iterate through and add the data to the string
		while (tmp != null) {
			s += tmp.getData() + ", ";
			tmp = tmp.getNext();
		}

		// take away the extra comma and space and add the end bracket
		return s.substring(0, s.length()-2) + "]";
    }

	public int length() {
		return length;
	}

	public static void main(String[] args) {
		MyLinkedList<Integer> L = new MyLinkedList<Integer>();

		L.add(1, 0);
		L.add(2, L.length());
		L.add(3, L.length());
		System.out.println(L);
	}
}
