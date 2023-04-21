package adt;
// Name : Tan Jun Keat
// ID   : 21WMR12547
public class MyHashMap<K, V> implements HashMapInterface<K, V>{

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private float loadFactor;
    private Entry<K, V>[] table;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.table = new Entry[capacity];
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null.");
        }

        if (size >= loadFactor * capacity) {
            resizeTable();
        }

        int hash = key.hashCode() % capacity;
        Entry<K, V> e = table[hash];

        while (e != null) {
            if (e.getKey().equals(key)) {
                e.setValue(value);
                return;
            }
            e = e.next;
        }

        table[hash] = new Entry<K, V>(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode() % capacity;
        Entry<K, V> e = table[hash];

        while (e != null) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
            e = e.next;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int hash = key.hashCode() % capacity;
        Entry<K, V> e = table[hash];
        Entry<K, V> prev = null;

        while (e != null) {
            if (e.getKey().equals(key)) {
                if (prev == null) {
                    table[hash] = e.next;
                } else {
                    prev.next = e.next;
                }
                size--;
                return e.getValue();
            }
            prev = e;
            e = e.next;
        }

        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int hash = key.hashCode() % capacity;
        Entry<K, V> e = table[hash];

        while (e != null) {
            if (e.getKey().equals(key)) {
                return true;
            }
            e = e.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public void resizeTable() {
        capacity *= 2;
        Entry<K, V>[] newTable = new Entry[capacity];
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> e = table[i];
            while (e != null) {
                Entry<K, V> next = e.next;
                int hash = e.getKey().hashCode() % capacity;
                e.next = newTable[hash];
                newTable[hash] = e;
                e = next;
            }
        }
        table = newTable;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> e = table[i];
            while (e != null) {
                if (e.getValue().equals(value)) {
                    return true;
                }
                e = e.next;
            }
        }
        return false;
    }
}