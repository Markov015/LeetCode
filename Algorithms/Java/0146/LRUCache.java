public class LRUCache {
    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
        public Node() {
            this.key = 0;
            this.value = 0;
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache  = new HashMap<>();;
    private Node dummyHead;
    private Node dummyTail;
    private int capacity;
    private int size = 0;

    public LRUCache(int capacity) {
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // key对应的节点存在
            Node node = cache.get(key);
            // 将其移至链表头部
            moveToHead(node);
            return node.value;
        } else {
            // key对应的节点不存在
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // key对应的节点存在
            Node node = cache.get(key);
            // 更新value
            node.value = value;
            // 将其移至链表头部
            moveToHead(node);
        } else {
            // key对应的节点不存在
            // 若cache已满
            if (size == capacity) {
                // 移除链表尾部节点
                // 更新cache和size
                Node tail = dummyTail.prev;
                removeTail();
                cache.remove(tail.key);
                --size;
            }
            // cache有剩余空间
            // 新建一个节点，将其添加至链表头部
            // 更新cache和size
            Node node = new Node(key, value);
            addToHead(node);
            cache.put(key, node);
            ++size;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next = node;
        node.next.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void removeTail() {
        removeNode(dummyTail.prev);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
