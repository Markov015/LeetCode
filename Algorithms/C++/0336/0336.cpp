// Trie
class Trie {
private:
    struct TrieNode {
        int id; // 若id不为-1，则表示它是一个单词，且在words中的索引为id
        array<TrieNode*, 26> children;
        TrieNode(int _id = -1): id(_id) {
            children.fill(nullptr);
        }
    };

    TrieNode* root;

public:
    Trie(): root(new TrieNode) {}

    void insert(const string& word, int id) {
        TrieNode* cur = root;
        for (const char& ch : word) {
            size_t index = ch - 'a';
            if (cur->children[index] == nullptr) {
                cur->children[index] = new TrieNode();
            }
            cur = cur->children[index];
        }
        cur->id = id;
    }

    // 在Trie中搜索word的逆转，返回其id，id为-1表示不存在
    int searchReverse(const string& word) {
        TrieNode* cur = root;
        for (int i = word.size() - 1; i >= 0; i--) {
            char ch = word[i];
            size_t index = ch - 'a';
            if (cur->children[index] == nullptr) {
                return -1;
            }
            cur = cur->children[index];
        }
        return cur->id;
    }
};

class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        vector<vector<int>> res;
        Trie trie;
        for (int i = 0; i < words.size(); i++) {
            trie.insert(words[i], i);
        }
        for (int i = 0; i < words.size(); i++) {
            const string& word = words[i];
            int n = word.size();
            for (int j = 0; j <= n; j++) {
                string prefix = word.substr(0, j);
                string remainder = word.substr(j);
                if (isPalindrome(remainder)) {
                    int prefixReverseId = trie.searchReverse(prefix);
                    if (prefixReverseId != -1 && prefixReverseId != i) {
                        res.push_back({i, prefixReverseId});
                    }
                }
                if (j == n) {
                    continue;
                }
                string suffix = word.substr(n - j, j);
                remainder = word.substr(0, n - j);
                if (isPalindrome(remainder)) {
                    int suffixReverseId = trie.searchReverse(suffix);
                    if (suffixReverseId != -1 && suffixReverseId != i) {
                        res.push_back({suffixReverseId, i});
                    }
                }
            }
        }
        return res;
    }

    bool isPalindrome(const string& word) {
        int n = word.size();
        for (int i = 0; i < n / 2; i++) {
            if (word[i] != word[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }
};
