class MyHashSet {
    static final int SIZE = 1009; // Hash表大小
    private Bucket[] buckets;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new Bucket[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            buckets[i] = new Bucket();
        }
    }

    public void add(int key) {
        int bucketIndex = this.hash(key);
        if (!buckets[bucketIndex].contains(key)) {
            buckets[bucketIndex].add(key);
        }
    }

    public void remove(int key) {
        int bucketIndex = this.hash(key);
        buckets[bucketIndex].remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this.hash(key);
        return buckets[bucketIndex].contains(key);
    }

    private int hash(int key) {
        return key % SIZE;
    }
}

class Bucket {
    private List<Integer> list;

    public Bucket() {
        this.list = new LinkedList<>();
    }

    public void add(int key) {
        this.list.add(key);
    }

    public void remove(int key) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == key) {
                it.remove();
                break;
            }
        }
    }

    public boolean contains(int key) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == key) {
                return true;
            }
        }
        return false;
    }
}
