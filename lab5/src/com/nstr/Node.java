package com.nstr;

import java.io.Serializable;

public class Node<T> implements Serializable {

    private T data;
    private Node next;

    Node(T data)
    {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}