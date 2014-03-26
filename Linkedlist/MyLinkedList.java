import java.util.Random;

public class MyLinkedList {
	private Node head;
	private int length;

    public MyLinkedList(){
		head = new Node("head");
		length = 0;
    }

	public Node getNode(int position) {
		if (position < 0 || position >= length)
			throw new IndexOutOfBoundsException("index out of bounds\nLength: " + length +
													"Position: " + position);

		return getNode(position, head);
	}

	public Node getNode(int position, Node node) {
		if (position == 0)
			return node.getNext();
		else
			return getNode(position-1, node.getNext());
	}

    public void add(String s){
		Node tmp = new Node(s);
		tmp.setNext(head.getNext());
		head.setNext(tmp);
		length++;
    }

	public void add(String s, int position) {

		// throw exception if index is out of bounds
		if (position >= length)
			throw new IndexOutOfBoundsException("index out of bounds\nLength: " + length + 
													"Position: " + position);
		// keep track of length
		length++;

		// create a pointer to the node before the indexed position
		Node tmp = getNode(position-1);

		// move tmp2 to node at index position
		Node tmp2 = tmp.getNext();

		// initiate new Node
		Node newNode = new Node(s);

		// point newNode to correct next node
		newNode.setNext(tmp2);

		// point previous node to tmp
		tmp.setNext(newNode);
	}

	public String get(int position) {
		return getNode(position).getData();
	}

	public void set(int position, String newString) {
		getNode(position).setData(newString);
	}

	public void remove(int position) {
		if (position < 0 || position >= length)
			throw new IndexOutOfBoundsException("index out of bounds\nLength: " + length +
													"Position: " + position);

		// keep track of length
		length--;

		// create tmp to avoid calling getNode() O(n) twice
		Node tmp = getNode(position-1);

		// set tmp to two nodes in front of the current node
		tmp.setNext(tmp.getNext().getNext());
	}


	public int find(String s) {
		Node tmp = head.getNext();
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
		Node tmp = head.getNext();

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

		// Initialize the LinkedList
		MyLinkedList L = new MyLinkedList();

		// fill the LinkedList
		for (int i = 0; i < 10; i++) {
			L.add("" + i);
		}
		// should print out [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
		System.out.println(L);

		// test getNode method
		System.out.println(L.getNode(3));


		// test add method
		L.add("a", 3);
		// should print out [9, 8, 7, a, 6, 5, 4, 3, 2, 1, 0]
		System.out.println(L);


		// test get method
		// should print out a
		System.out.println(L.get(3));


		// test set method
		L.set(3, "b");
		// should print out [9, 8, 7, b, 6, 5, 4, 3, 2, 1, 0]
		System.out.println(L);


		// test remove method
		L.remove(3);
		// should print out [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
		System.out.println(L);


		// test find method
		int a = L.find("0");
		// should print out 9
		System.out.println(a);
	}
}
