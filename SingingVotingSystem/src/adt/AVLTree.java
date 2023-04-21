package adt;

import java.lang.RuntimeException;

// Author     : Boo Zheng Feng
// Student ID : 21WMR12518
public class AVLTree<T extends Comparable<T>> implements AVLTreeInterface<T> {
    public interface List<T> {
        public void add(T element);
        public int size();
        public T get(int index);
    }

    public class ArrayList<T> implements List<T> {
        private T[] array;
        private int size;

        public ArrayList() {
            array = (T[]) new Object[10];
            size = 0;
        }

        public void add(T element) {
            if (size == array.length) {
                T[] newArray = (T[]) new Object[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    newArray[i] = array[i];
                }
                array = newArray;
            }
            array[size] = element;
            size++;
        }

        public int size() {
            return size;
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return array[index];
        }
    }
    private class Node {
        T data;
        int height;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    @Override
    public boolean isEmpty()
    {
        return root == null;
    }

    @Override
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        root = null;
    }

    @Override
    public void insert(T data) throws DuplicateElementException{
        if (contains(data)) {
            throw new DuplicateElementException("[ " + data.toString() + " ] have existed !");
        }

        root = insert(root, data);
    }

    public static class DuplicateElementException extends RuntimeException {
        public DuplicateElementException(String message) {
            super(message);
        }
    }
    private Node insert(Node node, T data) {
        if (node == null) {
            return new Node(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && data.compareTo(node.left.data) < 0) {
            return rightRotate(node);
        }

        if (balance < -1 && data.compareTo(node.right.data) > 0) {
            return leftRotate(node);
        }

        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    @Override
    public void remove(T data) {
        if (!contains(data)) {
            // data does not exist in tree, do not remove
            return;
        }

        root = remove(root, data);
    }

    private Node remove(Node node, T data) {
        if (node == null) {
            return null;
        }

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {
            node.left = remove(node.left, data);
        } else if (cmp > 0) {
            node.right = remove(node.right, data);
        } else {
            // node to be deleted found

            if (node.left == null || node.right == null) {
                // node has at most one child
                Node temp = null;

                if (node.left == null) {
                    temp = node.right;
                } else {
                    temp = node.left;
                }

                if (temp == null) {
                    // node is a leaf node
                    temp = node;
                    node = null;
                } else {
                    // node has one child
                    node = temp;
                }
            } else {
                // node has two children
                Node temp = getMinValueNode(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
        }

        if (node == null) {
            return null;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    @Override
    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.data) < 0) {
            return contains(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            return contains(node.right, data);
        } else {
            return true;
        }
    }

    @Override
    /* Functions to search for an element */
    public boolean search(T val)
    {
        return search(root, val);
    }

    private boolean search(Node r, T val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            T rval = r.data;
            if (val.compareTo(rval) < 0)
                r = r.left;
            else if (val.compareTo(rval) > 0)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    @Override
    public List<T> inOrderTraversal() {
        List<T> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(Node node, List<T> list) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, list);
        list.add(node.data);
        inOrderTraversal(node.right, list);
    }

    private Node getMinValueNode(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }
}
