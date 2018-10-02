package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		
		if(this.head.isNIL()) {
			result = true;
		}
		return result;
	}

	@Override
	public int size() {
		
		int size = 0;
		SingleLinkedListNode<T> aux = this.head;
		
		while(!aux.toString().equals("NIL")) {
			size ++;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		
		SingleLinkedListNode<T> auxHead = this.head;
		
		while(!auxHead.toString().equals("NIL") && auxHead.data !=element) {
			auxHead = auxHead.next;
		}
		return auxHead.data;
	}

	@Override
	public void insert(T element) {
		
		SingleLinkedListNode<T> auxHead = this.head;
		
		if(this.head.toString().equals("NIL")) {
			SingleLinkedListNode newHead = new SingleLinkedListNode(element, null);
			newHead.next = this.head;
			this.head = newHead;
		}else {
			while(!auxHead.next.toString().equals("NIL")) {
				auxHead = auxHead.next;
			}
			SingleLinkedListNode newNode = new SingleLinkedListNode(element, null);
			newNode.next = auxHead.next;
			auxHead.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		
		SingleLinkedListNode<T> aux = null;
		SingleLinkedListNode<T>previous = aux;
		
		if(this.head.data == element) {
			this.head = this.head.next;
		} else {
			 aux = this.head;
			while(!aux.toString().equals("NIL") && aux.data != element) {
				previous = aux;
				aux = aux.next;
			}
			if (!aux.toString().equals("NIL")) {
				
				previous.next = aux.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Comparable[this.size()];
		SingleLinkedListNode<T> aux = this.head;
		int count = 0;
		
		while (!aux.toString().equals("NIL")) {
			result[count] = aux.data;
			aux = aux.next;
			count ++;
		}
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
