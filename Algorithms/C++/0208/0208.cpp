class Trie {
private:
    struct TrieNode {
        bool isKey;
        array<TrieNode*, 26> children;
        TrieNode(bool isKey = false) :isKey(isKey) {
            children.fill(nullptr);
        }
    };
    TrieNode* root;
    void destory(TrieNode* node) {
        if (node == nullptr) {
            return;
        }
        for (TrieNode* child : node->children) {
            destory(child);
        }
        delete node;
        node = nullptr;
    }
public:
    /** Initialize your data structure here. */
    Trie(): root(new TrieNode()) {}

    ~Trie() {
        destory(root);
    }

    /** Inserts a word into the trie. */
    void insert(const string& word) {
        if (word.empty()) {
            return;
        }
        TrieNode* cur = root;
        for (const char& ch : word) {
            size_t index = ch - 'a';
            if (cur->children[index] == nullptr) {
                cur->children[index] = new TrieNode();
            }
            cur = cur->children[index];
        }
        cur->isKey = true;
    }

    /** Returns if the word is in the trie. */
    bool search(const string& word) {
        if (word.empty()) {
            return true;
        }
        TrieNode* cur = root;
        for (const char& ch : word) {
            size_t index = ch - 'a';
            if (cur->children[index] == nullptr) {
                return false;
            }
            cur = cur->children[index];
        }
        return cur->isKey;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(const string& prefix) {
        if (prefix.empty()) {
            return true;
        }
        TrieNode* cur = root;
        for (const char& ch : prefix) {
            int index = ch - 'a';
            if (cur->children[index] == nullptr) {
                return false;
            }
            cur = cur->children[index];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
