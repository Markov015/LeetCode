struct Node {
    int key, value;
    Node* prev;
    Node* next;
    Node(int key = 0, int value = 0, Node* prev = nullptr, Node* next = nullptr): key(key), value(value), prev(prev), next(next) {}
};

class LRUCache {
private:
    map<int, Node*> mp;
    Node* dummyHead;
    Node* tail;
    int capacity;
    int size;
public:
    LRUCache(int capacity): capacity(capacity), size(0) {
        dummyHead = new Node();
        tail = dummyHead;
    }

    int get(int key) {
        Node* ptr = mp[key];
        if (ptr) {
            ptr->prev->next = ptr->next;
            ptr->next->prev = ptr->prev;
            tail->next = ptr;
            ptr->prev = tail;
            ptr->next = nullptr;
            tail = ptr;
            return tail->value;
        } else {
            return -1;
        }
    }

    void put(int key, int value) {
        Node* ptr = mp[key];
        if (ptr) {
            ptr->value = value;
            ptr->prev->next = ptr->next;
            ptr->next->prev = ptr->prev;
            tail->next = ptr;
            ptr->prev = tail;
            ptr->next = nullptr;
            tail = ptr;
        } else { // 指针不存在
            if(size == capacity) {
                Node *del = dummyHead->next;
                dummyHead->next = del->next;
                del->next->prev = dummyHead;
                if (del == tail) {
                    tail = dummyHead;
                }
                mp[del->key] = nullptr;
                delete del;
                --size;
            }
            tail->next = new Node(key, value, tail);
            tail = tail->next;
            ++size;
            mp[key] = tail;
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
