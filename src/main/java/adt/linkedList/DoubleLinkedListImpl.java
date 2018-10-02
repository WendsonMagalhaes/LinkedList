package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;



	@Override
	public void insertFirst(T element) {

		DoubleLinkedListNode newHead = new DoubleLinkedListNode(element, null, null);
		newHead.next = this.head;
		newHead.previous = null;

		if (this.head.toString().equals("NIL")) {
			this.last = newHead;
		}
		this.head = newHead;

	}

	@Override
	public void removeFirst() {

		if (!this.head.toString().equals("NIL")) {
			this.head = this.head.next;
			if (this.head.toString().equals("NIL")) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			}

		}
	}

	@Override
	public void removeLast() {
		
			if (!this.last.toString().equals("NIL")) {
				this.last = this.last.previous;

				if (last.toString().equals("NIL")) {
					this.head = this.last;
				}

				this.last.next = null;
			}
		}
	

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
