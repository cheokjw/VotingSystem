package adt;
// Name : Cheok Jia Wei
// Student ID : 21WMR12521
// T extends Comparable <T> because T must be a type parameter where it must support comparison with other instances of its own Type
public interface PriorityQueueInterface<T> {

    // Adds a new Entry into the Queue
    boolean add(T newEntry);

    // Removes a specific element in PQ.
    boolean remove(T element);

    T removeAt(int index);

    // Get value at index
    T get(int index);

    // Checks if PQ is empty or not
    boolean isEmpty();

    // Returns true if PQ contains certain element. Returns false if DNE
    boolean contains(T element);

    // Rearrange the PQ since the nature of vote count is that it'll change. Returns true if successfully update, runs add if the element is not in PQ
    boolean update(T element);

    // Removes and return the element with the highest priority
    T poll();

    // Returns the first element in PQ but does not remove it
    T peek();

    // Returns the size of PQ in form of integer
    int size();

    // Returns True if successfully clears the PQ, return false if PQ was already empty
    boolean clear();

}
