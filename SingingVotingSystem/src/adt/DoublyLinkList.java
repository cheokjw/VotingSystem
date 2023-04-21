package adt;

// Name : Ong Tzi Min
// Student ID : 21WMR12541


public class DoublyLinkList<T extends Comparable<T>> implements DoublyLinkListInterface<T> {

    private DllNode head;
    private DllNode tail;
    private int size = 0;

    private class DllNode {
        private DllNode prev;
        private DllNode next;
        private T data;

        private DllNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        private DllNode(T data, DllNode next) {
            this.data = data;
            this.next = next;
            this.prev = null;
        }

        private DllNode(T data, DllNode next, DllNode prev ) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(T newEntry){
        DllNode n = new DllNode(newEntry); // create new node(n)

        if (newEntry == null){                  // check if newEntry is null
            return false;                       // if empty, false indicates
        }

        if (isEmpty()){                         // check if the list is empty
            head = n;
            tail = n;
            head.prev = null;
            tail.next = null;
        }else{
            DllNode currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = n;
            n.prev = currentNode;
            tail = n;
        }
        this.size++;
        return true;
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public boolean remove(T entry){
        DllNode currentNode = head;              // create a pointer
        if (entry == null || isEmpty() || contains(entry)== false) {       // return null if the entry is null or the list is empty
            return false;
        }
        // remove targeted voter object
        while (currentNode != null) {                                       // while pointer not null
            if (currentNode.data.compareTo(entry) == 0) {                   // if the currentNode data = targeted node data
                if (currentNode.next == null && currentNode == head){       // if current node is the only node in link
                    head = null;
                    tail = null;
                } else if (currentNode== head) {                           // check if current node is the firstNode in list(current and prev(null) same object)
                    head = currentNode.next;                               // remove the node at beginning
                    currentNode.next.prev = null;
                    currentNode.next = null;
                } else if (currentNode == tail) {                          // check if current node is last node in list
                    tail = currentNode.prev;
                    currentNode.prev.next = null;
                    currentNode.prev = null;
                } else {
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                size--;
                return true;
            }

            currentNode = currentNode.next;
        }
        return false;
    }

    //search if the entry is inside in the list
    @Override
    public boolean contains(T entry) {
        if (entry == null || isEmpty()) {
            return false;
        }
        DllNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.compareTo(entry) == 0) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }


    @Override       // check if the list is empty
    public boolean isEmpty(){
        return this.size == 0;
    };

//    @Override
//    public T getEntry(T entry){     // get the entry in the list
//        if (entry == null || isEmpty()) {
//            return null;
//        }
//
//        DllNode currentNode = head;
//
//        while (currentNode != null) {
//            if (currentNode.data.compareTo(entry) == 0) {
//                return currentNode.data;
//            }
//            currentNode = currentNode.next;
//        }
//
//        return null;
//    }


    @Override
    public T getEntry(int index) {
        if (index < 1 || index > size || isEmpty()) {
            return null;
        }

        DllNode currentNode = head;
        int currentIndex = 1;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return (T) currentNode.data;
    }

    @Override
    public void sort() {
        if (isEmpty()) {
            return;
        }

        DllNode currentNode = head.next;

        while (currentNode != null) {
            T currentData = currentNode.data;
            DllNode previousNode = currentNode.prev;

            while (previousNode != null && previousNode.data.compareTo(currentData) > 0) {
                previousNode.next.data = previousNode.data;
                previousNode = previousNode.prev;
            }

            if (previousNode == null) {
                head.data = currentData;
            } else {
                previousNode.next.data = currentData;
            }

            currentNode = currentNode.next;
        }
    }

    // under display voter driver use this !!!
    @Override
    public String printAscending(){
        if(isEmpty()){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        DllNode currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.data);
            sb.append(", ");
            currentNode = currentNode.next;
        }
        return sb.toString();
    }

    @Override
    public String printDescending(){
        if(isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        DllNode currentNode = tail;
        while (currentNode != null) {
            sb.append(currentNode.data);
            sb.append(", ");
            currentNode = currentNode.prev;
        }
        return sb.toString();
    }
}





// dk how to use
//    public DoublyLinkList<T>.Node getTail();
//    public String printAscending();
//    public String printDescending();


//    public DllNode<T> getTail() {
//        DllNode<T> current = next;
//        while (current.next != null) {
//            current = current.next;
//        }
//        return current;
//    }


