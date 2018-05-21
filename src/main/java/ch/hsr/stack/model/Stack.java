package ch.hsr.stack.model;

import ch.hsr.adv.lib.stack.logic.domain.ADVStack;
import ch.hsr.adv.lib.stack.logic.exceptions.EmptyStackException;

public class Stack<T> implements ADVStack<T> {

    private Node<T> top;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T top() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException(
                    "Could not get top of stack because stack is empty.");
        }
        return top.getElement();
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<T>(element);
        newNode.appendNode(top);
        top = newNode;
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException(
                    "Could not remove top of stack because stack is empty.");
        }
        Node<T> topNode = top;
        top = topNode.getNext();
        size--;
        return topNode.getElement();
    }

    @Override
    public String toString() {
        return "[ top: " + top + " (size: " + size + ")]";
    }

    /**
     * Nodes of a simple linked list.
     */
    private class Node<E> {

        private E element;
        private Node<E> next;

        /**
         * Constructs a new unlinked node.
         *
         * @param elem Element for the node.
         */
        public Node(E elem) {
            element = elem;
            next = null;
        }

        /**
         * Adds the node next to this node.
         *
         * @param next The next node.
         */
        public void appendNode(Node<E> next) {
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public E getElement() {
            return element;
        }

        @Override
        public String toString() {
            return "" + element;
        }
    }

}
