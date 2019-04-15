package com.nstr;

import java.io.Serializable;
import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<Node>, Serializable {
    private Node current;

    LinkedListIterator(Node head) {this.current = head; }

    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public Node next() {
        Node res = current.getNext();
        current = current.getNext();
        return res;
    }
}
