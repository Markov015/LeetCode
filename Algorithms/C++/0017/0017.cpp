class Solution {
public:
    vector<string> res;
    vector<vector<char>> map = {
        {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
        {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    vector<string> letterCombinations(string digits) {
        if (!digits.empty()) {
            DFS(digits, 0, "");
        }
        return res;
    }
    void DFS(string digits, int i, string t) {
        if (i == digits.length()) {
            res.push_back(t);
            return;
        }
        for (char ch : map[digits[i] - '0']) {
            DFS(digits, i + 1, t + ch);
        }
    }
};
