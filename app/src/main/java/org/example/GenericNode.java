package org.example;

public class GenericNode<T> {
    T data;
    GenericNode next;

    public GenericNode(T data)
    {
        this.data = data;
        this.next = null;
    }
}