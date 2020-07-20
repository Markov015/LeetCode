struct Node {
    int key, value;
    Node* prev;
    Node* next;
    Node(int key = 0, int value = 0, Node* prev = nullptr, Node* next = nullptr):
        key(key), value(value), prev(prev), next(next) {}
};

class LRUCache {
private:
    unordered_map<int, Node*> cache;
    Node* dummyHead;
    Node* dummyTail;
    int size;
    int capacity;

public:
    LRUCache(int capacity): capacity(capacity), size(0) {
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead->next = dummyTail;
        dummyTail->next = dummyHead;
    }

    int get(int key) {
        Node* node = cache[key];
        if (node) {
            moveToHead(node);
            return node->value;
        } else {
            return -1;
        }
    }

    void put(int key, int value) {
        Node* node = cache[key];
        if (node) {
            // 若key对应的节点存在，则更新其value，然后移至链表头部
            node->value = value;
            moveToHead(node);
        } else {
            // 若key对应的节点不存在
            // 若cache已满，则更新cache和size，并删除尾部节点
            if (size == capacity) {
                cache[dummyTail->prev->key] = nullptr;
                --size;
                removeTail();
            }
            // 新建一个节点，更新cache和size，然后将其添加至链表头部
            node = new Node(key, value);
            cache[key] = node;
            ++size;
            addToHead(node);
        }
    }

private:
    void moveToHead(Node* node) {
        // 将node从链表上摘下
        node->prev->next = node->next;
        node->next->prev = node->prev;
        // 将node添加至头部
        addToHead(node);
    }

    void addToHead(Node* node) {
        node->next = dummyHead->next;
        node->prev = dummyHead;
        dummyHead->next = node;
        node->next->prev = node;
    }

    void removeTail() {
        Node* del = dummyTail->prev;
        del->prev->next = del->next;
        del->next->prev = del->prev;
        delete del;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
