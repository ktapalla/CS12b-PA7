import java.util.ArrayList;


public class IDLList<E> {

	/**
	 * @param <E> - element parameter 
	 * Node Inner Class 
	 */
	class Node<E> {
		
		/**
		 * Node class fields
		 */
		E data; 
		Node<E> next, prev;

		/**
		 * @param elem - data element 
		 * - Class Constructor creating a node with elem 
		 */
		Node (E elem) {
			this.data = elem;
			this.next = null;
			this.prev = null;
		}

		/**
		 * @param elem - data element 
		 * @param prev - previous node 
		 * @param next - next node 
		 * - Class Constructor creating a node with elem, prev, next 
		 */
		Node (E elem, Node<E> prev, Node<E> next) {
			this.data = elem; 
			this.prev = prev; 
			this.next = next;
		}
	}

	/**
	 * IDLList class fields
	 */
	Node<E> head, tail, node; 
	int size;
	ArrayList< Node<E> > indices;

	/**
	 * Class Constructor - creates an empty double-linked list 
	 */
	public IDLList() {
		this.indices = new ArrayList<Node<E>>();
		this.size = 0;
		this.head = null;
		this.tail = null;
		this.node = null;
	}
	

	/**
	 * @param index - position index 
	 * @param elem - element parameter 
	 * @return - returns true 
	 * - Adds elem at position index 
	 */
	public boolean add(int index, E elem) {
		//If adding anywhere between head and tail
		if (index > 0 && index < this.size) {
			this.node = new Node<E>(elem, this.indices.get(index-1), this.indices.get(index)); 
			this.indices.get(index).prev = this.node;
			this.indices.get(index-1).next = this.node;
			this.indices.add(index, this.node);
			this.size++;
		}
		//If adding at the head
		else if(index == 0) {
			this.add(elem);
		}
		//If adding at the tail
		else if(index == this.size) {
			this.append(elem);
		}
		return true;
	}
	

	/**
	 * @param elem - element parameter 
	 * @return - returns true 
	 * - Adds elem at head 
	 */
	public boolean add(E elem) {
		this.node = new Node<E>(elem);
		//If the list is empty 
		if (this.size == 0) {
			this.head = this.node;
			this.tail = this.node;
		}
		else {
			this.node.next = this.head;
			this.head.prev = this.node;
			this.head = this.node;	
		}
		this.indices.add(0, this.head);
		this.size++;
		return true;
	}
	
	
	/**
	 * @param elem - element parameter 
	 * @return - returns true 
	 * - Adds elem at the tail 
	 */
	public boolean append(E elem) {
		//If the list is empty
		if(this.size == 0) {
			this.node = new Node<E>(elem);
			this.head = this.node;
			this.tail = this.node;
		}
		else {
			this.node = new Node<E>(elem, this.tail, null);
			this.tail.next = this.node;
			this.tail = this.node;
		}
		this.indices.add(this.tail);
		this.size++;
		return true;
	}
	
	
	/**
	 * @param index - position index 
	 * @return - returns E object  
	 * - Returns the object/data at position index 
	 */
	public E get(int index) {
		return this.indices.get(index).data;
	}
	
	
	/**
	 * @return - returns E object 
	 * - Returns the object/data at the head 
	 */
	public E getHead() {
		return this.head.data;
	}
	
	
	/**
	 * @return - returns E object 
	 * - Returns the object/data at the tail  
	 */
	public E getLast() {
		return this.tail.data;
	}
	
	
	/**
	 * @return - returns integer value 
	 * - Returns the list size   
	 */
	public int size() {
		return this.size;
	}
	

	/**
	 * @return - returns E object 
	 * - Removes and returns element at the head 
	 */
	public E remove() {
		//If list isn't empty
		if (this.size > 0) {
			//If there is more than one object
			if (this.size > 1) {
				this.node = this.head;
				this.head = this.indices.get(1); 
				this.head.prev = null;
				
			}
			//If there is only one object
			else if(this.size == 1) {
				this.node = this.head;
				Node<E> eNode = new Node<E>(null, null, null);
				this.head = eNode;
				this.tail = eNode;
			}
			this.indices.remove(0);
			this.size--;
		}
		return this.node.data;
	}
	
	
	/**
	 * @return - returns E object 
	 * - Removes and returns element at the tail
	 */
	public E removeLast() {
		//If list isn't empty
		if (this.size > 0) {
			//If there is more than one object
			if(this.size > 1) {
				this.node = this.tail;
				this.tail = this.indices.get(this.size-2);
				this.tail.next = null;
				this.indices.remove(this.size-1);
			}
			//If there is only one object
			else if(this.size == 1) {
				this.node = this.tail;
				Node<E> eNode = new Node<E>(null, null, null);
				this.head = eNode;
				this.tail = eNode;
				this.indices.remove(this.size-1);
			}
			this.size--;
		}
		return this.node.data;
	}
	

	/**
	 * @index - position index 
	 * @return - returns E object 
	 * - Removes and returns element at position index 
	 */
	public E removeAt(int index) {
		//If removing anywhere between the head and tail
		if (index > 0 && index < this.size-1) {
			this.node = this.indices.get(index);
			this.indices.get(index+1).prev = this.indices.get(index-1);
			this.indices.get(index-1).next = this.indices.get(index+1);
			this.indices.remove(index);
			this.size--;
		}
		//If removing the head
		else if(index == 0) {
			this.node.data = remove();
		}
		//If removing the tail
		else if(index == this.size-1) {
			this.node.data = removeLast();
		}
		return this.node.data;
	}
	
	/**
	 * @param elem - element parameter 
	 * @return - returns true or false 
	 * - Removes first occurence of elem in the list 
	 * - Returns true if elem is in the list, false if not in the list
	 */
	public boolean remove(E elem) {
		//Goes through entire list 
		for(int i = 0; i < this.size; i++) {
			//If elem and data match removes from position i and returns true (returning ends loop, only first occurrence removed) 
			if (this.indices.get(i).data == elem) {
				this.removeAt(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return - returns a String
	 * - Returns a string representation of the list
	 */
	public String toString() {
	 	String str = "[";
	 	for(Node<E> n : this.indices) {
	 		str += n.data.toString() + ", ";
	 	}
	 	if (str.length() > 2) {
	 		str = str.substring(0, str.length()-2);
		}
		str += "]";
		return str;
	}
}
