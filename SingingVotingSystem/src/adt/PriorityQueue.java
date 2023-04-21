package adt;

// Name : Cheok Jia Wei
// Student ID : 21WMR12521


public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T> {

    // Logs the number of elements in binary heap
    private int heapSize = 0;
    // Logs the internal capacity of the heap
    private int heapCapacity = 0;
    // Creates a heap array to keep track of the element in heap
    private T[] heap = null;


    // Constructors -------------------------------------------------------------------
    // This initializes an empty PQ using another constructor in PQ clas
    public PriorityQueue() {
        this(1);
    }

    // This initializes an empty heap list with specified capacity
    public PriorityQueue(int size){
        heap = (T[]) new Comparable[size];
        this.heapCapacity = size;
    }

    // Construct a heap with elements (Array) provided
    public PriorityQueue(T[] elements){
        // 1. Copy the array size to heap size
        heapSize = heapCapacity = elements.length;
        heap = (T[]) new Comparable[heapCapacity];

        // 2. Copy the element from array into heap
        for(int i = 0; i < heapSize; i++){
            heap[i] = elements[i];
        }

        // 3. Convert the array structure into binary heap structure.
        for (int i = Math.max(0, (heapSize/2)-1); i >= 0; i--){
            sink(i);
        }
    }

    // --------------------------------------------------------------------------------
    // Interface methods --------------------------------------------------------------
    @Override
    public boolean isEmpty(){
        return this.heapSize == 0;
    }


    @Override
    public boolean clear(){
        // Return false if the PQ is already empty
        if (isEmpty()){
            return false;
        }
        // Convert all elements in heap to null
        for (int i = 0; i < heapCapacity; i++){
            this.heap[i] = null;
        }
        // Change heapSize to 0 (Note: The capacity of heap still remains the same)
        heapSize = 0;
        return true;
    }

    @Override
    public int size(){
        return heapSize;
    }

    @Override
    public T peek(){
        if (this.isEmpty()){
            return null;
        }
        return heap[0];
    }

    @Override
    public T poll(){
        return removeAt(0);
    }


    @Override
    public boolean contains(T element) {
        boolean contain = false;

        for (int i = 0; i < heapSize; i++) {
            if (this.heap[i].equals(element)) {
                contain = true;
            }
        }

        return contain;
    }

    @Override
    public boolean update(T element){
        if (!contains(element)) return false;

        remove(element);
        add(element);
        return true;
    }

    @Override
    public boolean add(T newEntry){
        if (newEntry == null) {return false;}

        if (heapSize < heapCapacity){
            heap[heapSize] = newEntry;
        }else {
            this.heapCapacity++;
            T[] temp = (T[]) new Comparable[heapCapacity];

            for(int i = 0; i < heapSize; i++){
                temp[i] = heap[i];
            }

            heap = temp;

            heap[heapCapacity - 1] = newEntry;
        }
        // Adds the new Entry to the binary heap node following the sequence
        swim(heapSize);
        this.heapSize++;
        return true;
    }

    public T get(int i){
        if (this.isEmpty()){
            return null;
        }
        return heap[i];
    }

    private boolean more(int i, int j){
        // Checks the nodes are valid or not by comparing them
        if(heap[i] == null || heap[j]==null){
            System.out.println("BREAKKKKKK");
        }
        T node1 = heap[i];
        T node2 = heap[j];
        return node1.compareTo(node2) >= 0;
    }

    // Bottom Up approach
    private void swim(int nodeIndex){

        // Gets the index of the parent of the node
        int parent = (nodeIndex-1) / 2;

        // Keep moving (Swimming) upward of the heap until the node is not more than it's parent
        while (nodeIndex > 0 && more(nodeIndex, parent)) {
            // Change current node to
            swap(parent, nodeIndex);
            nodeIndex = parent;

            parent = (nodeIndex-1) / 2;
        }
    }

    // Top-Down approach
    private void sink(int nodeIndex){
        while(true){
            // Refer to the neighboring nodes
            int left = 2 * nodeIndex + 1;
            int right = 2 * nodeIndex + 2;
            int smallest = left; // Assume the left node is the smallest (Heap index pos theory)

            // Find left or right node is the smallest
            // Convert right node to left if right is larger than left
            if (right < heapSize && more(right, left)){
                smallest = right;
            }

            // Stop if we've reached the end of the heap
            // Or stop when everything is already in the right position
            if (left >= heapSize || more(nodeIndex, smallest)){
                break;
            }

            // Move down the tree following the smallest node
            // Keeps swapping (Which means move down the binary heap tree)
            swap(smallest, nodeIndex);
            nodeIndex = smallest;
        }
    }

    private void swap (int i, int j){
        T iElement = heap[i];
        T jElement = heap[j];

        // Swaps the value in both index
        heap[i] = jElement;
        heap[j] = iElement;
    }

    @Override
    public boolean remove(T element){
        if (element == null) return false;

        // Removes element if it exists in the heap array, and it matches the input value
        for(int i = 0; i < this.heapSize; i++) {
            if (element.equals(heap[i])){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T removeAt(int i){
        if (isEmpty()) return null;

        heapSize--;
        T removedData = heap[i];
        // We need to swap the remove element to the last in order to fill in the empty space in Heap array
        swap(i, heapSize);

        // Obliterate the value (Convert the remove Node value to null)
        heap[heapSize] = null;

        // Remove last element. If the removed element is the
        if (i == heapSize) return removedData;

        T element = heap[i];

        // Sink the element so that it reaches it's correct place
        sink(i);
        if (heap[i].equals(element)){
            // If the element remains at the same place after sinking
            // It may mean that the element needs to swim up instead of sink
            swim(i);
        }
        return removedData;
    }
    // --------------------------------------------------------------------------------------------------------------
}