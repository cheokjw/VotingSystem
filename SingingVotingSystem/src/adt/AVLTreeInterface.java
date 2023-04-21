package adt;

// Author     : Boo Zheng Feng
// Student ID : 21WMR12518

public interface AVLTreeInterface<T extends Comparable<T>>{
    public boolean isEmpty();

    /* Make the tree logically empty */
    public void makeEmpty();

    public void insert(T data) throws AVLTree.DuplicateElementException;

    public void remove(T data);

    public boolean contains(T data);

    /* Functions to search for an element */ boolean search(T val);

    public AVLTree.List<T> inOrderTraversal();
}
