package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!isFull()) {
			this.top.insertFirst(element);
		} else {
			throw new StackOverflowException();

		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		T result;
		if (!isEmpty()) {
			result = this.top();
			this.top.removeLast();
		} else {
			throw new StackUnderflowException();
		}
		return result;
		}

	@Override
	public T top() {

		return this.top.toArray()[this.top.size() - 1];
	}

	@Override
	public boolean isEmpty() {

		return this.top.size() == 0;
	}

	@Override
	public boolean isFull() {

		return this.top.size() == this.size;
	}

}
