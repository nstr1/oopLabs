package com.nstr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericLinkedList<T> implements Iterable<T>, Serializable {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(T data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            setHead(newNode);
        } else {
            Node last = getHead();
            while (last.getNext() != null) {
                last = last.getNext();
            }

            last.setNext(newNode);
        }
    }

    public void delete(int index)
    {
        Node current = head;
        for(int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        current.setNext((current.getNext()).getNext());
    }

    public ArrayList<T> toArray()
    {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;

        do
        {
            list.add((T) current.getData());
        }while(current.getNext() != null);

        return list;
    }

    public void clear()
    {
        head.setData(null);
        head.setNext(null);
    }

    boolean check(T data)
    {
        int i = 1;
        Node current = head;

        do
        {
            if(current.getData() == data)
            {
                System.out.println("Found at [" + i + "]");
            }
            i++;
        } while(current.getNext() != null);
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();

        Node current = head;
        int i = 1;

        do
        {
            string.append("\n").append(i).append(":\n");
            string.append(current.getData());
            current = current.getNext();
            i++;
        } while (current != null);

        return string.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

}
